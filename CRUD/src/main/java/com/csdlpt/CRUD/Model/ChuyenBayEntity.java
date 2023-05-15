package com.csdlpt.CRUD.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBayEntity {

    @Id
    private String id;
    private Date ngay_khoi_hanh;
    private Time gio_khoi_hanh;

    @ManyToOne
    @JoinColumn(name = "id_tuyen_bay")
    private TuyenBayEntity tuyenBayEntity;

    @ManyToOne
    @JoinColumn(name = "id_may_bay")
    private MayBayEntity mayBayEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgay_khoi_hanh() {
        return ngay_khoi_hanh;
    }

    public void setNgay_khoi_hanh(Date ngay_khoi_hanh) {
        this.ngay_khoi_hanh = ngay_khoi_hanh;
    }

    public Time getGio_khoi_hanh() {
        return gio_khoi_hanh;
    }

    public void setGio_khoi_hanh(Time gio_khoi_hanh) {
        this.gio_khoi_hanh = gio_khoi_hanh;
    }

    public TuyenBayEntity getTuyenBayEntity() {
        return tuyenBayEntity;
    }

    public void setTuyenBayEntity(TuyenBayEntity tuyenBayEntity) {
        this.tuyenBayEntity = tuyenBayEntity;
    }

    public MayBayEntity getMayBayEntity() {
        return mayBayEntity;
    }

    public void setMayBayEntity(MayBayEntity mayBayEntity) {
        this.mayBayEntity = mayBayEntity;
    }
}
