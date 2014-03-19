/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.awt.Cursor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author FADHILAH
 */
public class Reportprocess {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PcpreportPU");

    public void processData(Date from, Date to, String unit, String subunit) {
        DateFormat fmtdate = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat fmttime = new SimpleDateFormat("HH:mm:ss");
        EntityManager em = emf.createEntityManager();
        Query empQuery = em.createNamedQuery("Employee.findByUnit");
        empQuery.setParameter("unit", unit);
        List<Employee> emps = empQuery.getResultList();
        GregorianCalendar gc = new GregorianCalendar();
        List<Location> loc = (List<Location>) em.createQuery("SELECT l FROM Location l WHERE l.locunit=:unit AND l.locsubunit=:subunit AND l.locname='ABSENSI'").setParameter("unit", unit).setParameter("subunit", subunit).getResultList();
        for (Employee emp : emps) {
            List<Pcp> pcp = null;
            if (!loc.isEmpty()) {
                Query query1 = em.createQuery("SELECT p FROM Pcp p WHERE p.nik=:nik AND p.tgl>=:dateFrom AND p.tgl<=:dateTo and p.lok<>:lokode ORDER BY p.tgl,p.jam");
                query1.setParameter("nik", emp.getNik());
                query1.setParameter("dateFrom", from);
                query1.setParameter("dateTo", to);
                query1.setParameter("lokode", loc.get(0).getLoccode());
                pcp = query1.getResultList();
            } else {
                Query query1 = em.createQuery("SELECT p FROM Pcp p WHERE p.nik=:nik AND p.tgl>=:dateFrom AND p.tgl<=:dateTo ORDER BY p.tgl,p.jam");
                query1.setParameter("nik", emp.getNik());
                query1.setParameter("dateFrom", from);
                query1.setParameter("dateTo", to);
                pcp = query1.getResultList();
            }
            for (Pcp p : pcp) {
                Report rep = new Report();
                try {
                    rep.setUnit(unit);
                    rep.setSubunit(subunit);
                    rep.setNik(emp.getNik());
                    rep.setNama(emp.getNama());
                    rep.setRegu(emp.getRegu());
                    rep.setTgl(p.getTgl());
                    rep.setJam(p.getJam());
                    rep.setLokasi(p.getLok());
                    em.getTransaction().begin();
                    em.persist(rep);
                    em.flush();
                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    e.printStackTrace();
                } finally {
                    if (em.getTransaction().isActive()) {
                        em.close();
                    }
                }
            }
        }
        em.close();
    }

