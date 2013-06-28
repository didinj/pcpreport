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
@Table(name = "SUBUNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subunit.findAll", query = "SELECT s FROM Subunit s"),
    @NamedQuery(name = "Subunit.findBySubunitcode", query = "SELECT s FROM Subunit s WHERE s.subunitcode = :subunitcode"),
    @NamedQuery(name = "Subunit.findBySubunitname", query = "SELECT s FROM Subunit s WHERE s.subunitname = :subunitname"),
    @NamedQuery(name = "Subunit.findByUnitcode", query = "SELECT s FROM Subunit s WHERE s.unitcode = :unitcode")})
public class Subunit implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "SUBUNITCODE")
    private String subunitcode;
    @Column(name = "SUBUNITNAME")
    private String subunitname;
    @Column(name = "UNITCODE")
    private String unitcode;

    public Subunit() {
    }

    public Subunit(String subunitcode, String subunitname, String unitcode) {
        this.subunitcode = subunitcode;
        this.subunitname = subunitname;
        this.unitcode = unitcode;
    }

    public String getSubunitcode() {
        return subunitcode;
    }

    public void setSubunitcode(String subunitcode) {
        String oldSubunitcode = this.subunitcode;
        this.subunitcode = subunitcode;
        changeSupport.firePropertyChange("subunitcode", oldSubunitcode, subunitcode);
    }

    public String getSubunitname() {
        return subunitname;
    }

    public void setSubunitname(String subunitname) {
        String oldSubunitname = this.subunitname;
        this.subunitname = subunitname;
        changeSupport.firePropertyChange("subunitname", oldSubunitname, subunitname);
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        String oldUnitcode = this.unitcode;
        this.unitcode = unitcode;
        changeSupport.firePropertyChange("unitcode", oldUnitcode, unitcode);
    }

    public int getId() {
        return id;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
