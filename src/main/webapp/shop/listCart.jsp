<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 18-Nov-21
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="../css/style.css">
    <title>Cart List</title>
</head>
<body>
<div id="header" style="height: 85px">
    <div class="container-fluid d-flex justify-content-between">
        <div class="wrap1 d-flex">
            <div>
                <a href="/shops">
                    <img id="logo"
                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Shopee.svg/2560px-Shopee.svg.png">
                </a>
            </div>
            <div style="font-size: 24px; color: #222; margin-top: 28px">
                Kênh người bán
            </div>
        </div>

        <div class="name-account wrap2 d-flex align-items-center" style="margin-top: 20px; margin-right: 140px">
            <i class="fas fa-user" style="margin-right: 10px"></i>
            <p style="margin-right: 10px; margin-right: 10px; position: relative; top: 8px">${account.name}</p>
            <a href="/accounts?action=logout" style=" color:#222;">Logout</a>
        </div>
    </div>
</div>

<div id="main-secsion">
    <div class="container-fluid d-flex justify-content-between" style="background: #f6f6f6">
        <div id="sidebar-menu" style="width: 20%; height: 100%; background: white">
            <div class="container-fluid">
                <h3 class="text-center mt-3" style="margin-bottom: 20px">
                    Danh mục
                </h3>
                <ul class="list-group">
                    <h5>Quản lý đơn hàng</h5>
                    <a href="/shops?action=showAllCart&idShop=${shop.idShop}">
                        <li class="list-group-item">Tất cả</li>
                    </a>
                    <a href="">
                        <li class="list-group-item">Đơn hàng đã xử lý</li>
                    </a>
                    <a href="">
                        <li class="list-group-item">Đơn hàng chưa xử lý</li>
                    </a>
                </ul>
            </div>
        </div>
        <div id="content"
             style="width: 79%; height: 100%; background: white; margin-top: 10px; box-shadow: 0 1px 4px 0 darkgrey;">
            <div class="container-fluid">
                <div class="row text-center mt-5 mb-5">
                    <h1 class="text-title">Tất cả đơn hàng</h1>
                </div>
                <div class="row">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Mã giỏ hàng</th>
                            <th scope="col">Tên khách hàng</th>
                            <th scope="col">Ngày tạo</th>
                            <th scope="col">Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cartList}" var="cart">
                            <a href="">
                                <tr>
                                    <td>${cart.idCart}</td>
                                    <td>${cart.getAccount().getName()}</td>
                                    <td>${cart.createDate}</td>
                                    <c:if test="${cart.status == 0}">
                                        <td> Chưa xử lý</td>
                                    </c:if>
                                    <c:if test="${cart.status == 1}">
                                        <td> Đã xử lý</td>
                                    </c:if>
                                </tr>
                            </a>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
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
