/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FADHILAH
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByNik", query = "SELECT e FROM Employee e WHERE e.nik = :nik"),
    @NamedQuery(name = "Employee.findByNama", query = "SELECT e FROM Employee e WHERE e.nama = :nama"),
    @NamedQuery(name = "Employee.findByJabatan", query = "SELECT e FROM Employee e WHERE e.jabatan = :jabatan"),
    @NamedQuery(name = "Employee.findByRegu", query = "SELECT e FROM Employee e WHERE e.regu = :regu"),
    @NamedQuery(name = "Employee.findByUnit", query = "SELECT e FROM Employee e WHERE e.unit = :unit"),
    @NamedQuery(name = "Employee.findBySubunit", query = "SELECT e FROM Employee e WHERE e.subunit = :subunit"),
    @NamedQuery(name = "Employee.findByRfid", query = "SELECT e FROM Employee e WHERE e.rfid = :rfid")})
public class Employee implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JABATAN")
    private String jabatan;
    @Column(name = "REGU")
    private Integer regu;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "SUBUNIT")
    private String subunit;
    @Column(name = "RFID")
    private String rfid;

    public Employee() {
    }

    public Employee(String nik, String nama, String jabatan, Integer regu, String unit, String subunit, String rfid) {
        this.nik = nik;
        this.nama = nama;
        this.jabatan = jabatan;
        this.regu = regu;
        this.unit = unit;
        this.subunit = subunit;
        this.rfid = rfid;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        String oldJabatan = this.jabatan;
        this.jabatan = jabatan;
        changeSupport.firePropertyChange("jabatan", oldJabatan, jabatan);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        String oldNama = this.nama;
        this.nama = nama;
        changeSupport.firePropertyChange("nama", oldNama, nama);
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        String oldNik = this.nik;
        this.nik = nik;
        changeSupport.firePropertyChange("nik", oldNik, nik);
    }

    public Integer getRegu() {
        return regu;
    }

    public void setRegu(Integer regu) {
        Integer oldRegu = this.regu;
        this.regu = regu;
        changeSupport.firePropertyChange("regu", oldRegu, regu);
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        String oldRfid = this.rfid;
        this.rfid = rfid;
        changeSupport.firePropertyChange("rfid", oldRfid, rfid);
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        String oldSubunit = this.subunit;
        this.subunit = subunit;
        changeSupport.firePropertyChange("subunit", oldSubunit, subunit);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        String oldUnit = this.unit;
        this.unit = unit;
        changeSupport.firePropertyChange("unit", oldUnit, unit);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
