/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

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
    @NamedQuery(name = "Employee.findByRfid", query = "SELECT e FROM Employee e WHERE e.rfid = :rfid")})
public class Employee implements Serializable {
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
    @Column(name = "RFID")
    private String rfid;

    public Employee() {
    }

    public Employee(String nik) {
        this.nik = nik;
    }

    public Employee(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Integer getRegu() {
        return regu;
    }

    public void setRegu(Integer regu) {
        this.regu = regu;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pcpreports.Employee[ nik=" + nik + " ]";
    }
    
}
