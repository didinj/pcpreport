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
    @NamedQuery(name = "Pcp.findByUnitcode", query = "SELECT p FROM Pcp p WHERE p.unitcode = :unitcode"),
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
    @Column(name = "UNITCODE")
    private String unitcode;
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

    public Pcp(Integer id, String unitcode, String nik, Date tgl, Date jam, String lok) {
        this.id = id;
        this.unitcode = unitcode;
        this.nik = nik;
        this.tgl = tgl;
        this.jam = jam;
        this.lok = lok;
    }

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }

    public String getLok() {
        return lok;
    }

    public void setLok(String lok) {
        this.lok = lok;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }
   
}
