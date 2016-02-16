package com.springapp.mvc.orm;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by russellmilburn on 27/06/15.
 */
@Entity
@Table(name = "nfc_scan", schema = "", catalog = "nfc_db")
public class NfcScanEntity
{
    private int id;
    private String nfcUid;
    private String productCode;
    private Timestamp scanDate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nfc_uid")
    public String getNfcUid() {
        return nfcUid;
    }

    public void setNfcUid(String nfcUid) {
        this.nfcUid = nfcUid;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NfcScanEntity that = (NfcScanEntity) o;

        if (id != that.id) return false;
        if (nfcUid != null ? !nfcUid.equals(that.nfcUid) : that.nfcUid != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nfcUid != null ? nfcUid.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "scan_date")
    public Timestamp getScanDate() {
        return scanDate;
    }

    public void setScanDate(Timestamp scanDate) {
        this.scanDate = scanDate;
    }
}
