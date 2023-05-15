package com.csdlpt.CRUD.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "sanbay")
public class SanBayEntity {

    @Id
    private String id;
    private String diachi;
    private String ten_san_bay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTen_san_bay() {
        return ten_san_bay;
    }

    public void setTen_san_bay(String ten_san_bay) {
        this.ten_san_bay = ten_san_bay;
    }
}
