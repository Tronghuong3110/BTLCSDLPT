package com.csdlpt.CRUD.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;
@Entity
@Table(name = "hoadon")
public class HoaDonEntity {

    @Id
    private String id;
    private Date ngaylap;
    private Float thanhhtien;

    @ManyToOne
    @JoinColumn(name = "id_khanh_hang")
    private KhachHangEntity khachHangEntity;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVienEntity nhanVienEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayLap() {
        return ngaylap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngaylap = ngayLap;
    }

    public Float getThanhTien() {
        return thanhhtien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhhtien = thanhTien;
    }

    public KhachHangEntity getKhachHangEntity() {
        return khachHangEntity;
    }

    public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
        this.khachHangEntity = khachHangEntity;
    }

    public NhanVienEntity getNhanVienEntity() {
        return nhanVienEntity;
    }

    public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
        this.nhanVienEntity = nhanVienEntity;
    }
}
