/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author FADHILAH
 */
public class Pcpimport {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PcpreportPU");

    @SuppressWarnings({"CallToThreadDumpStack", "UseSpecificCatch"})
    public void getdatafromsd(String unit, String subunit, String driveletter) {
        String loc, D, M, Y, h, m, s, cols;
        String line, text, waktu, NIK, tanggal, jam;
        DateFormat timeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat jamFormat = new SimpleDateFormat("hh:mm");
        File dir = new File(driveletter);
        try {
            File files[] = dir.listFiles();
            for (File f : files) {
                if (f.getName().endsWith(".txt")) {
                    if (f.getName().length() == 10) {
                        EntityManager logem = emf.createEntityManager();
                        Query logquery = logem.createQuery("SELECT i FROM Importlog i WHERE i.filename=:filename");
                        logquery.setParameter("filename", unit + "" + subunit + "" + f.getName().toString().trim());
                        List logresult = logquery.getResultList();
                        if (logresult.isEmpty()) {
                            FileInputStream fis = new FileInputStream(f);
                            BufferedInputStream bis = new BufferedInputStream(fis);
                            DataInputStream dis = new DataInputStream(bis);
                            while ((line = dis.readLine()) != null) {
                                StringTokenizer stk = new StringTokenizer(line, ";");
                                while (stk.hasMoreTokens()) {
                                    cols = stk.nextToken();
                                    text = cols.replaceAll(" ", "").trim();
                                    if (text.length() == 26 && !text.isEmpty()) {
                                        loc = text.substring(0, 3);
                                        NIK = text.substring(3, 11);
                                        D = text.substring(14, 16);
                                        M = text.substring(16, 18);
                                        Y = text.substring(18, 20);
                                        h = text.substring(20, 22);
                                        m = text.substring(22, 24);
                                        s = text.substring(24, 26);
                                        waktu = "20" + Y + "/" + M + "/" + D + " " + h + ":" + m + ":" + s;
                                        jam = h + ":" + m;
                                        tanggal = M + "/" + D + "/20" + Y;
                                        Date udate = dateFormat.parse(tanggal);
                                        Date utime = timeFormat.parse(waktu);
                                        Calendar cal = Calendar.getInstance();
                                        cal.setTime(utime);
                                        cal.add(Calendar.MINUTE, 2);
                                        Date totime = cal.getTime();
                                        cal.setTime(utime);
                                        cal.add(Calendar.MINUTE, -2);
                                        Date fromtime = cal.getTime();
                                        EntityManager em = emf.createEntityManager();
                                        Query query = em.createQuery("SELECT p FROM Pcp p WHERE p.nik=:nik AND p.tgl=:tgl AND p.jam BETWEEN :jamstart AND :jamend AND p.lok=:loc");
                                        query.setParameter("nik", NIK.trim());
                                        query.setParameter("tgl", udate);
                                        query.setParameter("jamstart", fromtime);
                                        query.setParameter("jamend", totime);
                                        query.setParameter("loc", loc);
                                        List<Pcp> pcplist = query.getResultList();
                                        if (pcplist.isEmpty()) {
                                            Pcp pcp = new Pcp();
                                            try {
                                                pcp.setUnitcode(unit);
                                                pcp.setSubunit(subunit);
                                                pcp.setNik(NIK);
                                                pcp.setTgl(udate);
                                                pcp.setJam(utime);
                                                pcp.setLok(loc);
                                                em.getTransaction().begin();
                                                em.persist(pcp);
                                                em.flush();
                                                em.getTransaction().commit();
                                            } catch (Exception e) {
                                                em.getTransaction().rollback();
                                            } finally {
                                                if (em.getTransaction().isActive()) {
                                                    em.close();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Importlog il = new Importlog();
                            try {
                                il.setFilename(unit + "" + subunit + "" + f.getName().toString().trim());
                                logem.getTransaction().begin();
                                logem.persist(il);
                                logem.flush();
                                logem.getTransaction().commit();
                            } catch (Exception e) {
                                logem.getTransaction().rollback();
                            } finally {
                                if (logem.getTransaction().isActive()) {
                                    logem.close();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putdatatosd(String unit, String subunit, String driveletter) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.unit=:unit AND e.subunit=:subunit");
        query.setParameter("unit", unit);
        query.setParameter("subunit", subunit);
        List<Employee> emplist = query.getResultList();
        Query query2 = em.createQuery("SELECT l FROM Location l WHERE l.locunit=:unit AND l.locsubunit=:subunit");
        query2.setParameter("unit", unit);
        query2.setParameter("subunit", subunit);
        List<Location> loclist = query2.getResultList();
        File oldfile = new File(driveletter, "empfile.txt");
        if (oldfile.exists()) {
            oldfile.delete();
            File newfile = new File(driveletter, "empfile.txt");
            try {
                Writer writer = new BufferedWriter(new FileWriter(newfile));
                Iterator it = emplist.iterator();
                while (it.hasNext()) {
                    Employee emp = (Employee) it.next();
                    writer.append("" + emp.getRfid() + "" + emp.getNik() + "");
                    if (it.hasNext()) {
                        writer.append(",");
                    }
                }
                writer.append(",");
                Iterator it2 = loclist.iterator();
                while (it2.hasNext()) {
                    Location loc = (Location) it2.next();
                    writer.append("" + loc.getLocrfid() + "" + loc.getLoccode() + "");
                    if (it2.hasNext()) {
                        writer.append(",");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                oldfile.createNewFile();
                Writer writer = new BufferedWriter(new FileWriter(oldfile));
                Iterator it = emplist.iterator();
                while (it.hasNext()) {
                    Employee emp = (Employee) it.next();
                    writer.append("" + emp.getRfid() + "" + emp.getNik() + "");
                    if (it.hasNext()) {
                        writer.append(",");
                    }
                }
                Iterator it2 = loclist.iterator();
                writer.append(",");
                while (it2.hasNext()) {
                    Location loc = (Location) it2.next();
                    writer.append("" + loc.getLocrfid() + "" + loc.getLoccode() + "");
                    if (it2.hasNext()) {
                        writer.append(",");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
