/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FADHILAH
 */
@Entity
@Table(name = "PCP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pcp.findAll", query = "SELECT p FROM Pcp p"),
    @NamedQuery(name = "Pcp.findById", query = "SELECT p FROM Pcp p WHERE p.id = :id"),
    @NamedQuery(name = "Pcp.findByNik", query = "SELECT p FROM Pcp p WHERE p.nik = :nik"),
    @NamedQuery(name = "Pcp.findByTgl", query = "SELECT p FROM Pcp p WHERE p.tgl = :tgl"),
    @NamedQuery(name = "Pcp.findByJam", query = "SELECT p FROM Pcp p WHERE p.jam = :jam"),
    @NamedQuery(name = "Pcp.findByLok", query = "SELECT p FROM Pcp p WHERE p.lok = :lok")})
public class Pcp implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Column(name = "TGL")
    @Temporal(TemporalType.DATE)
    private Date tgl;
    @Column(name = "JAM")
    @Temporal(TemporalType.TIME)
    private Date jam;
    @Column(name = "LOK")
    private String lok;

    public Pcp() {
    }

    public Pcp(Integer id) {
        this.id = id;
    }

    public Pcp(Integer id, String nik) {
        this.id = id;
        this.nik = nik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        String oldNik = this.nik;
        this.nik = nik;
        changeSupport.firePropertyChange("nik", oldNik, nik);
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        Date oldTgl = this.tgl;
        this.tgl = tgl;
        changeSupport.firePropertyChange("tgl", oldTgl, tgl);
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        Date oldJam = this.jam;
        this.jam = jam;
        changeSupport.firePropertyChange("jam", oldJam, jam);
    }

    public String getLok() {
        return lok;
    }

    public void setLok(String lok) {
        String oldLok = this.lok;
        this.lok = lok;
        changeSupport.firePropertyChange("lok", oldLok, lok);
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
        if (!(object instanceof Pcp)) {
            return false;
        }
        Pcp other = (Pcp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pcpreports.Pcp[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
