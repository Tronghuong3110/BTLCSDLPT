package com.csdlpt.CRUD.Model;


import javax.persistence.*;

@Entity
@Table(name = "ve")
public class VeEntity {

    @Id
    private String id;
    private Float giave;
    private Integer vi_tri_so_ghe;
    private String loaive;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDonEntity hoaDonEntity;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_bay")
    private ChuyenBayEntity chuyenBayEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getGiave() {
        return giave;
    }

    public Integer getVi_tri_so_ghe() {
        return vi_tri_so_ghe;
    }

    public void setVi_tri_so_ghe(Integer vi_tri_so_ghe) {
        this.vi_tri_so_ghe = vi_tri_so_ghe;
    }

    public String getLoaive() {
        return loaive;
    }

    public HoaDonEntity getHoaDonEntity() {
        return hoaDonEntity;
    }

    public void setHoaDonEntity(HoaDonEntity hoaDonEntity) {
        this.hoaDonEntity = hoaDonEntity;
    }

    public ChuyenBayEntity getChuyenBayEntity() {
        return chuyenBayEntity;
    }

    public void setChuyenBayEntity(ChuyenBayEntity chuyenBayEntity) {
        this.chuyenBayEntity = chuyenBayEntity;
    }

    public void setGiave(Float giave) {
        this.giave = giave;
    }

    public void setLoaive(String loaive) {
        this.loaive = loaive;
    }
}
