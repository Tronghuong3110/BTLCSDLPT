package com.csdlpt.CRUD.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tuyenbay")
public class TuyenBayEntity {

    @Id
    private String id;
    private String ten_tuyen_bay;

    @ManyToOne
    @JoinColumn(name = "id_sb_di")
    private SanBayEntity sanBayDi;

    @ManyToOne
    @JoinColumn(name = "id_sb_den")
    private SanBayEntity sanBayDen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_tuyen_bay() {
        return ten_tuyen_bay;
    }

    public void setTen_tuyen_bay(String ten_tuyen_bay) {
        this.ten_tuyen_bay = ten_tuyen_bay;
    }

    public SanBayEntity getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(SanBayEntity sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public SanBayEntity getSanBayDen() {
        return sanBayDen;
    }

    public void setSanBayDen(SanBayEntity sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

}
