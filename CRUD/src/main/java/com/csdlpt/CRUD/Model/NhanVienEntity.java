package com.csdlpt.CRUD.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "nhanhvien")
public class NhanVienEntity {

    @Id
    private String id;
    private String ten_nhan_vien;
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "id_chi_nhanh")
    private ChiNhanhEntity chiNhanhEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_nhan_vien() {
        return ten_nhan_vien;
    }

    public void setTen_nhan_vien(String ten_nhan_vien) {
        this.ten_nhan_vien = ten_nhan_vien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public ChiNhanhEntity getChiNhanhEntity() {
        return chiNhanhEntity;
    }

    public void setChiNhanhEntity(ChiNhanhEntity chiNhanhEntity) {
        this.chiNhanhEntity = chiNhanhEntity;
    }

}
