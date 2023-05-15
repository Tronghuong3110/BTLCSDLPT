package com.csdlpt.CRUD.Service;

import com.csdlpt.CRUD.Model.*;

import java.util.List;

public interface IHomeService {
    List<KhachHangEntity> findAllKhachHang();
    List<ChuyenBayEntity> findAllChuyenBay();
    List<ChiNhanhEntity> findAllChiNhanh();
    List<HoaDonEntity> findAllHoaDon();
    List<NhanVienEntity> findAllNhanVien();
    List<SanBayEntity> findAllSanBay();
    List<TuyenBayEntity> findAllTuyenBay();
    List<VeEntity> findAllVe();
    List<MayBayEntity> findAllMayBay();

    // ============================== save =================================
    String saveKhachHang(KhachHangEntity khachHangEntity);
    String saveChiNhanh(ChiNhanhEntity chiNhanhEntity);
    String saveChuyenBay(ChuyenBayEntity chuyenBayEntity, String maTuyenBay, String maMayBay);
    String saveHoaDon(HoaDonEntity hoaDonEntity, String maKhachHang, String maNhanVien);
    String saveMayBay(MayBayEntity mayBayEntity);
    String saveNhanVien(NhanVienEntity nhanVienEntity, String maChiNhanh);
    String saveSanBay(SanBayEntity sanBayEntity);
    String saveTuyenBay(TuyenBayEntity tuyenBayEntity, String maSanBayDi, String maSanBayDen);
    String saveVe(VeEntity veEntity, String maChuyenBay, String maHoaDon);

//    ================================= FIND ONE ==============================
    KhachHangEntity findOneKhachHang(String maKhachHang);
    ChiNhanhEntity findOneChiNhanh(String maChiNhanh);
    ChuyenBayEntity findOneChuyenBay(String maChuyenBay);
    HoaDonEntity findOneHoaDon(String maHoaDon);
    MayBayEntity findOneMayBay(String maMayBay);
    NhanVienEntity findOneNhanVien(String maNhanVien);
    SanBayEntity findOneSanBay(String maSanBay);
    TuyenBayEntity findOneTuyenBay(String maTuyenBay);
    VeEntity findOneVe(String maVe);

//    ================================= update ====================================
    String updateKhachHang(KhachHangEntity khachHangEntity);
    String updateChiNhanh(ChiNhanhEntity chiNhanhEntity);
    String updateChuyenBay(ChuyenBayEntity chuyenBayEntity, String maTuyenBay, String maMayBay);
    String updateHoaDon(HoaDonEntity hoaDonEntity, String maKhachHang, String maNhanVien);
    String updateMayBay(MayBayEntity mayBayEntity);
    String updateNhanVien(NhanVienEntity nhanVienEntity, String maChiNhanh);
    String updateSanBay(SanBayEntity sanBayEntity);
    String updateTuyenBay(TuyenBayEntity tuyenBayEntity, String maSanBayDi, String maSanBayDen);
    String updateVe(VeEntity veEntity, String maChuyenBay, String maHoaDon);

// ==================================== delete =====================================
    String deleteKhachHang(String maKhachHang);
    String deleteChiNhanh(String maChiNhanh);
    String deleteChuyenBay(String maChuyenBay);
    String deleteHoaDon(String maHoaDon);
    String deleteMayBay(String maMayBay);
    String deleteNhanVien(String maNhanVien);
    String deleteSanBay(String MaSanBay);
    String deleteTuyenBay(String maTuyenBay);
    String deleteVe(String maVe);

}