    public void processAbsensi(Date from, Date to, String unit, String subunit) {
        DateFormat fmtdate = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat fmttime = new SimpleDateFormat("HH:mm:ss");
        EntityManager em = emf.createEntityManager();
        Query empQuery = em.createNamedQuery("Employee.findByUnit");
        empQuery.setParameter("unit", unit);
        List<Employee> emps = empQuery.getResultList();
        GregorianCalendar gc = new GregorianCalendar();
        List<Location> loc = (List<Location>) em.createQuery("SELECT l FROM Location l WHERE l.locunit=:unit AND l.locsubunit=:subunit AND l.locname='ABSENSI'").setParameter("unit", unit).setParameter("subunit", subunit).getResultList();
        for (Employee emp : emps) {
            if (!loc.isEmpty()) {
                Query query1 = em.createQuery("SELECT p FROM Pcp p WHERE p.nik=:nik AND p.tgl>=:dateFrom AND p.tgl<=:dateTo and p.lok=:lokode ORDER BY p.tgl,p.jam");
                query1.setParameter("nik", emp.getNik());
                query1.setParameter("dateFrom", from);
                query1.setParameter("dateTo", to);
                query1.setParameter("lokode", loc.get(0).getLoccode());
                List<Pcp> pcp = query1.getResultList();
                for (Pcp p : pcp) {
                    List<Absensi> labs = (List<Absensi>) em.createQuery("SELECT a FROM Absensi a WHERE a.unit=:unit AND a.subunit=:subunit AND a.nik=:nik AND a.bulan=:bulan AND a.tahun=:tahun").setParameter("unit", unit).setParameter("subunit", subunit).setParameter("nik", p.getNik()).setParameter("bulan", new SimpleDateFormat("MMMMM").format(p.getTgl()).toString()).setParameter("tahun", new SimpleDateFormat("yyyy").format(p.getTgl()).toString()).getResultList();
                    if (labs.isEmpty()) {
                        Absensi abs = new Absensi();
                        try {
                            abs.setUnit(p.getUnitcode());
                            abs.setSubunit(p.getSubunit());
                            abs.setNik(p.getNik());
                            abs.setNama(emp.getNama());
                            abs.setBulan(new SimpleDateFormat("MMMMM").format(p.getTgl()).toString());
                            abs.setTahun(new SimpleDateFormat("yyyy").format(p.getTgl()).toString());
                            String tgl = new SimpleDateFormat("dd").format(p.getTgl()).toString();
                            switch (tgl) {
                                case "01":
                                    abs.setH1("V");
                                    break;
                                case "02":
                                    abs.setH2("V");
                                    break;
                                case "03":
                                    abs.setH3("V");
                                    break;
                                case "04":
                                    abs.setH4("V");
                                    break;
                                case "05":
                                    abs.setH5("V");
                                    break;
                                case "06":
                                    abs.setH6("V");
                                    break;
                                case "07":
                                    abs.setH7("V");
                                    break;
                                case "08":
                                    abs.setH8("V");
                                    break;
                                case "09":
                                    abs.setH9("V");
                                    break;
                                case "10":
                                    abs.setH10("V");
                                    break;
                                case "11":
                                    abs.setH11("V");
                                    break;
                                case "12":
                                    abs.setH12("V");
                                    break;
                                case "13":
                                    abs.setH13("V");
                                    break;
                                case "14":
                                    abs.setH14("V");
                                    break;
                                case "15":
                                    abs.setH15("V");
                                    break;
                                case "16":
                                    abs.setH16("V");
                                    break;
                                case "17":
                                    abs.setH17("V");
                                    break;
                                case "18":
                                    abs.setH18("V");
                                    break;
                                case "19":
                                    abs.setH19("V");
                                    break;
                                case "20":
                                    abs.setH20("V");
                                    break;
                                case "21":
                                    abs.setH21("V");
                                    break;
                                case "22":
                                    abs.setH22("V");
                                    break;
                                case "23":
                                    abs.setH23("V");
                                    break;
                                case "24":
                                    abs.setH24("V");
                                    break;
                                case "25":
                                    abs.setH25("V");
                                    break;
                                case "26":
                                    abs.setH26("V");
                                    break;
                                case "27":
                                    abs.setH27("V");
                                    break;
                                case "28":
                                    abs.setH28("V");
                                    break;
                                case "29":
                                    abs.setH29("V");
                                    break;
                                case "30":
                                    abs.setH30("V");
                                    break;
                                case "31":
                                    abs.setH31("V");
                                    break;
                            }
                            em.getTransaction().begin();
                            em.persist(abs);
                            em.flush();
                            em.getTransaction().commit();
                        } catch (Exception e) {
                            em.getTransaction().rollback();
                            e.printStackTrace();
                        } finally {
                            if (em.getTransaction().isActive()) {
                                em.close();
                            }
                        }
                    } else {
                        try {
                            Absensi abs = em.find(Absensi.class, labs.get(0).getId());
                            String tgl = new SimpleDateFormat("dd").format(p.getTgl()).toString();
                            em.getTransaction().begin();
                            switch(tgl) {
                                case "01":
                                    abs.setH1("V");
                                    break;
                                case "02":
                                    abs.setH2("V");
                                    break;
                                case "03":
                                    abs.setH3("V");
                                    break;
                                case "04":
                                    abs.setH4("V");
                                    break;
                                case "05":
                                    abs.setH5("V");
                                    break;
                                case "06":
                                    abs.setH6("V");
                                    break;
                                case "07":
                                    abs.setH7("V");
                                    break;
                                case "08":
                                    abs.setH8("V");
                                    break;
                                case "09":
                                    abs.setH9("V");
                                    break;
                                case "10":
                                    abs.setH10("V");
                                    break;
                                case "11":
                                    abs.setH11("V");
                                    break;
                                case "12":
                                    abs.setH12("V");
                                    break;
                                case "13":
                                    abs.setH13("V");
                                    break;
                                case "14":
                                    abs.setH14("V");
                                    break;
                                case "15":
                                    abs.setH15("V");
                                    break;
                                case "16":
                                    abs.setH16("V");
                                    break;
                                case "17":
                                    abs.setH17("V");
                                    break;
                                case "18":
                                    abs.setH18("V");
                                    break;
                                case "19":
                                    abs.setH19("V");
                                    break;
                                case "20":
                                    abs.setH20("V");
                                    break;
                                case "21":
                                    abs.setH21("V");
                                    break;
                                case "22":
                                    abs.setH22("V");
                                    break;
                                case "23":
                                    abs.setH23("V");
                                    break;
                                case "24":
                                    abs.setH24("V");
                                    break;
                                case "25":
                                    abs.setH25("V");
                                    break;
                                case "26":
                                    abs.setH26("V");
                                    break;
                                case "27":
                                    abs.setH27("V");
                                    break;
                                case "28":
                                    abs.setH28("V");
                                    break;
                                case "29":
                                    abs.setH29("V");
                                    break;
                                case "30":
                                    abs.setH30("V");
                                    break;
                                case "31":
                                    abs.setH31("V");
                                    break;
                            }
                            em.getTransaction().commit();
                        } catch (Exception e) {
                            em.getTransaction().rollback();
                            e.printStackTrace();
                        } finally {
                            if (em.getTransaction().isActive()) {
                                em.close();
                            }
                        }
                    }
                }
            }
        }
        em.close();
    }
}
