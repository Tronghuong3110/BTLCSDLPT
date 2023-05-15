package com.csdlpt.CRUD.Service;

import java.sql.SQLException;
import java.util.*;

import com.csdlpt.CRUD.Model.*;
import com.csdlpt.CRUD.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements IHomeService{

    @Autowired
    private ChiNhanhRepository chiNhanhRepository;
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private SanBayRepository sanBayRepository;
    @Autowired
    private TuyenBayRepository tuyenBayRepository;
    @Autowired
    private VeRepository veRepository;
    @Autowired
    private MayBayRepository mayBayRepository;

    @Override
    public List<KhachHangEntity> findAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public List<ChuyenBayEntity> findAllChuyenBay() {
        return chuyenBayRepository.findAll();
    }

    @Override
    public List<ChiNhanhEntity> findAllChiNhanh() {
        return chiNhanhRepository.findAll();
    }

    @Override
    public List<HoaDonEntity> findAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    @Override
    public List<MayBayEntity> findAllMayBay() {
        return mayBayRepository.findAll();
    }


    @Override
    public List<NhanVienEntity> findAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<SanBayEntity> findAllSanBay() {
        return sanBayRepository.findAll();
    }

    @Override
    public List<TuyenBayEntity> findAllTuyenBay() {
        return tuyenBayRepository.findAll();
    }

    @Override
    public List<VeEntity> findAllVe() {
        return veRepository.findAll();
    }

//    ===================================================== insert table ===============================================
    @Override
    public String saveKhachHang(KhachHangEntity khachHangEntity) {
        KhachHangEntity oldKhachHang = khachHangRepository.findById(khachHangEntity.getId().toUpperCase())
                .orElse(null);
        if(!checkIdKhachHang(khachHangEntity.getId().toUpperCase())) {
            return "Mã khách hàng không hợp lệ, vui lòng nhập lại";
        }
        if(oldKhachHang == null) {
            khachHangEntity.setId(khachHangEntity.getId().toUpperCase());
            khachHangRepository.save(khachHangEntity);
        }
        else {
            return "Mã khách hàng đã trùng, vui lòng nhập lại mã!";
        }
        return "Thêm khách hàng thành công";
    }
    @Override
    public String updateKhachHang(KhachHangEntity khachHangEntity) {
        KhachHangEntity oldKhachHang = khachHangRepository.findById(khachHangEntity.getId().toUpperCase())
                .orElse(null);
        oldKhachHang.setCmnd(khachHangEntity.getCmnd());
        oldKhachHang.setDiachi(khachHangEntity.getDiachi());
        oldKhachHang.setNgaysinh(khachHangEntity.getNgaysinh());
        oldKhachHang.setSdt(khachHangEntity.getSdt());
        oldKhachHang.setTen(khachHangEntity.getTen());
        String mess = null;
        try {
            khachHangRepository.save(oldKhachHang);
            mess = "Cập nhật khách hàng thành công";
        }catch (DataAccessException e) {
            Throwable rootCause = e.getRootCause();
            if (rootCause instanceof SQLException) {
                SQLException sqlException = (SQLException) rootCause;
                mess = sqlException.getMessage();
            }
        }
        return mess;
    }

    @Override
    public String saveChiNhanh(ChiNhanhEntity chiNhanhEntity) {
        ChiNhanhEntity oldChiNhanh = chiNhanhRepository.findById(chiNhanhEntity.getId().toUpperCase()).
            orElse(null);
        String mess = null;
        try {
//            if(oldChiNhanh != null) {
//                return "Mã chi nhánh đã trùng, vui lòng nhập lại!";
//            }
            chiNhanhEntity.setId(chiNhanhEntity.getId().toUpperCase());
            chiNhanhRepository.save(chiNhanhEntity);
            mess =  "Thêm chi nhánh thành công";
        } catch (DataAccessException e) {
            Throwable rootCause = e.getRootCause();
            if (rootCause instanceof SQLException) {
                SQLException sqlException = (SQLException) rootCause;
                mess = sqlException.getMessage();
                System.out.println("Xin chao");
            }
        }
        System.out.println(mess);
        return mess;
    }

    @Override
    public String updateChiNhanh(ChiNhanhEntity chiNhanhEntity) {
        ChiNhanhEntity oldChiNhanh = chiNhanhRepository.findById(chiNhanhEntity.getId().toUpperCase()).
                orElse(null);
        String mess = null;
        try {
            oldChiNhanh.setTen_chi_nhanh(chiNhanhEntity.getTen_chi_nhanh());
            chiNhanhRepository.save(chiNhanhEntity);
            mess =  "Cập nhật chi nhánh thành công";
        } catch (DataAccessException e) {
            Throwable rootCause = e.getRootCause();
            if (rootCause instanceof SQLException) {
                SQLException sqlException = (SQLException) rootCause;
                mess = sqlException.getMessage();
            }
        }
        return mess;
    }

    @Override
    public String saveChuyenBay(ChuyenBayEntity chuyenBayEntity, String maTuyenBay, String maMayBay) {
        TuyenBayEntity tuyenBayEntity = tuyenBayRepository.findById(maTuyenBay.toUpperCase()).orElse(null);
        MayBayEntity mayBayEntity = mayBayRepository.findByIdAndTinhtrang(maMayBay.toUpperCase(), "HOAT DONG BINH THUONG").orElse(null);
        ChuyenBayEntity oldChuyenBay = chuyenBayRepository.findById(chuyenBayEntity.getId().toUpperCase()).orElse(null);
        System.out.println(chuyenBayEntity.getGio_khoi_hanh());
        if(oldChuyenBay != null) {
            return "Mã chuyến bay đã trùng, vui lòng nhập lại!";
        }
        if(mayBayEntity == null) {
            return "May bay dang không hoạt động, vui lòng chọn máy bay khác!";
        }
        chuyenBayEntity.setId(chuyenBayEntity.getId().toUpperCase());
        chuyenBayEntity.setMayBayEntity(mayBayEntity);
        chuyenBayEntity.setTuyenBayEntity(tuyenBayEntity);
        chuyenBayRepository.save(chuyenBayEntity);
        return "Thêm chuyến bay thành công!";
    }

    @Override
    public String updateChuyenBay(ChuyenBayEntity chuyenBayEntity, String maTuyenBay, String maMayBay) {
        TuyenBayEntity tuyenBayEntity = tuyenBayRepository.findById(maTuyenBay.toUpperCase()).orElse(null);
        MayBayEntity mayBayEntity = mayBayRepository.findByIdAndTinhtrang(maMayBay.toUpperCase(), "HOAT DONG BINH THUONG").orElse(null);
        ChuyenBayEntity oldChuyenBay = chuyenBayRepository.findById(chuyenBayEntity.getId().toUpperCase()).orElse(null);
        if(mayBayEntity == null) {
            return "May bay dang không hoạt động, vui lòng chọn máy bay khác!";
        }
//        System.out.println(chuyenBayEntity.getGio_khoi_hang());
        oldChuyenBay.setMayBayEntity(mayBayEntity);
        oldChuyenBay.setTuyenBayEntity(tuyenBayEntity);
        oldChuyenBay.setGio_khoi_hanh(chuyenBayEntity.getGio_khoi_hanh());
        oldChuyenBay.setNgay_khoi_hanh(chuyenBayEntity.getNgay_khoi_hanh());
        chuyenBayRepository.save(oldChuyenBay);
        return "Cập nhật chuyến bay thành công!";
    }

    @Override
    public String saveHoaDon(HoaDonEntity hoaDonEntity, String maKhachHang, String maNhanVien) {
        KhachHangEntity khachHangEntity = khachHangRepository.findById(maKhachHang.toUpperCase()).orElse(null);
        NhanVienEntity nhanVienEntity = nhanVienRepository.findById(maNhanVien.toUpperCase()).orElse(null);
        HoaDonEntity oldHoaDon = hoaDonRepository.findById(hoaDonEntity.getId().toUpperCase()).orElse(null);
        if(oldHoaDon != null) {
            return "Mã hóa đơn đã trùng, vui lòng nhập lại mã!";
        }
        hoaDonEntity.setId(hoaDonEntity.getId().toUpperCase());
        hoaDonEntity.setKhachHangEntity(khachHangEntity);
        hoaDonEntity.setNhanVienEntity(nhanVienEntity);
        hoaDonEntity.setThanhTien(0f);
        hoaDonEntity.setNgayLap(new java.sql.Date(System.currentTimeMillis()));
        hoaDonRepository.save(hoaDonEntity);
        return "Thêm hóa đơn thành công";
    }

    @Override
    public String updateHoaDon(HoaDonEntity hoaDonEntity, String maKhachHang, String maNhanVien) {
        KhachHangEntity khachHangEntity = khachHangRepository.findById(maKhachHang.toUpperCase()).orElse(null);
        NhanVienEntity nhanVienEntity = nhanVienRepository.findById(maNhanVien.toUpperCase()).orElse(null);
        HoaDonEntity oldHoaDon = hoaDonRepository.findById(hoaDonEntity.getId().toUpperCase()).orElse(null);

        oldHoaDon.setKhachHangEntity(khachHangEntity);
        oldHoaDon.setNhanVienEntity(nhanVienEntity);
        oldHoaDon.setNgayLap(hoaDonEntity.getNgayLap());
        hoaDonRepository.save(oldHoaDon);
        return "Cập nhật hóa đơn thành công";
    }

    @Override
    public String saveMayBay(MayBayEntity mayBayEntity) {
        MayBayEntity oldMayBay = mayBayRepository.findByIdAndTinhtrang(mayBayEntity.getId().toUpperCase(), "HOAT DONG BINH THUONG").orElse(null);
        if(oldMayBay != null) {
            return "Mã Máy bay đã trùng, vui lòng nhập lại!";
        }
        if (!checkIdMayBay(mayBayEntity.getId().toUpperCase())) {
            return "Mã máy bay không hợp lệ, vui lòng nhập lại!";
        }
        mayBayEntity.setId(mayBayEntity.getId().toUpperCase());
        mayBayRepository.save(mayBayEntity);
        return "Thêm máy bay thành công";
    }

    @Override
    public String updateMayBay(MayBayEntity mayBayEntity) {
        MayBayEntity oldMayBay = mayBayRepository.findById(mayBayEntity.getId().toUpperCase()).orElse(null);
        System.out.println(mayBayEntity.getId());
        if (!checkIdMayBay(mayBayEntity.getId().toUpperCase())) {
            return "Mã máy bay không hợp lệ, vui lòng nhập lại!";
        }
        System.out.println(mayBayEntity.getTen_may_bay());
        System.out.println(mayBayEntity.getTinhtrang());
        oldMayBay.setTen_may_bay(mayBayEntity.getTen_may_bay());
        oldMayBay.setTinhtrang(mayBayEntity.getTinhtrang());
        mayBayRepository.save(oldMayBay);
        return "Cập nhật máy bay thành công";
    }

    @Override
    public String saveNhanVien(NhanVienEntity nhanVienEntity, String maChiNhanh) {
        ChiNhanhEntity oldChiNhanh = chiNhanhRepository.findById(maChiNhanh.toUpperCase()).orElse(null);
        if(oldChiNhanh == null) {
            return "Chi nhánh này không tồn tại, vui lòng chonj chi nhánh khác!";
        }
        if (!checkIdNhanVien(nhanVienEntity.getId().toUpperCase())) {
            return "Mã nhân viên không hợp lệ, vui lòng nhập lại";
        }
        nhanVienEntity.setId(nhanVienEntity.getId().toUpperCase());
        nhanVienEntity.setChiNhanhEntity(oldChiNhanh);
        NhanVienEntity oldNhanVien = nhanVienRepository.findById(nhanVienEntity.getId().toUpperCase()).orElse(null);
        if(oldNhanVien != null) {
            return "Mã nhân viên đã tồn tài, vui lòng nhập lại!";
        }
        nhanVienRepository.save(nhanVienEntity);
        return "Thêm nhân viên thành công";
    }

    @Override
    public String updateNhanVien(NhanVienEntity nhanVienEntity, String maChiNhanh) {
        ChiNhanhEntity oldChiNhanh = chiNhanhRepository.findById(maChiNhanh.toUpperCase()).orElse(null);
        if(oldChiNhanh == null) {
            return "Chi nhánh này không tồn tại, vui lòng chonj chi nhánh khác!";
        }
        if (!checkIdNhanVien(nhanVienEntity.getId().toUpperCase())) {
            return "Mã nhân viên không hợp lệ, vui lòng nhập lại";
        }
        NhanVienEntity oldNhanVien = nhanVienRepository.findById(nhanVienEntity.getId().toUpperCase()).orElse(null);
        oldNhanVien.setChiNhanhEntity(oldChiNhanh);
        oldNhanVien.setSdt(nhanVienEntity.getSdt());
        oldNhanVien.setTen_nhan_vien(nhanVienEntity.getTen_nhan_vien());
        nhanVienRepository.save(oldNhanVien);
        return "Cập nhật nhân viên thành công";
    }

    @Override
    public String saveSanBay(SanBayEntity sanBayEntity) {
        SanBayEntity oldSanBay = sanBayRepository.findById(sanBayEntity.getId().toUpperCase()).orElse(null);
        if(oldSanBay != null) {
            return "Mã sân bay đã trùng, vui lòng nhập lại!";
        }
        if (!checkIdSanBay(sanBayEntity.getId().toUpperCase())) {
            return "Mã sân bay không hợp lệ!";
        }
        System.out.println(sanBayEntity.getDiachi());
        sanBayEntity.setId(sanBayEntity.getId().toUpperCase());
        sanBayRepository.save(sanBayEntity);
        return "Thêm sân bay thành công";
    }

    @Override
    public String updateSanBay(SanBayEntity sanBayEntity) {
        SanBayEntity oldSanBay = sanBayRepository.findById(sanBayEntity.getId().toUpperCase()).orElse(null);
        if (!checkIdSanBay(sanBayEntity.getId().toUpperCase())) {
            return "Mã sân bay không hợp lệ!";
        }
        oldSanBay.setDiachi(sanBayEntity.getDiachi());
        oldSanBay.setTen_san_bay(sanBayEntity.getTen_san_bay());
        sanBayRepository.save(oldSanBay);
        return "Cập nhật sân bay thành công";
    }

    @Override
    public String saveTuyenBay(TuyenBayEntity tuyenBayEntity, String maSanBayDi, String maSanBayDen) {
        if(maSanBayDen.toUpperCase().equals(maSanBayDi.toUpperCase())) {
            return "Sân bay đi và sân bay đến không được trùng nhau, vui lòng nhập lại";
        }
        SanBayEntity sanBayDi = sanBayRepository.findById(maSanBayDi.toUpperCase()).orElse(null);
        SanBayEntity sanBayDen = sanBayRepository.findById(maSanBayDen.toUpperCase()).orElse(null);

        TuyenBayEntity oldTuyenBay = tuyenBayRepository.findById(tuyenBayEntity.getId().toUpperCase()).orElse(null);
        if(oldTuyenBay != null) {
            return "Mã tuyến bay đã trùng, vui lòng nhập lại";
        }
        if(!checkIdTuyenBay(tuyenBayEntity.getId().toUpperCase())) {
            return "Mã tuyến bay không hợp lệ, vui lòng nhập lại!";
        }
        tuyenBayEntity.setId(tuyenBayEntity.getId().toUpperCase());
        tuyenBayEntity.setSanBayDi(sanBayDi);
        tuyenBayEntity.setSanBayDen(sanBayDen);
        tuyenBayRepository.save(tuyenBayEntity);
        return "Thêm tuyến bay thành công!";
    }

    @Override
    public String updateTuyenBay(TuyenBayEntity tuyenBayEntity, String maSanBayDi, String maSanBayDen) {
        if(maSanBayDen.toUpperCase().equals(maSanBayDi.toUpperCase())) {
            return "Sân bay đi và sân bay đến không được trùng nhau, vui lòng nhập lại";
        }
        SanBayEntity sanBayDi = sanBayRepository.findById(maSanBayDi.toUpperCase()).orElse(null);
        SanBayEntity sanBayDen = sanBayRepository.findById(maSanBayDen.toUpperCase()).orElse(null);

        TuyenBayEntity oldTuyenBay = tuyenBayRepository.findById(tuyenBayEntity.getId().toUpperCase()).orElse(null);

        if(!checkIdTuyenBay(tuyenBayEntity.getId().toUpperCase())) {
            return "Mã tuyến bay không hợp lệ, vui lòng nhập lại!";
        }
        oldTuyenBay.setSanBayDi(sanBayDi);
        oldTuyenBay.setSanBayDen(sanBayDen);
        oldTuyenBay.setTen_tuyen_bay(tuyenBayEntity.getTen_tuyen_bay());
        tuyenBayRepository.save(oldTuyenBay);
        return "Cập nhật tuyến bay thành công!";
    }

    @Override
    public String saveVe(VeEntity veEntity, String maChuyenBay, String maHoaDon) {
        ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.findById(maChuyenBay.toUpperCase()).orElse(null);
        HoaDonEntity hoaDonEntity = hoaDonRepository.findById(maHoaDon.toUpperCase()).orElse(null);
        VeEntity oldVe = veRepository.findById(veEntity.getId().toUpperCase()).orElse(null);
        if(oldVe != null) {
            return "Mã vé đã trùng, vui lòng nhập lại mã vé!";
        }
        hoaDonEntity.setThanhTien(hoaDonEntity.getThanhTien() + veEntity.getGiave());
        hoaDonEntity = hoaDonRepository.save(hoaDonEntity);
        veEntity.setChuyenBayEntity(chuyenBayEntity);
        veEntity.setHoaDonEntity(hoaDonEntity);
        veRepository.save(veEntity);
        return "Thêm vé thành công";
    }

    @Override
    public String updateVe(VeEntity veEntity, String maChuyenBay, String maHoaDon) {
        ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.findById(maChuyenBay.toUpperCase()).orElse(null);
        HoaDonEntity hoaDonEntity = hoaDonRepository.findById(maHoaDon.toUpperCase()).orElse(null);
        VeEntity oldVe = veRepository.findById(veEntity.getId().toUpperCase()).orElse(null);

        // TH chọn vé thuộc hóa đơn khác ==> thành tiền của hóa đơn cũ - giá của vé đang thay đổi
        if(!maHoaDon.equals(oldVe.getHoaDonEntity().getId())) {
            oldVe.getHoaDonEntity().setThanhTien(oldVe.getHoaDonEntity().getThanhTien() - oldVe.getGiave());
            hoaDonRepository.save(oldVe.getHoaDonEntity());
            oldVe.setHoaDonEntity(hoaDonEntity);
            hoaDonEntity.setThanhTien(hoaDonEntity.getThanhTien() + veEntity.getGiave());
            hoaDonRepository.save(hoaDonEntity);
        }
//        TH thay đổi giá vé
        if (veEntity.getGiave() != oldVe.getGiave()) {
            oldVe.getHoaDonEntity().setThanhTien(oldVe.getHoaDonEntity().getThanhTien() - oldVe.getGiave() + veEntity.getGiave());
            hoaDonRepository.save(oldVe.getHoaDonEntity());
        }
        oldVe.setGiave(veEntity.getGiave());
        oldVe.setLoaive(veEntity.getLoaive());
        oldVe.setVi_tri_so_ghe(veEntity.getVi_tri_so_ghe());
        veEntity.setChuyenBayEntity(chuyenBayEntity);
        veRepository.save(oldVe);
        return "Cập nhật vé thành công";
    }


    private boolean checkIdKhachHang(String maKhachHang) {
        return maKhachHang.startsWith("KH");
    }
//    private boolean checkIdChiNhanh(String maChiNhanh, String tenChiNhanh) {
//        String ma = tenChiNhanh.charAt(0) + tenChiNhanh.charAt()
//    }
    private boolean checkIdNhanVien(String maNhanVien) {
        return maNhanVien.startsWith("NV");
    }
    private boolean checkIdChuyenBay(String maChuyenBay) {
        return maChuyenBay.startsWith("CB");
    }
    private boolean checkIdHoaDon(String maHoaDon) {
        return maHoaDon.startsWith("HD");
    }
    private boolean checkIdMayBay(String maMayBay) {
        return maMayBay.startsWith("MB");
    }
    private boolean checkIdSanBay(String maSannBay) {
        return maSannBay.startsWith("SB");
    }
    private boolean checkIdTuyenBay(String maTuyenBay) {
        return maTuyenBay.startsWith("TB");
    }
    private boolean checkIdVe(String maVe) {
        return maVe.startsWith("V");
    }

//    ============================================= find one ===========================================================
    @Override
    public KhachHangEntity findOneKhachHang(String maKhachHang) {
        KhachHangEntity khachHangEntity = khachHangRepository.findById(maKhachHang).orElse(null);
        return khachHangEntity;
    }

    @Override
    public ChiNhanhEntity findOneChiNhanh(String maChiNhanh) {
        ChiNhanhEntity chiNhanhEntity = chiNhanhRepository.findById(maChiNhanh).orElse(null);
        return chiNhanhEntity;
    }

    @Override
    public ChuyenBayEntity findOneChuyenBay(String maChuyenBay) {
        ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.findById(maChuyenBay).orElse(null);
        return chuyenBayEntity;
    }

    @Override
    public HoaDonEntity findOneHoaDon(String maHoaDon) {
        HoaDonEntity hoaDonEntity = hoaDonRepository.findById(maHoaDon).orElse(null);
        return hoaDonEntity;
    }

    @Override
    public MayBayEntity findOneMayBay(String maMayBay) {
        MayBayEntity mayBayEntity = mayBayRepository.findById(maMayBay).orElse(null);
        return mayBayEntity;
    }

    @Override
    public NhanVienEntity findOneNhanVien(String maNhanVien) {
        NhanVienEntity nhanVienEntity = nhanVienRepository.findById(maNhanVien).orElse(null);
        return nhanVienEntity;
    }

    @Override
    public SanBayEntity findOneSanBay(String maSanBay) {
        SanBayEntity sanBayEntity = sanBayRepository.findById(maSanBay).orElse(null);
        return sanBayEntity;
    }

    @Override
    public TuyenBayEntity findOneTuyenBay(String maTuyenBay) {
        TuyenBayEntity tuyenBayEntity = tuyenBayRepository.findById(maTuyenBay).orElse(null);
        return tuyenBayEntity;
    }

    @Override
    public VeEntity findOneVe(String maVe) {
        VeEntity veEntity = veRepository.findById(maVe).orElse(null);
        return veEntity;
    }

//    =================================================== DELETE =======================================================
    @Override
    public String deleteKhachHang(String maKhachHang) {
//      xóa vé ==> xóa hóa đơn ==> xóa khách hàng
        List<HoaDonEntity> listHoaDon = hoaDonRepository.getAllByKhachHang(maKhachHang);
        for(HoaDonEntity hoaDon : listHoaDon) {
            List<VeEntity> listVe = veRepository.getAllByHoaDon(hoaDon.getId());
            for(VeEntity ve : listVe) {
                veRepository.deleteById(ve.getId());
            }
            hoaDonRepository.deleteById(hoaDon.getId());
        }
        khachHangRepository.deleteById(maKhachHang);
        return "Xóa khách hàng thành công";
    }

    @Override
    public String deleteChiNhanh(String maChiNhanh) {
//        Xóa chi nhánh ==> Xóa nhân viên ==> Xóa hóa đơn ==> Xóa vé
        List<NhanVienEntity> listNhanVien = nhanVienRepository.getAllByChiNhanh(maChiNhanh);
        for(NhanVienEntity nhanVien : listNhanVien) {
            List<HoaDonEntity> listHoaDon = hoaDonRepository.getAllByNhanVien(nhanVien.getId());
            for(HoaDonEntity hoaDon : listHoaDon) {
                List<VeEntity> listVe = veRepository.getAllByHoaDon(hoaDon.getId());
                xoaVe(listVe);
                hoaDonRepository.deleteById(hoaDon.getId());
            }
            nhanVienRepository.deleteById(nhanVien.getId());
        }
        chiNhanhRepository.deleteById(maChiNhanh);
        return "Xóa chi nhánh thành công";
    }

    @Override
    public String deleteChuyenBay(String maChuyenBay) {
//        Xóa chuyến bay ==> Xóa ve
        List<VeEntity> listVe = veRepository.getAllByChuyenBay(maChuyenBay);
        xoaVe(listVe);
        chuyenBayRepository.deleteById(maChuyenBay);
        return "Xóa chuyến bay thành công";
    }

    @Override
    public String deleteHoaDon(String maHoaDon) {
//        Xóa hóa đơn ==> Xóa vé
        List<VeEntity> listVe = veRepository.getAllByHoaDon(maHoaDon);
        xoaVe(listVe);
        hoaDonRepository.deleteById(maHoaDon);
        return "Xóa hóa đơn thành công";
    }

    @Override
    public String deleteMayBay(String maMayBay) {
//        Xóa may bay ==> Xóa chuyến bay ==> xoa ve
        List<ChuyenBayEntity> listChuyenBay = chuyenBayRepository.getALlByMaybay(maMayBay);
        for(ChuyenBayEntity chuyenBay : listChuyenBay) {
            List<VeEntity> listVe = veRepository.getAllByChuyenBay(chuyenBay.getId());
            xoaVe(listVe);
            chuyenBayRepository.deleteById(chuyenBay.getId());
        }
        mayBayRepository.deleteById(maMayBay);
        return "Xóa máy bay thành công";
    }

    @Override
    public String deleteNhanVien(String maNhanVien) {
//        Xóa nhân viên ==> xóa hóa đơn ==> xóa ve
        List<HoaDonEntity> listHoaDon = hoaDonRepository.getAllByNhanVien(maNhanVien);
        for(HoaDonEntity hoaDon : listHoaDon) {
            List<VeEntity> listVe = veRepository.getAllByHoaDon(hoaDon.getId());
            xoaVe(listVe);
            hoaDonRepository.deleteById(hoaDon.getId());
        }
        nhanVienRepository.deleteById(maNhanVien);
        return "Xóa nhân viên thành công";
    }

    @Override
    public String deleteSanBay(String maSanBay) {
//      xóa ve ==> xóa chuyến bay ==> xóa tuyến bay ==> xóa sân bay
        List<TuyenBayEntity> listTuyenBay = tuyenBayRepository.getAllBySanBay(maSanBay);
        for(TuyenBayEntity tuyenBay : listTuyenBay) {
            List<ChuyenBayEntity> listChuyenBay = chuyenBayRepository.getALlByTuyenbay(tuyenBay.getId());
            for(ChuyenBayEntity chuyenBay : listChuyenBay) {
                List<VeEntity> listVe = veRepository.getAllByChuyenBay(chuyenBay.getId());
                xoaVe(listVe);
                chuyenBayRepository.deleteById(chuyenBay.getId());
            }
            tuyenBayRepository.deleteById(tuyenBay.getId());
        }
        sanBayRepository.deleteById(maSanBay);
        return "Xóa sân bay thành công";
    }

    @Override
    public String deleteTuyenBay(String maTuyenBay) {
//        xoa ve ==> xoa chuyen bay ==> xoa tuyen bay
        List<ChuyenBayEntity> listChuyenBay = chuyenBayRepository.getALlByTuyenbay(maTuyenBay);
        for(ChuyenBayEntity chuyenBay : listChuyenBay) {
            List<VeEntity> listVe = veRepository.getAllByChuyenBay(chuyenBay.getId());
            xoaVe(listVe);
            chuyenBayRepository.deleteById(chuyenBay.getId());
        }
        tuyenBayRepository.deleteById(maTuyenBay);
        return "Xóa tuyến bay thành công";
    }

    @Override
    public String deleteVe(String maVe) {
        veRepository.deleteById(maVe);
        return "Xóa vé thành công!";
    }

    private void xoaVe(List<VeEntity> listVe) {
        for(VeEntity ve : listVe) {
            veRepository.deleteById(ve.getId());
        }
    }
}
