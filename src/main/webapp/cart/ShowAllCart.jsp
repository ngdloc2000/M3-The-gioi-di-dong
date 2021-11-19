<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/17/2021
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Show All Cart</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #navbar{
            height: 2rem;

        }
        #navbar>a{
            font-size: 0.9rem;
            border: #220606;
            border-left-color: #F5F5F5;
            border: 1px;

        }
        .shopeecolor{
            color: #EE4D2D;
        }
        .shopee-icon{
            /*height: 3rem;*/
        }
    </style>
</head>
<body>
<div id="main">
    <style></style>
    <div>
        <div class="container-wrapper">
            <nav id="navbar" class="navbar navbar-expand-sm navbar-dark" style="background-color: #EE4D2D;">
                <a class="navbar-brand" href="#" >Kênh người bán</a>
                <a class="navbar-brand" href="#">Tải ứng dụng</a>
                <a class="navbar-brand" href="#">Kết nối</a>


            </nav>
            <nav id="navbar2" class="navbar navbar-expand-sm " style="background-color: #F5F5F5; color: #EE4D2D; ">
                <a class="navbar-brand shopeecolor" href="#"><img src="https://www.nicepng.com/png/full/983-9832058_shopee-logo-shopee-logo-vector.png" alt="shopee-icon" class="shopee-icon"></a>
                <button class="navbar-toggler d-lg-none shopeecolor" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                        aria-expanded="false" aria-label="Toggle navigation"></button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link shopeecolor" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li>
                            <a class="nav-link"  aria-disabled="false" href="#">Home</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Type</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="#">Type 1</a>
                                <a class="dropdown-item" href="#">Type 2</a>
                            </div>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search">
                        <button  class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div>

        </div>
    </div>

    <table class="table">
        <thead>
        <tr>

            <th scope="col">idCart</th>
            <th scope="col">idAccount</th>
            <th scope="col">createDate</th>
            <th scope="col">status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="cart">
            <tr>
                <th scope="row">${cart.idCart}</th>
                <th >${cart.idAccount}</th>
                <th >${cart.getCreateDate}</th>
                <th >${cart.getStatus}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>






<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>