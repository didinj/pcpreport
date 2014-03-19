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
 * @author DIDIN
 */
@Entity
@Table(name = "ABSENSI")
@XmlRootElement
public class Absensi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "SUBUNIT")
    private String subunit;
    @Column(name = "NIK")
    private String nik;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "BULAN")
    private String bulan;
    @Column(name = "TAHUN")
    private String tahun;
    @Column(name = "H1")
    private String h1;
    @Column(name = "H2")
    private String h2;
    @Column(name = "H3")
    private String h3;
    @Column(name = "H4")
    private String h4;
    @Column(name = "H5")
    private String h5;
    @Column(name = "H6")
    private String h6;
    @Column(name = "H7")
    private String h7;
    @Column(name = "H8")
    private String h8;
    @Column(name = "H9")
    private String h9;
    @Column(name = "H10")
    private String h10;
    @Column(name = "H11")
    private String h11;
    @Column(name = "H12")
    private String h12;
    @Column(name = "H13")
    private String h13;
    @Column(name = "H14")
    private String h14;
    @Column(name = "H15")
    private String h15;
    @Column(name = "H16")
    private String h16;
    @Column(name = "H17")
    private String h17;
    @Column(name = "H18")
    private String h18;
    @Column(name = "H19")
    private String h19;
    @Column(name = "H20")
    private String h20;
    @Column(name = "H21")
    private String h21;
    @Column(name = "H22")
    private String h22;
    @Column(name = "H23")
    private String h23;
    @Column(name = "H24")
    private String h24;
    @Column(name = "H25")
    private String h25;
    @Column(name = "H26")
    private String h26;
    @Column(name = "H27")
    private String h27;
    @Column(name = "H28")
    private String h28;
    @Column(name = "H29")
    private String h29;
    @Column(name = "H30")
    private String h30;
    @Column(name = "H31")
    private String h31;

    public Absensi() {
    }

    public Absensi(Integer id) {
        this.id = id;
    }

    public Absensi(Integer id, String nik, String nama) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
    }

    public Absensi(Integer id, String unit, String subunit, String nik, String nama, String bulan, String tahun, String h1, String h2, String h3, String h4, String h5, String h6, String h7, String h8, String h9, String h10, String h11, String h12, String h13, String h14, String h15, String h16, String h17, String h18, String h19, String h20, String h21, String h22, String h23, String h24, String h25, String h26, String h27, String h28, String h29, String h30, String h31) {
        this.id = id;
        this.unit = unit;
        this.subunit = subunit;
        this.nik = nik;
        this.nama = nama;
        this.bulan = bulan;
        this.tahun = tahun;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.h4 = h4;
        this.h5 = h5;
        this.h6 = h6;
        this.h7 = h7;
        this.h8 = h8;
        this.h9 = h9;
        this.h10 = h10;
        this.h11 = h11;
        this.h12 = h12;
        this.h13 = h13;
        this.h14 = h14;
        this.h15 = h15;
        this.h16 = h16;
        this.h17 = h17;
        this.h18 = h18;
        this.h19 = h19;
        this.h20 = h20;
        this.h21 = h21;
        this.h22 = h22;
        this.h23 = h23;
        this.h24 = h24;
        this.h25 = h25;
        this.h26 = h26;
        this.h27 = h27;
        this.h28 = h28;
        this.h29 = h29;
        this.h30 = h30;
        this.h31 = h31;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH10() {
        return h10;
    }

    public void setH10(String h10) {
        this.h10 = h10;
    }

    public String getH11() {
        return h11;
    }

    public void setH11(String h11) {
        this.h11 = h11;
    }

    public String getH12() {
        return h12;
    }

    public void setH12(String h12) {
        this.h12 = h12;
    }

    public String getH13() {
        return h13;
    }

    public void setH13(String h13) {
        this.h13 = h13;
    }

    public String getH14() {
        return h14;
    }

    public void setH14(String h14) {
        this.h14 = h14;
    }

    public String getH15() {
        return h15;
    }

    public void setH15(String h15) {
        this.h15 = h15;
    }

    public String getH16() {
        return h16;
    }

    public void setH16(String h16) {
        this.h16 = h16;
    }

    public String getH17() {
        return h17;
    }

    public void setH17(String h17) {
        this.h17 = h17;
    }

    public String getH18() {
        return h18;
    }

    public void setH18(String h18) {
        this.h18 = h18;
    }

    public String getH19() {
        return h19;
    }

    public void setH19(String h19) {
        this.h19 = h19;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getH20() {
        return h20;
    }

    public void setH20(String h20) {
        this.h20 = h20;
    }

    public String getH21() {
        return h21;
    }

    public void setH21(String h21) {
        this.h21 = h21;
    }

    public String getH22() {
        return h22;
    }

    public void setH22(String h22) {
        this.h22 = h22;
    }

    public String getH23() {
        return h23;
    }

    public void setH23(String h23) {
        this.h23 = h23;
    }

    public String getH24() {
        return h24;
    }

    public void setH24(String h24) {
        this.h24 = h24;
    }

    public String getH25() {
        return h25;
    }

    public void setH25(String h25) {
        this.h25 = h25;
    }

    public String getH26() {
        return h26;
    }

    public void setH26(String h26) {
        this.h26 = h26;
    }

    public String getH27() {
        return h27;
    }

    public void setH27(String h27) {
        this.h27 = h27;
    }

    public String getH28() {
        return h28;
    }

    public void setH28(String h28) {
        this.h28 = h28;
    }

    public String getH29() {
        return h29;
    }

    public void setH29(String h29) {
        this.h29 = h29;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getH30() {
        return h30;
    }

    public void setH30(String h30) {
        this.h30 = h30;
    }

    public String getH31() {
        return h31;
    }

    public void setH31(String h31) {
        this.h31 = h31;
    }

    public String getH4() {
        return h4;
    }

    public void setH4(String h4) {
        this.h4 = h4;
    }

    public String getH5() {
        return h5;
    }

    public void setH5(String h5) {
        this.h5 = h5;
    }

    public String getH6() {
        return h6;
    }

    public void setH6(String h6) {
        this.h6 = h6;
    }

    public String getH7() {
        return h7;
    }

    public void setH7(String h7) {
        this.h7 = h7;
    }

    public String getH8() {
        return h8;
    }

    public void setH8(String h8) {
        this.h8 = h8;
    }

    public String getH9() {
        return h9;
    }

    public void setH9(String h9) {
        this.h9 = h9;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        if (!(object instanceof Absensi)) {
            return false;
        }
        Absensi other = (Absensi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pcpreports.Absensi[ id=" + id + " ]";
    }
}
