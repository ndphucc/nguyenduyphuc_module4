<%--
  Created by IntelliJ IDEA.
  User: hoangsangnguyen
  Date: 15/07/2022
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="text-center">
        <h3>TỜ KHAI Y TẾ</h3>
        <p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</p>
        <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</p>
    </div>
    <form:form method="post" modelAttribute="medicalDeclaration" action="update">
    <div class="mb-3">
        <form:label path="name" class="form-label">Họ Tên (ghi in Chữ Hoa)</form:label>
        <form:input path="name" class="form-control"/>
    </div>
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <form:label path="yearOfDate" class="form-label">Năm Sinh</form:label>
                <form:select path="yearOfDate" items="${years}" class="form-select"/>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Giới tính</label>
                <form:select path="gender" class="form-select">
                    <c:if test="${medicalDeclaration.gender == 0}">
                        <option value="0" selected>Nữ</option>
                        <option value="1">Nam</option>
                    </c:if>
                    <c:if test="${medicalDeclaration.gender == 1}">
                        <option value="0">Nữ</option>
                        <option value="1" selected>Nam</option>
                    </c:if>
                </form:select>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Quốc tịch</label>
                <form:select path="nationality" class="form-control" items="${nationality}"/>
            </div>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label">Số hộ chiếu hoặc CMND hoặc giấy tờ thông hành khác</label>
        <form:input path="idCard" class="form-control" placeholder="VD: 124332"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Thông tin đi lại</label>
        <div>
            <form:radiobuttons path="vehicle" items="${vehicle}"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Số hiệu phương tiện</label>
                <form:input path="vehicleNumber" cssClass="form-control"/>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">số ghế</label>
                <form:input path="seats" cssClass="form-control"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Ngày khởi hành</label>
                <div class="row">
                    <div class="col-4">
                        <form:select path="departureDay" items="${day}" cssStyle="width: 100%"/>
                    </div>
                    <div class="col-4">
                        <form:select path="departureMonth" items="${month}" cssStyle="width: 100%"/>
                    </div>
                    <div class="col-4">
                        <form:select path="departureYear" items="${years}" cssStyle="width: 100%"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Ngày kết thúc</label>
                <div class="row">
                    <div class="col-4">
                        <form:select path="endDay" items="${day}" cssStyle="width: 100%"/>
                    </div>
                    <div class="col-4">
                        <form:select path="endMonth" items="${month}" cssStyle="width: 100%"/>
                    </div>
                    <div class="col-4">
                        <form:select path="endYear" items="${years}" cssStyle="width: 100%"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào?</label>
        <form:textarea path="city" class="form-control"/>
    </div>
</div>
<div class="text-center p-2">
    <form:button>Gửi</form:button>
</div>
</form:form>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>