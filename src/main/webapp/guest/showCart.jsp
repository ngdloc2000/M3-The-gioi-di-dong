<%--
  Created by IntelliJ IDEA.
  User: namkh
  Date: 11/17/2021
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Cart</title>
    <link rel="stylesheet" href="../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div id="header" style="height: 85px">
    <div class="container-fluid d-flex justify-content-between">
        <div class="wrap1 d-flex">
            <div>
                <a href="/guest">
                    <img id="logo"
                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Shopee.svg/2560px-Shopee.svg.png">
                </a>
            </div>
            <div style="font-size: 24px; color: #222; margin-top: 28px">
                Shoppe
            </div>
        </div>

        <div class="name-account wrap2 d-flex align-items-center" style="margin-top: 20px; margin-right: 140px">
            <i class="fas fa-user" style="margin-right: 10px"></i>
            <p style="margin-right: 10px; margin-right: 10px; position: relative; top: 8px">XXX</p>
            <a href="/accounts?action=logout" style=" color:#222;">Logout</a>
        </div>
    </div>
</div>
<div class="container">
    <h1 class="text-center" style="color: #ef4c29">Shopping Cart</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Tên SP</th>
            <th scope="col">Số Lượng SP</th>
            <th scope="col">Giá</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="t">
            <tr>
                <td>${t.getNameProduct()}</td>
                <td>${t.getNumber()}</td>
                <td>${t.getPrice()}</td>
                <td>${t.getTotal()}</td>
                <td>
                    <a class="btn btn-outline-dark me-3 mx-1"  style="width: 100px; height: 30px" role="button" href="/guest">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="d-flex" style="margin-left: 700px">
        <a class="btn btn-outline-dark me-3"  style="width: 162px" role="button" href="/guest">Về trang chủ</a>
        <a class="btn btn-outline-dark me-3"  style="width: 162px" role="button" href="/guest?action=pay&idCart=${idCart}">Mua Hàng</a>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
