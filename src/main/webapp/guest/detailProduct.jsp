
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
    <title>Title</title>
    <link rel="stylesheet" href="">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <c:out value="${idUser}"></c:out>
    <c:out value="${product.idProduct}"></c:out>
    <c:out value="${idCart}"></c:out>
    <c:set var="idCart" value="${cart.idCart}"></c:set>

    <div class="col-md-3 col-sm-6">
        <div class="card" style="width: 18rem; height: 400px">
            <img class="card-img-top" src="${product.image}" alt="Card image cap">
            <div class="card-body">
                <div class="d-flex">
                    <label class="me-3">Tên sản phẩm: </label>
                    <p class="card-text text-center">${product.nameProduct}</p>
                </div>
                <div class="d-flex">
                    <label class="me-3">Giá sản phẩm: </label>
                    <p class="card-text text-center">${product.price}</p>
                </div>
                <div class="d-flex">
                    <label class="me-3">Số lượng sản phẩm: </label>
                    <p class="card-text text-center">${product.quantity}</p>
                </div>
                <div class="d-flex">
                    <label class="me-3">Loại sản phẩm: </label>
                    <p class="card-text text-center">${product.getType().getName()}</p>
                </div>
                <div class="d-flex">
                    <label class="me-3">Tên shop: </label>
                    <p class="card-text text-center">${product.getShop().getNameShop()}</p>
                </div>
                <form method="post">
                    <label>Chọn số lượng</label>
                    <input type="text" name = "number">
                    <input type="hidden" name="idProduct" value="${product.idProduct}">
                    <input type="hidden" name="idCart" value="${idCart}">
<%--                    <input type="hidden" name="action" value="addToCart">--%>
                    <button type="submit">Thêm vào giỏ hàng</button>
                </form>
                <a href="/guest?action=showcart&idCart=${idCart}">Mua ngay</a>
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
