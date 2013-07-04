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
@Table(name = "SETUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pcp.findAll", query = "SELECT s FROM Setup s"),
    @NamedQuery(name = "Pcp.findById", query = "SELECT s FROM Setup s WHERE s.id = :id"),
    @NamedQuery(name = "Pcp.findBySetupitem", query = "SELECT s FROM Setup s WHERE s.setupitem = :setupitem"),
    @NamedQuery(name = "Pcp.findBySetupvalue", query = "SELECT s FROM Setup s WHERE s.setupvalue = :setupvalue")})
public class Setup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SETUPITEM")
    private String setupitem;
    @Column(name = "SETUPVALUE")
    private String setupvalue;

    public Setup() {
    }

    public Setup(String setupitem, String setupvalue) {
        this.setupitem = setupitem;
        this.setupvalue = setupvalue;
    }

    public String getSetupitem() {
        return setupitem;
    }

    public void setSetupitem(String setupitem) {
        this.setupitem = setupitem;
    }

    public String getSetupvalue() {
        return setupvalue;
    }

    public void setSetupvalue(String setupvalue) {
        this.setupvalue = setupvalue;
    }

    public Integer getId() {
        return id;
    }
    
}
