/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author FADHILAH
 */
public class Pcpimport {
    
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jdbc:derby:Pcpreport;create=true");
    
    @SuppressWarnings({"CallToThreadDumpStack", "UseSpecificCatch"})
    public void getdatafromsd(String driveletter) {
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
                        logquery.setParameter("filename", f.getName().toString().trim());
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
                                il.setFilename(f.getName().toString().trim());
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
}
