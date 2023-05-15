package com.csdlpt.CRUD.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity

@Table(name = "chinhanh")
public class ChiNhanhEntity {

    @Id
    private String id;
    private String ten_chi_nhanh;

//    @OneToMany(mappedBy = "chiNhanhEntity")
//    private List<NhanVienEntity> nhanVienEntityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_chi_nhanh() {
        return ten_chi_nhanh;
    }

    public void setTen_chi_nhanh(String ten_chi_nhanh) {
        this.ten_chi_nhanh = ten_chi_nhanh;
    }

//    public List<NhanVienEntity> getNhanVienEntityList() {
//        return nhanVienEntityList;
//    }
//
//    public void setNhanVienEntityList(List<NhanVienEntity> nhanVienEntityList) {
//        this.nhanVienEntityList = nhanVienEntityList;
//    }
}
