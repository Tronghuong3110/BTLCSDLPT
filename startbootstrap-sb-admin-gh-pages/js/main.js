const url = "http://localhost:8082/api";
// KHACHS HANG
function start(name, t, x, id) {
    $.ajax({
        type: "GET",
        dateType: "json",
        url: url + name,
        success: function(data){
            if(t === 1) {
                render(data,name)
            }
            if(t === 0) {
                // const name = $(".js-test").data("test");
                $(".js-render-form").append(renderSelcet(x, data, id));
            }
        }
    })
}

function renderSelcet(name, data, id) {
    var html;
    // chuyen bay
    if(name === "CB") { // chon tuyen bay va may bay
        html = `
            <label class="label-text js-text-header">Mã chuyến bay :</label>
            <select name = "maCB">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn chuyến bay ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // hoa don
    else if(name === "HD") { // chon khach hang
        html = `
            <label class="label-text js-text-header">Mã hóa đơn :</label>
            <select name = "maHD">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn hóa đơn ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // SAN BAY
    else if(name === "maSBDi" || name === "maSBDen") { // chon khach hang
        var ma;
        if(name === "maSBDi") {
            ma = "Mã sân bay đi"
        }
        else {
            ma = "Mã sân bay đến"
        }
        html = `
            <label class="label-text js-text-header">${ma} :</label>
            <select name = "${name}">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn ${ma} ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // CHI NHANH
    else if(name === "CN") { // chon khach hang
        html = `
            <label class="label-text js-text-header">Mã chi nhánh :</label>
            <select name = "maCN">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn chi nhánh ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // KHACH HANG
    else if(name === "KH") { // chon khach hang
        html = `
            <label class="label-text js-text-header">Mã Khách hàng :</label>
            <select name = "maKH">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn khách hàng ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // MAY BAY
    else if(name === "MB") { // chon khach hang
        html = `
            <label class="label-text js-text-header">Mã máy bay :</label>
            <select name = "maMB">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn máy bay ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    // nhan vien
    else if(name === "NV") { // chon chi nhanh
        html = `
            <label class="label-text js-text-header">Mã nhân viên :</label>
            <select name = "maNV">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn nhân viên ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    //tuyen bay
    else if(name === "TB") { // chon san bay den va san bay di
        html = `
            <label class="label-text js-text-header">Mã tuyến bay :</label>
            <select name = "maTB">
        `
        if(id) {
            html += `
                <option value="${id}">${id}</option>
            `
        }
        else {
            html += `
                <option value="null">--- Chọn tuyến bay ---</option>
            `
        }
        $.each($(data), function (i, item) { 
            if(!id || id !== item.id) {  
                html += `
                    <option value="${item.id}">${item.id}</option>
                `
            }
                
        })
    }
    html += `</select>`
    return html;
}

function render(data,name) {
    $('.renderTable').html(checkRender(data,name));
}

function checkRender(data,name) {
    var html =""
    // Chi nhánh
    if(name ==="/chinhanhs") {
        $(".title").text("BẢNG CHI NHÁNH")
        html+=`
            <thead>
                <th>Mã chi nhánh</th>
                <th>Tên chi nhanh</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
            <tr>
                    <td>${value.id}</td>
                    <td>${value.ten_chi_nhanh}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/chinhanh')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/chinhanh')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
        $(".js-test").val("Thêm chi nhánh")
        $(".js-test").data("test", "CN")
    }
    //Chuyến bay
    else if(name ==="/chuyenbays") {
        $(".title").text("BẢNG CHUYẾN BAY")
        $(".js-test").val("Thêm chuyến bay")
        $(".js-test").data("test", "CB")
        html+=`
            <thead>
                <th>Mã chuyến bay</th>
                <th>Ngày khởi hành</th>
                <th>Giờ khởi hành</th>
                <th>Sân bay đi</th>
                <th>Sân bay đến</th>
                <th>Mã máy bay</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
                <tr>
                    <td>${value.id}</td>
                    <td>${value.ngay_khoi_hanh}</td>
                    <td>${value.gio_khoi_hanh}</td>
                    <td>${value.tuyenBayEntity.sanBayDi.ten_san_bay}</td>
                    <td>${value.tuyenBayEntity.sanBayDen.ten_san_bay}</td>
                    <td>${value.mayBayEntity.id}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/chuyenbay')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/chuyenbay')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }
    //Tuyến bay
    else if(name ==="/tuyenbays") {
        $(".title").text("BẢNG TUYẾN BAY")
        $(".js-test").val("Thêm tuyến bay")
        $(".js-test").data("test", "TB")
        html+=`
            <thead>
                <th>Mã tuyến bay</th>
                <th>Tên tuyến bay</th>
                <th>Sân bay đi</th>
                <th>Sân bay đến</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
            <tr>
                    <td>${value.id}</td>
                    <td>${value.ten_tuyen_bay}</td>
                    <td>${value.sanBayDi.ten_san_bay}</td>
                    <td>${value.sanBayDen.ten_san_bay}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/tuyenbay')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/tuyenbay')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }
    //Sân bay
    else if(name ==="/sanbays") {
        $(".title").text("BẢNG SÂN BAY")
        $(".js-test").val("Thêm sân bay")
        $(".js-test").data("test", "SB")
        html+=`
            <thead>
                <th>Mã sân bay</th>
                <th>Tên sân bay</th>
                <th>Địa chỉ</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
            <tr>
                    <td>${value.id}</td>
                    <td>${value.ten_san_bay}</td>
                    <td>${value.diachi}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/sanbay')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/sanbay')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }
    //Máy bay
    else if(name ==="/maybays") {
        $(".title").text("BẢNG MÁY BAY")
        $(".js-test").val("Thêm máy bay")
        $(".js-test").data("test", "MB")
        html+=`
            <thead>
                <th>Mã máy bay</th>
                <th>Tên máy bay</th>
                <th>Tình trạng</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
            <tr>
                    <td>${value.id}</td>
                    <td>${value.ten_may_bay}</td>
                    <td>${value.tinhtrang}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/maybay')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/maybay')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }
    // khach hang
    else if(name ==="/khachhangs") {
        $(".title").text("BẢNG KHÁCH HÀNG")
        html+=`
            <thead>
                <th>Mã khách hàng</th>
                <th>Tên khách hàng</th>
                <th>Địa chỉ</th>
                <th>Căn cước công dân</th>
                <th>Ngày sinh</th>
                <th>Số điện thoại</th>
                <th>Tác vụ</th>
            </thead>
            <tboby class="thead-dark">
        `
        $.each($(data), function(index,value){
            html+= `
            <tr>
                    <td>${value.id}</td>
                    <td>${value.ten}</td>
                    <td>${value.diachi}</td>
                    <td>${value.cmnd}</td>
                    <td><input type="date" value="${value.ngaysinh}" disabled></td>
                    <td>${value.sdt}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/khachhang')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/khachhang')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
        $(".js-test").val("Thêm khách hàng");
        $(".js-test").data("test", "KH")
        console.log($(".js-test").val())
    }
    // hoa don
    else if(name ==="/hoadons") {
        $(".title").text("BẢNG HÓA ĐƠN")
        $(".js-test").val("Thêm hóa đơn")
        $(".js-test").data("test", "HD")
        html+=`
            <thead>
                <th>Mã hóa đơn</th>
                <th>Ngày lập</th>
                <th>Thành tiền</th>
                <th>Mã khách hàng</th>
                <th>Tên khách hàng</th>
                <th>Mã nhân viên</th>
                <th>Tên nhân viên</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
                <tr>
                    <td>${value.id}</td>
                    <td>${value.ngayLap}</td>
                    <td>${value.thanhTien}</td>
                    <td>${value.khachHangEntity.id}</td>
                    <td>${value.khachHangEntity.ten}</td>
                    <td>${value.nhanVienEntity.id}</td>
                    <td>${value.nhanVienEntity.ten_nhan_vien}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/hoadon')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/hoadon')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }

    // nhan vien
    else if(name ==="/nhanviens") {
        $(".title").text("BẢNG NHÂN VIÊN")
        $(".js-test").val("Thêm nhân viên")
        $(".js-test").data("test", "NV")
        html+=`
            <thead>
                <th>Mã nhân viên</th>
                <th>Tên nhân viên</th>
                <th>Số điện thoại</th>
                <th>Mã chi nhánh</th>
                <th>Tên chi nhánh</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
                <tr>
                    <td>${value.id}</td>
                    <td>${value.ten_nhan_vien}</td>
                    <td>${value.sdt}</td>
                    <td>${value.chiNhanhEntity.id}</td>
                    <td>${value.chiNhanhEntity.ten_chi_nhanh}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/nhanvien')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/nhanvien')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        html+=`</tboby>
            `
    }
    // vé
    else {
        $(".title").text("BẢNG VÉ")
        $(".js-test").val("Thêm vé")
        // $(".js-test").attr("data-test", "V")
        $(".js-test").data("test", "V")
        html+=`
            <thead>
                <th>Mã vé</th>
                <th>Loại vé</th>
                <th>Giá vé</th>
                <th>Vị trí ghế</th>
                <th>Mã chuyến bay</th>
                <th>Sân bay đi</th>
                <th>Sân bay đến</th>
                <th>Mã hóa đơn</th>
                <th>Tên khách hàng</th>
                <th>Thao tác</th>
            </thead>
            <tboby>
        `
        $.each($(data), function(index,value){
            html+= `
                <tr>
                    <td>${value.id}</td>
                    <td>${value.loaive}</td>
                    <td>${value.giave}</td>
                    <td>${value.vi_tri_so_ghe}</td>
                    <td>${value.chuyenBayEntity.id}</td>
                    <td>${value.chuyenBayEntity.tuyenBayEntity.sanBayDi.ten_san_bay}</td>
                    <td>${value.chuyenBayEntity.tuyenBayEntity.sanBayDen.ten_san_bay}</td>
                    <td>${value.hoaDonEntity.id}</td>
                    <td>${value.hoaDonEntity.khachHangEntity.ten}</td>
                    <td class="btn-container">
                        <button onclick="edit('${value.id}', '/ve')" class="btn-edit" data-toggle="modal" data-target="#myModal"> <i class="fa-solid fa-wrench second-icon" style="color: #ffffff;"></i> Chỉnh sửa </button>
                        <button onclick="xoa('${value.id}', '/ve')" class="btn-delete"> <i class="fa-solid fa-trash second-icon" style="color: #ffffff;"></i> Xóa </button>
                    </td>
                </tr>
            `
        })
        console.log(data)
        html+=`</tboby>
            `
    }
    return html
}
// them moi
function addNew(typeUrl){
    var obj = getDataInput();
    if(obj) {
        if(obj["gio_khoi_hanh"]) {
            obj["gio_khoi_hanh"] = obj["gio_khoi_hanh"] + ":00";
        }
        console.log(typeUrl);
        const api = obj["API"];
        console.log(obj)
        const extensionUrl = addUrl(obj);
        delete obj["API"];
        console.log(url + api + extensionUrl)
        $.ajax({
            type: typeUrl,
            url: url + api + extensionUrl,
            dateType: "TEXT",
            contentType: "application/json",
            data: JSON.stringify(obj),
            success: function(message){
                start(obj["index"], 1);
                $("#myModal").removeClass('in');
                // $("#myModal").css('display','none');
                $("body").removeClass("modal-open");
                $(".modal-backdrop").removeClass("in");
                alert(message);
            },
            error: function(xhr, status, mes) {
                alert("Error " + mes.message)
            }
        })
    } else {
        alert("VUi lòng chọn đầy đủ thông tin")
    }
    
    // console.log(obj);
}
function updateOrNew(index) {
    const type = index === 1 ? "PUT" : "POST"
    addNew(type)
} 
// edit
function edit(id, name) {

    if(name === "/chinhanh") {
        $(".title-modal").text("CHỈNH CHI NHÁNH");
        $(".js-render-form").html(modalChiNhanh());
        findOne(url+name+`?id=${id}`)
    }
    else if(name === "/chuyenbay") {
        $(".title-modal").text("CHỈNH CHUYẾN BAY");
        $(".js-render-form").html(modalChuyenBay());
        findOne(url+name+`?id=${id}`, name)
    }
    else if(name === "/hoadon") {
        $(".title-modal").text("CHỈNH HÓA ĐƠN");
        $(".js-render-form").html(modalHoaDon());
        findOne(url+name+`?id=${id}`, name)
    }
    else if(name === "/khachhang") {
        $(".title-modal").text("CHỈNH KHÁCH HÀNG");
        $(".js-render-form").html(modalKhachHang());
        findOne(url+name+`?id=${id}`)
    }
    else if(name === "/maybay") {
        $(".title-modal").text("CHỈNH MÁY BAY");
        $(".js-render-form").html(modalMayBay());
        findOne(url+name+`?id=${id}`)
    }
    else if(name === "/nhanvien") {
        $(".title-modal").text("CHỈNH NHÂN VIÊN");
        $(".js-render-form").html(modalNhanVien());
        findOne(url+name+`?id=${id}`, name)
    }
    else if(name === "/sanbay") {
        $(".title-modal").text("CHỈNH SÂN BAY");
        $(".js-render-form").html(modalSanBay());
        findOne(url+name+`?id=${id}`)
    }
    else if(name === "/tuyenbay") {
        $(".title-modal").text("CHỈNH TUYẾN BAY");
        $(".js-render-form").html(modalTuyenBay());
        findOne(url+name+`?id=${id}`, name)
    }
    else if(name === "/ve") {
        $(".title-modal").text("CHỈNH SỬA VÉ");
        $(".js-render-form").html(modalVe());
        findOne(url+name+`?id=${id}`, name)
    }
    $(".js-btn-save").css("display", "none");
    $(".js-btn-update").css("display", "inline-block");
}

function findOne(urlfindOne, name) {
    console.log(urlfindOne)
    $.ajax({
        url: urlfindOne,
        type: "GET",
        dateType: "json",
        success: function(response) {
            console.log(response)
            setValue(response, name)
        },
        error: function() {
            alert("Lỗi find One rồi!");
        }
    })
}

function setValue(data, name) {
    // set value of input
    Object.keys(data).map(function (key) { 
       $(".js-render-form input").each(function() {
            const name = $(this).attr("name");
            if(key === name) {
                $(this).val(data[key]);
            }
            if(name === "id") {
                $(this).attr("disabled", true);
            }
       })
    });
    if(name === "/chuyenbay") {
        start("/tuyenbays", 0, "TB", data.tuyenBayEntity.id);
        start("/maybays", 0, "MB", data.mayBayEntity.id);
    }
    else if(name === "/hoadon") {
        start("/nhanviens", 0, "NV", data.nhanVienEntity.id);
        start("/khachhangs", 0, "KH", data.khachHangEntity.id);
    }
    else if(name === "/nhanvien") {
        start("/chinhanhs", 0, "CN", data.chiNhanhEntity.id);
    }
    else if(name === "/tuyenbay") {
        start("/sanbays", 0, "maSBDi", data.sanBayDi.id);
        start("/sanbays", 0, "maSBDen", data.sanBayDen.id);
    }
    else if(name === "/ve") {
        start("/chuyenbays", 0, "CB", data.chuyenBayEntity.id);
        start("/hoadons", 0, "HD", data.hoaDonEntity.id);
    }
}

// delete
function xoa(id, name) {
    var check = confirm(`Ban muốn xóa ${id} này không?`)
    if(check) {
        console.log(url + name + `?id=${id}`)
        $.ajax({
            url: url + name + `?id=${id}`,
            type: "DELETE",
            dateType: "TEXT",
            contentType: "application/json",
            success: function(message) {
                start(name+"s", 1);
                alert(message);
            },
            error: function(xhr, status, message) {
                alert("Xóa không thành công!")
                alert("Error " + message.message)
            }
        })
    }
}

function onpenModal() {
    const title = $(".js-test").val();
    $(".title-modal").text(title);
    $(".js-btn-save").css("display", "inline-block")
    $(".js-btn-update").css("display", "none")
    const name = $(".js-test").data("test");
    // chi nhanh
    console.log(name)
    if(name === "CN") {
        $(".js-render-form").html(modalChiNhanh());
    }
    // chuyen bay
    else if(name === "CB") {
       $(".js-render-form").html(modalChuyenBay());
        start("/maybays", 0, "MB");
        start("/tuyenbays", 0, "TB")
    }
    // hoa don
    else if(name === "HD") {
       $(".js-render-form").html(modalHoaDon());
        start("/khachhangs", 0, "KH");
        start("/nhanviens", 0, "NV");
    }
    //khach hang
    else if(name === "KH") {
       $(".js-render-form").html(modalKhachHang());
    }
    // may bay
    else if(name === "MB") {
       $(".js-render-form").html(modalMayBay());
    }
    // nhan vien
    else if(name === "NV") {
       $(".js-render-form").html(modalNhanVien());
        start("/chinhanhs", 0, "CN")
    }
    // san bay
    else if(name === "SB") {
       $(".js-render-form").html(modalSanBay());
    }
    //tuyen bay
    else if(name === "TB") {
       $(".js-render-form").html(modalTuyenBay());
        start("/sanbays", 0, "maSBDi");
        start("/sanbays", 0, "maSBDen");
    }
    // ve
    else {
       $(".js-render-form").html(modalVe());
       start("/hoadons", 0, "HD");
       start("/chuyenbays", 0, "CB");
    }
}

// chi nhanh
function modalChiNhanh() {
    return `
        <label for="id" class="label-text">Mã chi nhánh :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ten_chi_nhanh" class="label-text">Tên chi nhánh :</label>
        <br>
        <input type="text" id="ten_chi_nhanh" name="ten_chi_nhanh" class="input-field" required>
        <br>
        <br>
        <input type="hidden" name="API" value="/chinhanh">
        <input type="hidden" name="index" value="/chinhanhs">
        <!-- <div class="clear"></div> -->
        
    `
}
// chuyen bay
function modalChuyenBay() {
    return `
        <label for="id" class="label-text">Mã chuyến bay :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ngay_khoi_hanh" class="label-text">Ngày khởi hành :</label>
        <br>
        <input type="date" id="ngay_khoi_hanh" name="ngay_khoi_hanh" class="input-field" required>
        <br>
        <label for="gio_khoi_hanh" class="label-text">Giờ khởi hành :</label>
        <br>
        <input type="time" id="gio_khoi_hanh" name="gio_khoi_hanh" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/chuyenbay">
        <input type="hidden" name="index" value="/chuyenbays">
    `
}
// hoa don
function modalHoaDon() {
    return `
        <label for="id" class="label-text">Mã hóa đơn :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ngaylap" class="label-text">Ngày lập :</label>
        <br>
        <input type="date" id="ngaylap" name="ngaylap" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" value="0" name="thanhhtien">
        <input type="hidden" name="API" value="/hoadon">
        <input type="hidden" name="index" value="/hoadons">
        
    `
}
// khach hang
function modalKhachHang() {
    return `
        <label for="id" class="label-text js-text-header">Mã khách hàng :</label>
        <br>
        <input type="text" name="id" id="id" class="input-field" placeholder="KH..." required>
        <br>
        <label for="ten" class="label-text js-text-header">Tên khách hàng : </label>
        <br>
        <input type="text" name="ten" id="ten" class="input-field" required>
        <br>
        <label for="diachi" class="label-text">Địa chỉ :</label>
        <br>
        <input type="text" id="diachi" name="diachi" class="input-field" required>
        <br>
        <label for="sdt" class="label-text">Số điện thoại :</label>
        <br>
        <input type="text" id="sdt" name="sdt" class="input-field" required>
        <br>
        <label for="cmnd" class="label-text">Số căn cước :</label>
        <br>
        <input type="text" id="cmnd" name="cmnd" class="input-field" required>
        <br>
        <label for="ngaysinh" class="label-text">Ngày sinh :</label>
        <br>
        <input type="date" id="ngaysinh" name="ngaysinh" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/khachhang">
        <input type="hidden" name="index" value="/khachhangs">
    `
}
// may bay
function modalMayBay() {
    return `
        <label for="id" class="label-text">Mã máy bay :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ten_may_bay" class="label-text">Tên máy bay :</label>
        <br>
        <input type="text" id="ten_may_bay" name="ten_may_bay" class="input-field" required>
        <br>
        <label for="tinhtrang" class="label-text">Tình trạng máy bay :</label>
        <br>
        <input type="text" id="tinhtrang" name="tinhtrang" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/maybay">
        <input type="hidden" name="index" value="/maybays">
    `
}
// nhan vien
function modalNhanVien() {
    return `
        <label for="id" class="label-text">Mã nhân viên :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ten_nhan_vien" class="label-text">Tên nhân viên :</label>
        <br>
        <input type="text" id="ten_nhan_vien" name="ten_nhan_vien" class="input-field" required>
        <br>
        <label for="sdt" class="label-text">Số điện thoại :</label>
        <br>
        <input type="text" id="sdt" name="sdt" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/nhanvien">
        <input type="hidden" name="index" value="/nhanviens">
    `
}
// san bay
function modalSanBay() {
    return `
        <label for="id" class="label-text">Mã sân bay :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="diachi" class="label-text">Địa chỉ sân bay :</label>
        <br>
        <input type="text" id="diachi" name="diachi" class="input-field" required>
        <br>
        <label for="ten_san_bay" class="label-text">Tên sân bay :</label>
        <br>
        <input type="text" id="ten_san_bay" name="ten_san_bay" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/sanbay">
        <input type="hidden" name="index" value="/sanbays">
    `
}
// tuyen bay
function modalTuyenBay() {
    return `
        <label for="id" class="label-text">Mã tuyến bay :</label>
        <br>
        <input type="text" id="id" name="id" class="input-field" required>
        <br>
        <label for="ten_tuyen_bay" class="label-text">Tên tuyến bay :</label>
        <br>
        <input type="text" id="ten_tuyen_bay" name="ten_tuyen_bay" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/tuyenbay">
        <input type="hidden" name="index" value="/tuyenbays">
    `
}
// ve
function modalVe() {
    return `
        <label for="id" class="label-text js-text-header">Mã vé : </label>
        <br>
        <input type="text" name="id" id="id" class="input-field" required>
        <br>
        <label for="giave" class="label-text">Giá vé :</label>
        <br>
        <input type="number" id="giave" name="giave" class="input-field" required>
        <br>
        <label for="vi_tri_so_ghe" class="label-text">Vị trí số ghế :</label>
        <br>
        <input type="number" id="vi_tri_so_ghe" name="vi_tri_so_ghe" class="input-field" required>
        <br>
        <label for="loaive" class="label-text">Loại vé :</label>
        <br>
        <input type="text" id="loaive" name="loaive" class="input-field" required>
        <br>
        <br>
        <div class="clear"></div>
        <input type="hidden" name="API" value="/ve">
        <input type="hidden" name="index" value="/ves">
    `
}

function getDataInput() {
    var obj = {};
    var check = 0;
    $(".js-render-form input").each(function() {
        if($(this).val()) {
            obj[$(this).attr("name")] = $(this).val();
            // console.log($(this).val())
        }
        else check = 1;
    })
    $(".js-render-form select").each(function() {
        if($(this).val() != 'null') {
            obj[$(this).attr("name")] = $(this).val();
        }
        else check = 1;
        console.log($(this).val())
    })
    return check === 1 ? null : obj;
}

function addUrl(obj) {
    var tmp;
    if(obj["maTB"] && obj["maMB"]) {
        tmp = `/${obj["maTB"]}/${obj["maMB"]}`;
    }
    else if (obj["maCN"]) {
        tmp = `/${obj["maCN"]}`;
    }
    else if(obj["maSBDi"] && obj["maSBDen"]) {
        tmp = `/${obj["maSBDi"]}/${obj["maSBDen"]}`;
    }
    else if(obj["maKH"] && obj["maNV"]) {
        tmp = `/${obj["maKH"]}/${obj["maNV"]}`;
    }
    else if(obj["maCB"] && obj["maHD"]) {
        tmp = `/${obj["maHD"]}/${obj["maCB"]}`;
    }
    else tmp = '';
    return tmp;
}