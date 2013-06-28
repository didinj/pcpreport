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
@Table(name = "UNITS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Units.findAll", query = "SELECT u FROM Units u"),
    @NamedQuery(name = "Units.findByUnitcode", query = "SELECT u FROM Units u WHERE u.unitcode = :unitcode"),
    @NamedQuery(name = "Units.findByUnitname", query = "SELECT u FROM Units u WHERE u.unitname = :unitname")})
public class Units implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UNITCODE")
    private String unitcode;
    @Column(name = "UNITNAME")
    private String unitname;

    public Units() {
    }

    public Units(String unitcode, String unitname) {
        this.unitcode = unitcode;
        this.unitname = unitname;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        String oldUnitcode = this.unitcode;
        this.unitcode = unitcode;
        changeSupport.firePropertyChange("unitcode", oldUnitcode, unitcode);
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        String oldUnitname = this.unitname;
        this.unitname = unitname;
        changeSupport.firePropertyChange("unitname", oldUnitname, unitname);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
