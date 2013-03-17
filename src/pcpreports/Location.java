/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLoccode", query = "SELECT l FROM Location l WHERE l.loccode = :loccode"),
    @NamedQuery(name = "Location.findByLocname", query = "SELECT l FROM Location l WHERE l.locname = :locname"),
    @NamedQuery(name = "Location.findByLocunit", query = "SELECT l FROM Location l WHERE l.locunit = :locunit"),
    @NamedQuery(name = "Location.findByLocrfid", query = "SELECT l FROM Location l WHERE l.locrfid = :locrfid")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOCCODE")
    private String loccode;
    @Column(name = "LOCNAME")
    private String locname;
    @Column(name = "LOCUNIT")
    private String locunit;
    @Column(name = "LOCRFID")
    private String locrfid;

    public Location() {
    }

    public Location(String loccode) {
        this.loccode = loccode;
    }

    public Location(String loccode, String locname, String locunit, String locrfid) {
        this.loccode = loccode;
        this.locname = locname;
        this.locunit = locunit;
        this.locrfid = locrfid;
    }

    public String getLoccode() {
        return loccode;
    }

    public void setLoccode(String loccode) {
        this.loccode = loccode;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getLocunit() {
        return locunit;
    }

    public void setLocunit(String locunit) {
        this.locunit = locunit;
    }

    public String getLocrfid() {
        return locrfid;
    }

    public void setLocrfid(String locrfid) {
        this.locrfid = locrfid;
    }
}
