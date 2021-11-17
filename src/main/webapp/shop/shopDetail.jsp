<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17-Nov-21
  Time: 8:30 PM
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
    <title>Hello, world!</title>
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
    <div class="container-fluid d-flex justify-content-between">
        <div id="sidebar-menu" style="width: 20%; height: 100%;">asa</div>
        <div id="content" style="width: 79%; height: 100%;">
            <div class="container-fluid">
                <div class="row text-center mt-5 mb-5">
                    <h1 class="text-title">Tất cả sản phẩm</h1>
                </div>
<%--                <div class="mb-3 d-flex justify-content-end align-items-center">--%>
<%--                    <span style="width: 90px">Thể loại</span>--%>
<%--                    <div class="dropdown">--%>
<%--                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"--%>
<%--                                data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                            Chọn thể loại--%>
<%--                        </button>--%>
<%--                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">--%>
<%--                            <c:forEach items="${listType}" var="type">--%>
<%--                                <li>--%>
<%--                                    <a class="dropdown-item"--%>
<%--                                       href="/blogs?action=selectBlogByType&id=${type.id}">${type.name}--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="row">
                    <c:forEach var="product" items="${productList}">
                        <div class="col-md-4 col-sm-6 mb-5">
                            <div class="card" style="width: 100%;">
                                <img src="..." class="card-img-top" style="height: 200px">
                                <div class="card-body text-center">
                                    <h5 class="card-title text-center">${product.nameProduct}</h5>
                                    <div class="d-flex justify-content-around mt-2 mb-3">
                                <span>
                                    <i class="fas fa-calendar-alt text-primary" style="margin-right: 10px"></i>
                                        ${blog.date}
                                </span> <br>
                                        <span>
                                    <i class="fas fa-keyboard text-primary" style="margin-right: 10px"></i>
                                        ${blog.typeBlog.name}
                                </span> <br>
                                    </div>
                                    <a href="#" class="btn btn-primary">Xem bài viết</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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