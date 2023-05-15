package com.csdlpt.CRUD.Controller;

import java.util.*;

import com.csdlpt.CRUD.Model.*;
import com.csdlpt.CRUD.Service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HomeController {
    @Autowired
    private IHomeService homeService;

    // ========================================================= Get All ===============================================
    @GetMapping("/khachhangs")
    public List<KhachHangEntity> findAllKhachHang() {
        return homeService.findAllKhachHang();
    }

    @GetMapping("/chinhanhs")
    public List<ChiNhanhEntity> findAllChiNhanh() {
        return homeService.findAllChiNhanh();
    }

    @GetMapping("/chuyenbays")
    public List<ChuyenBayEntity> findAllChuyenBay() {
        return homeService.findAllChuyenBay();
    }

    @GetMapping("/hoadons")
    public List<HoaDonEntity> findAllHoaDon() {
        return homeService.findAllHoaDon();
    }

    @GetMapping("/nhanviens")
    public List<NhanVienEntity> findAllNhanVien() {
        return homeService.findAllNhanVien();
    }

    @GetMapping("/sanbays")
    public List<SanBayEntity> findAllSanBay() {
        return homeService.findAllSanBay();
    }

    @GetMapping("/tuyenbays")
    public List<TuyenBayEntity> findAllTuyenBay() {
        return homeService.findAllTuyenBay();
    }

    @GetMapping("/ves")
    public List<VeEntity> findAllVe() {
        return homeService.findAllVe();
    }

    @GetMapping("/maybays")
    public List<MayBayEntity> findAllMayBay() {
        return homeService.findAllMayBay();
    }


    // ============================================= add ==================================

    @PostMapping("/khachhang")
    public String saveKhachHang(@RequestBody KhachHangEntity khachHangEntity) {
        return homeService.saveKhachHang(khachHangEntity);
    }

    @PostMapping("/chinhanh")
    public String saveChiNhanh(@RequestBody ChiNhanhEntity chiNhanhEntity) {
        return homeService.saveChiNhanh(chiNhanhEntity);
    }

    @PostMapping("/maybay")
    public String saveMayBay(@RequestBody MayBayEntity mayBayEntity) {
        return homeService.saveMayBay(mayBayEntity);
    }

    @PostMapping("/sanbay")
    public String saveSanBay(@RequestBody SanBayEntity sanBayEntity) {
        return homeService.saveSanBay(sanBayEntity);
    }

    @PostMapping("/chuyenbay/{maTuyenBay}/{maMayBay}")
    public String saveChuyenBay(@RequestBody ChuyenBayEntity chuyenBayEntity, @PathVariable("maTuyenBay") String maTuyenBay,
                                @PathVariable("maMayBay") String maMayBay) {
        return homeService.saveChuyenBay(chuyenBayEntity, maTuyenBay, maMayBay);
    }

    @PostMapping("/nhanvien/{maChiNhanh}")
    public String saveNhanVien(@RequestBody NhanVienEntity nhanVienEntity, @PathVariable("maChiNhanh") String maChiNhanh) {
        return homeService.saveNhanVien(nhanVienEntity, maChiNhanh);
    }

    @PostMapping("/tuyenbay/{maSanBayDi}/{maSanBayDen}")
    public String saveTuyenBay(@RequestBody TuyenBayEntity tuyenBayEntity, @PathVariable("maSanBayDi") String maSanBayDi,
                               @PathVariable("maSanBayDen") String maSanBayDen) {
        return homeService.saveTuyenBay(tuyenBayEntity, maSanBayDi, maSanBayDen);
    }

    @PostMapping("/hoadon/{maKhachHang}/{maNhanVien}")
    public String saveHoaDon(@RequestBody HoaDonEntity hoaDonEntity,
                                @PathVariable("maKhachHang") String maKhachHang,
                                @PathVariable("maNhanVien") String maNhanVien) {
        return homeService.saveHoaDon(hoaDonEntity, maKhachHang, maNhanVien);
    }
    @PostMapping("/ve/{maHoaDon}/{maChuyenBay}")
    public String saveVe(@RequestBody VeEntity veEntity,
                         @PathVariable("maHoaDon") String maHoaDon,
                         @PathVariable("maChuyenBay") String maChuyenBay) {
        return homeService.saveVe(veEntity, maChuyenBay, maHoaDon);
    }

//    ========================================================= find one ===============================================
    @GetMapping("/chinhanh")
    public ChiNhanhEntity findOneChiNhanh(@RequestParam String id) {
        return homeService.findOneChiNhanh(id);
    }

    @GetMapping("/chuyenbay")
    public ChuyenBayEntity findOneChuyenBay(@RequestParam String id) {
        return homeService.findOneChuyenBay(id);
    }

    @GetMapping("/hoadon")
    public HoaDonEntity findOneHoaDon(@RequestParam String id) {
        return homeService.findOneHoaDon(id);
    }

    @GetMapping("/khachhang")
    public KhachHangEntity findOneKhachHang(@RequestParam String id) {
        return homeService.findOneKhachHang(id);
    }

    @GetMapping("/maybay")
    public MayBayEntity findOneMayBay(@RequestParam String id) {
        return homeService.findOneMayBay(id);
    }

    @GetMapping("/nhanvien")
    public NhanVienEntity findOneNhanVien(@RequestParam String id) {
        return homeService.findOneNhanVien(id);
    }

    @GetMapping("/sanbay")
    public SanBayEntity findOneSanBay(@RequestParam String id) {
        return homeService.findOneSanBay(id);
    }

    @GetMapping("/tuyenbay")
    public TuyenBayEntity findOneTuyenBay(@RequestParam String id) {
        return homeService.findOneTuyenBay(id);
    }

    @GetMapping("/ve")
    public VeEntity findOneVe(@RequestParam String id) {
        return homeService.findOneVe(id);
    }

//    ==================================================== EDIT ========================================================
    @PutMapping("/khachhang")
    public String updateKhachHang(@RequestBody KhachHangEntity khachHangEntity) {
        return homeService.updateKhachHang(khachHangEntity);
    }

    @PutMapping("/chinhanh")
    public String updateChiNhanh(@RequestBody ChiNhanhEntity chiNhanhEntity) {
        return homeService.updateChiNhanh(chiNhanhEntity);
    }

    @PutMapping("/maybay")
    public String updateMayBay(@RequestBody MayBayEntity mayBayEntity) {
        return homeService.updateMayBay(mayBayEntity);
    }

    @PutMapping("/sanbay")
    public String updateSanBay(@RequestBody SanBayEntity sanBayEntity) {
        return homeService.updateSanBay(sanBayEntity);
    }

    @PutMapping("/chuyenbay/{maTuyenBay}/{maMayBay}")
    public String updateChuyenBay(@RequestBody ChuyenBayEntity chuyenBayEntity, @PathVariable("maTuyenBay") String maTuyenBay,
                                @PathVariable("maMayBay") String maMayBay) {
        return homeService.updateChuyenBay(chuyenBayEntity, maTuyenBay, maMayBay);
    }

    @PutMapping("/nhanvien/{maChiNhanh}")
    public String updateNhanVien(@RequestBody NhanVienEntity nhanVienEntity, @PathVariable("maChiNhanh") String maChiNhanh) {
        return homeService.updateNhanVien(nhanVienEntity, maChiNhanh);
    }

    @PutMapping("/tuyenbay/{maSanBayDi}/{maSanBayDen}")
    public String updateTuyenBay(@RequestBody TuyenBayEntity tuyenBayEntity, @PathVariable("maSanBayDi") String maSanBayDi,
                               @PathVariable("maSanBayDen") String maSanBayDen) {
        return homeService.updateTuyenBay(tuyenBayEntity, maSanBayDi, maSanBayDen);
    }

    @PutMapping("/hoadon/{maKhachHang}/{maNhanVien}")
    public String updateHoaDon(@RequestBody HoaDonEntity hoaDonEntity,
                             @PathVariable("maKhachHang") String maKhachHang,
                             @PathVariable("maNhanVien") String maNhanVien) {
        return homeService.updateHoaDon(hoaDonEntity, maKhachHang, maNhanVien);
    }
    @PutMapping("/ve/{maHoaDon}/{maChuyenBay}")
    public String updateVe(@RequestBody VeEntity veEntity,
                         @PathVariable("maHoaDon") String maHoaDon,
                         @PathVariable("maChuyenBay") String maChuyenBay) {
        return homeService.updateVe(veEntity, maChuyenBay, maHoaDon);
    }

//    =============================================== DELETE ===========================================================
    @DeleteMapping("/chinhanh")
    public String deleteChiNhanh(@RequestParam String id) {
        return homeService.deleteChiNhanh(id);
    }

    @DeleteMapping("/chuyenbay")
    public String deleteChuyenBay(@RequestParam String id) {
        return homeService.deleteChuyenBay(id);
    }

    @DeleteMapping("/hoadon")
    public String deleteHoaDon(@RequestParam String id) {
        return homeService.deleteHoaDon(id);
    }

    @DeleteMapping("/khachhang")
    public String deleteKhachHang(@RequestParam String id) {
        return homeService.deleteKhachHang(id);
    }

    @DeleteMapping("/maybay")
    public String deleteMayBay(@RequestParam String id) {
        return homeService.deleteMayBay(id);
    }

    @DeleteMapping("/nhanvien")
    public String deleteNhanVien(@RequestParam String id) {
        return homeService.deleteNhanVien(id);
    }

    @DeleteMapping("/sanbay")
    public String deleteSanBay(@RequestParam String id) {
        return homeService.deleteSanBay(id);
    }

    @DeleteMapping("/tuyenbay")
    public String deleteTuyenBay(@RequestParam String id) {
        return homeService.deleteTuyenBay(id);
    }

    @DeleteMapping("/ve")
    public String deleteVe(@RequestParam String id) {
        return homeService.deleteVe(id);
    }

}
