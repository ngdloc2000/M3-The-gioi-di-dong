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
    <title>Home</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .sidebar{
            position: sticky;
            top: 0;
            z-index: 8;
        }
    </style>
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
            <div>
                <i class="fas fa-cart-plus"></i>
                <a class="btn btn-outline-dark me-3"  style="width: 100px" role="button" href="/guest?action=showcart&idCart=${cart.idCart}">My Cart</a>
            </div>


            <a href="/accounts?action=logout" style=" color:#222;">Logout</a>
        </div>
    </div>
</div>

<div id="main-secsion">
    <div class="container-fluid d-flex justify-content-between" style="background: #f6f6f6">
        <div class="sidebar" id="sidebar-menu" style="width: 20%; height: 100%; background: white">
            <div class="container-fluid">
                <h3 class="text-center mt-3" style="margin-bottom: 20px">
                    Danh mục
                </h3>
                <ul class="list-group">
                    <h5>Loại sản phẩm</h5>
                    <c:forEach var="type" items="${types}">
                        <a href="/guest?action=filter&idTypes=${type.getId_Type()}">
                            <li class="list-group-item">${type.getName()}</li>
                        </a>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div id="content"
             style="width: 79%; height: 100%; background: white; margin-top: 10px; box-shadow: 0 1px 4px 0 darkgrey;">
            <div class="container-fluid">
                <div class="row text-center mt-5 mb-5">
                    <h1 class="text-title">Tất cả sản phẩm</h1>
                </div>
                <a href="/shops?action=createProductToShop&idShop=${shop.idShop}" class="btn mb-3" style="color: white">
                    <i class="fas fa-plus-circle"></i>
                    Thêm 1 sản phẩm mới</a>
                <div class="container">
                    <div class="row">
                        <c:forEach var="t" items="${list}">
                            <div class="col-md-4 col-sm-6 mb-5">
                                <div class="card me-3" style="width: 100%;">
                                    <a href="/guest?action=details&idProduct=${t.idProduct}&idCart=${cart.idCart}">
                                        <img src="${t.image}" class="card-img-top" style="height: 200px">
                                    </a>
                                    <div class="card-body">
                                        <p class="card-text text-center">${t.nameProduct}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--    <c:out value="${idUser}"></c:out>--%>
<%--    <c:out value="${cart.idCart}"></c:out>--%>
<%--    <c:set var="idCart" value="${cart.idCart}"></c:set>--%>
<%--    <form>--%>
<%--        <button type="submit"></button>--%>
<%--        <input type="hidden" name="idCart" value="${cart.idCart}">--%>
<%--        <input type="hidden" name="action" value="showcart">--%>
<%--    </form>--%>


<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <c:forEach var="t" items="${list}">--%>
<%--                <div class="col-md-3 col-sm-6">--%>
<%--                    <div class="card" style="width: 18rem; height: 400px">--%>
<%--                        <a href="/guest?action=details&idProduct=${t.idProduct}&idCart=${cart.idCart}">--%>
<%--                            <img class="card-img-top" src="${t.image}" alt="Card image cap">--%>
<%--                        </a>--%>
<%--                        <div class="card-body">--%>
<%--                            <p class="card-text text-center">${t.nameProduct}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>
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
