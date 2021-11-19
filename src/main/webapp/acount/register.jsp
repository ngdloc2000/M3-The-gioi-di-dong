<%--
  Created by IntelliJ IDEA.
  User: namkh
  Date: 11/13/2021
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register Shopee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div id="header" style="height: 85px">
    <div class="container-fluid" style="height: 100%">
        <div class="container d-flex justify-content-between" style="height: 100%">
            <div class="d-flex">
                <div>
                    <a href="/accounts">
                        <img id="logo"
                             src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Shopee.svg/2560px-Shopee.svg.png">
                    </a>
                </div>
                <div style="font-size: 24px; color: #222; margin-top: 28px">
                    Đăng ký
                </div>
            </div>
            <div style="color: #ee4d2d; font-size: 14px; height: 100%; margin-top: 30px">
                Cần trợ giúp?
            </div>
        </div>
    </div>
</div>
<div id="main" style="height: 600px">
    <div class="container-fluid" style="background: #ff5722; height: 100%;">
        <div id="wrap" class="container d-flex align-items-center justify-content-center">
            <div class="text-center" style="margin-right: 100px">
                <img src="https://1ty.vn/datafiles/3/2019-05-16/64184445-shopee-logo.png"
                     style="height: 300px; width: 300px" alt="">
                <p style="color: white; font-size: 20px">Nền tảng thương mại điện tử</p>
                <p style="color: white; font-size: 20px">yêu thích ở Đông Nam Á & Đài Loan</p>
            </div>

            <form id="form-login" method="post" style="height: 500px">
                <p style="font-size: 20px; color: #222; text-transform: capitalize; margin-top: 45px; margin-left: 35px;">
                    Đăng ký</p>
                <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
                    <label for="exampleInputEmail1" class="form-label">Username</label>
                    <input name="username" type="text" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
                    <label class="form-label">Name</label>
                    <input name="name" type="text" class="form-control">
                </div>
                <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
                    <label class="form-label">Role</label>
                    <select class="form-select" aria-label="Default select example" name="role">
                        <c:forEach items="${list}" var="t">
                            <option value="${t.idRole}">${t.nameRole}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
<%--                    <a class="mt-5" href="/acount/register.jsp">--%>
                        <button type="submit" class="btn btn-primary"
                                style="margin-left: 35px; height: 41px; width: 335px; background: #ff5722">Dăng kí
                        </button>
<%--                    </a>--%>
                </div>
            </form>
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


<%--<html>--%>
<%--  <head>--%>
<%--    <title>Register</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
<%--  </head>--%>
<%--  <body>--%>
<%--    <div class = "container">--%>
<%--      <h1>Login</h1>--%>
<%--      <h2>--%>
<%--        <a href="/login?action=register">Add Account</a>--%>
<%--      </h2>--%>
<%--      <form method="post" >--%>
<%--        <div class="mb-3">--%>
<%--          <label class="form-label">Username</label>--%>
<%--          <input type="text" class="form-control"  aria-describedby="emailHelp" name="username"></div>--%>
<%--        <div class="mb-3">--%>
<%--          <label  class="form-label">Password</label>--%>
<%--          <input type="password" class="form-control" name="password">--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--          <label  class="form-label">Name</label>--%>
<%--          <input type="text" class="form-control" name="name">--%>
<%--        </div>--%>
<%--        <select class="form-select" aria-label="Default select example" name = "role">--%>
<%--          <c:forEach items="${list}" var="t">--%>
<%--            <option value="${t.idRole}">${t.nameRole}</option>--%>
<%--          </c:forEach>--%>
<%--        </select>--%>
<%--        <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--      </form>--%>
<%--    </div>--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>--%>
<%--</body>--%>
<%--</html>--%>
