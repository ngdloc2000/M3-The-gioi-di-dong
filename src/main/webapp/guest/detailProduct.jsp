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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        .navbar-brand {
            color: black;
            font-family: "Abel", sans-serif;
            font-weight: bold;
            align-self: center;
            font-size: 32px;
            padding: 0;
        }

        .nav-link {
            font-size: 18px;
            color: black;
            font-family: "Poppins", sans-serif;
        }

        .out {
            outline: none;
            border: none;
            border-radius: 6px;
            color: #fff;
            background-color: rgb(31, 31, 31);
            font-size: 13px;
            font-weight: 500;
            text-align: center;
            height: 40px;
            width: 350px;
            margin-left: 60px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%--<c:out value="${idUser}"></c:out>--%>
<%--<c:out value="${product.idProduct}"></c:out>--%>
<%--<c:out value="${idCart}"></c:out>--%>
<%--    <c:set var="idCart" value="${cart.idCart}"></c:set>--%>
<header style="background-color: #f8f9fa; position: sticky; top: 0; z-index: 111111;">
    <div class="container d-flex align-items-center">
        <a href="./guest" class="navbar-brand">
            MyBlog
        </a>

        <ul class="nav justify-content-center align-items-center">
            <li class="nav-item">
                <a class="nav-link" href="">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Favourite</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Category</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fab fa-facebook-f"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fab fa-twitter"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fab fa-instagram"></i>
                </a>
            </li>
            <li class="nav-link">

            </li>
        </ul>

        <%--        Tìm kiếm--%>
        <form method="get" action="/guest" style="margin-bottom: 0">
            <div class="search-box d-flex align-items-center" style="margin-bottom: 0">
                <input name="name" type="text" class="form-control form-control-dark" placeholder="Nhập tên blog ..."
                       style="width: 200px"/>
                <input name="action" value="searchBlogByName" hidden>
                <button class="nav-link" style="border: none; background: none">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>

        <button class="out" style="width: 70px; height: 20px">Log out</button>
    </div>
</header>


<div class="row">
    <div class="col-md-3 col-sm-6 offset-md-4 offset-sm-3">
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
                <div class="d-flex">
                    <label class="me-3">Rating : </label>
                    <p class="card-text text-center">${product.getAvgRate()} <i class="fas fa-star"></i></p>
                </div>
                <form method="post">
                    <label>Chọn số lượng</label>
                    <input type="text" name="number">
                    <input type="hidden" name="idProduct" value="${product.idProduct}">
                    <input type="hidden" name="idCart" value="${idCart}">
                    <%--                    <input type="hidden" name="action" value="addToCart">--%>
                    <button type="submit">Thêm vào giỏ hàng</button>
                </form>
                <a href="/guest?action=showcart&idCart=${idCart}">Mua ngay</a>
            </div>
            <div class="comment col offset-1">
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
<%--            <div class="addComment">--%>
<%--                <form method="get">--%>
<%--                    <p>UserID: ${idUser}</p><br>--%>
<%--                    <label for="comment">Comment</label>--%>
<%--                    <input id="comment" type="text" name="comment" placeholder="Comment Here"><br>--%>
<%--                    <label for="rate">Rate</label>--%>
<%--                    <input type="number" name="rate" id="rate" placeholder="Rate Product"><br>--%>
<%--                    <input type="hidden" name="action" value="addComment">--%>
<%--                    <input type="hidden" name="idProduct" value="${product.idProduct}">--%>
<%--                    <input type="hidden" name="idCart" value="${idCart}">--%>
<%--                    <input type="submit" name="" value="submit">--%>

<%--                </form>--%>
<%--            </div>--%>
            <div>
                <form>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Nhận xét</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="comment">
                        <div id="emailHelp" class="form-text">Đừng nói những lời quá đáng =((</div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Đánh giá sản phẩm</label>
                        <input type="number" class="form-control" id="exampleInputPassword1" name="rate">
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
