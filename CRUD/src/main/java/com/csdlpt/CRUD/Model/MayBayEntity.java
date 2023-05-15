package com.csdlpt.CRUD.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "maybay")
public class MayBayEntity {
    @Id
    private String id;
    private String ten_may_bay;
    private String tinhtrang;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_may_bay() {
        return ten_may_bay;
    }

    public void setTen_may_bay(String ten_may_bay) {
        this.ten_may_bay = ten_may_bay;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}
