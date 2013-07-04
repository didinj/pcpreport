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
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jdbc:derby:Pcpreport;create=true");
    
    public void processData(Date from, Date to, String unit, String subunit) {
        DateFormat fmtdate = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat fmttime = new SimpleDateFormat("HH:mm:ss");
        EntityManager em = emf.createEntityManager();
        Query empQuery = em.createNamedQuery("Employee.findAll");
        List<Employee> emps = empQuery.getResultList();
        GregorianCalendar gc = new GregorianCalendar();
        for (Employee emp : emps) {
            Query query1 = em.createQuery("SELECT p FROM Pcp p WHERE p.nik=:nik AND p.tgl>=:dateFrom AND p.tgl<=:dateTo ORDER BY p.tgl,p.jam");
            query1.setParameter("nik", emp.getNik());
            query1.setParameter("dateFrom", from);
            query1.setParameter("dateTo", to);
            List<Pcp> pcp = query1.getResultList();
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
                    JOptionPane.showMessageDialog(null, "Report dari tgl " + fmtdate.format(from) + " sampai tgl " + fmtdate.format(to) + " unit "+unit+" telah di simpan");
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

}
