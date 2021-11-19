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
    <title>Thong Tin San Pham</title>
    <link rel="stylesheet" href="../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>

    </style>
</head>
<body>

<div class="container">
<div class="" id="header" style="height: 85px">
    <div class="container-fluid d-flex justify-content-between">
        <div class="wrap1 d-flex">
            <div>
                <a href="/guest">
                    <img id="logo"
                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Shopee.svg/2560px-Shopee.svg.png">
                </a>
            </div>
            <div style="font-size: 24px; color: #222; margin-top: 28px">

            </div>
        </div>

        <div class="name-account wrap2 d-flex align-items-center" style="margin-top: 20px; margin-right: 140px">
            <i class="fas fa-user" style="margin-right: 10px"></i>
            <p style="margin-right: 10px; margin-right: 10px; position: relative; top: 8px">XXX</p>
            <a href="/accounts?action=logout" style=" color:#222;">Logout</a>
        </div>
    </div>
</div>
<div class="row align-items-md-stretch" >
    <div class="col-md-6">
        <div class="h-100 p-5 text-white rounded-3" style="background-color: #ef4c29">
            <img class="card-img-top" src="${product.image}" alt="Card image cap">
            <div class="card-body">
                <div class="d-flex">
                    <div style="width: 30%">
                        <label class="me-3">Tên sản phẩm: </label>
                    </div>
                    <p class="card-text ">${product.nameProduct}</p>
                </div>
                <div class="d-flex">
                    <div style="width: 30%">
                        <label class="me-3">Giá sản phẩm: </label>
                    </div>
                    <p class="card-text text-center">${product.price}</p>
                </div>
                <div class="d-flex">
                    <div style="width: 30%"><label class="me-3">Số lượng sản phẩm: </label></div>
                    <p class="card-text text-center">${product.quantity}</p>
                </div>
                <div class="d-flex">
                    <div style="width: 30%"> <label class="me-3">Loại sản phẩm: </label></div>
                    <p class="card-text text-center">${product.getType().getName()}</p>
                </div>
                <div class="d-flex">
                    <div style="width: 30%"><label class="me-3">Tên shop: </label></div>
                    <p class="card-text text-center">${product.getShop().getNameShop()}</p>
                </div>
                <div class="d-flex">
                    <div style="width: 30%"> <label class="me-3">Rating : </label></div>
                    <p class="card-text text-center">${product.getAvgRate()} <i class="fas fa-star"></i></p>
                </div>
                <form method="post">
                    <div style="width: 30%"> <label>Chọn số lượng: </label></div>
                    <div>
                        <input type="text" name="number">
                        <input type="hidden" name="idProduct" value="${product.idProduct}">
                        <input type="hidden" name="idCart" value="${idCart}">
                    </div>
                    <%--                    <input type="hidden" name="action" value="addToCart">--%>
                    <br>
                    <button class="btn btn-outline-light" type="submit">Thêm vào giỏ hàng</button>
                </form>
                <a class="btn btn-outline-light mt-3"  style="width: 162px" role="button" href="/guest?action=showcart&idCart=${idCart}">Mua ngay</a>
            </div>

        </div>
    </div>
    <div class="col-md-6">
        <div class="h-100 p-5 bg-light border rounded-3">
            <div>
                <form>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Nhận xét</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="comment">
                        <div id="emailHelp" class="form-text">Đừng nói những lời quá đáng =((</div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Đánh giá sản phẩm</label>
                        <input type="number" class="form-control" id="exampleInputPassword1" name="rate" placeholder="0-5 Star">
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Nhấn em đi</label>
                    </div>
                    <input type="hidden" name="action" value="addComment">
                    <input type="hidden" name="idProduct" value="${product.idProduct}">
                    <input type="hidden" name="idCart" value="${idCart}">
                    <button type="submit" class="btn btn-primary">Gửi</button>
                </form>
            </div>
            <div class="comment col ">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">User</th>
                    <th scope="col">Đánh Giá</th>
                    <th scope="col">Rate</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rate" items="${rateList}">
                    <tr>
                        <th scope="row">${rate.account.getName()}</th>
                        <td>${rate.comment}</td>
                        <td>${rate.rate} <i class="fas fa-star"></i></td>
                    </tr>
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
