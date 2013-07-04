/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FADHILAH
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findById", query = "SELECT r FROM Report r WHERE r.id = :id"),
    @NamedQuery(name = "Report.findByUnit", query = "SELECT r FROM Report r WHERE r.unit = :unit"),
    @NamedQuery(name = "Report.findBySubunit", query = "SELECT r FROM Report r WHERE r.subunit = :subunit"),
    @NamedQuery(name = "Report.findByNik", query = "SELECT r FROM Report r WHERE r.nik = :nik"),
    @NamedQuery(name = "Report.findByNama", query = "SELECT r FROM Report r WHERE r.nama = :nama"),
    @NamedQuery(name = "Report.findByRegu", query = "SELECT r FROM Report r WHERE r.regu = :regu"),
    @NamedQuery(name = "Report.findByTgl", query = "SELECT r FROM Report r WHERE r.tgl = :tgl"),
    @NamedQuery(name = "Report.findByJam", query = "SELECT r FROM Report r WHERE r.jam = :jam"),
    @NamedQuery(name = "Report.findByLokasi", query = "SELECT r FROM Report r WHERE r.lokasi = :lokasi")})
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "SUBUNIT")
    private String subunit;
    @Column(name = "NIK")
    private String nik;
    @Basic(optional = false)
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "REGU")
    private Integer regu;
    @Column(name = "TGL")
    @Temporal(TemporalType.DATE)
    private Date tgl;
    @Column(name = "JAM")
    @Temporal(TemporalType.TIME)
    private Date jam;
    @Column(name = "LOKASI")
    private String lokasi;

    public Report() {
    }

    public Report(Integer id) {
        this.id = id;
    }

    public Report(Integer id, String nik, String nama) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
    }

    public Report(String unit, String subunit, String nik, String nama, Integer regu, Date tgl, Date jam, String lokasi) {
        this.unit = unit;
        this.subunit = subunit;
        this.nik = nik;
        this.nama = nama;
        this.regu = regu;
        this.tgl = tgl;
        this.jam = jam;
        this.lokasi = lokasi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Integer getRegu() {
        return regu;
    }

    public void setRegu(Integer regu) {
        this.regu = regu;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pcpreports.Report[ id=" + id + " ]";
    }
    
}
