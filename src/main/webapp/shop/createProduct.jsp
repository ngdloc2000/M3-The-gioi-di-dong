<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17-Nov-21
  Time: 11:23 PM
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
    <title>Thêm Sản Phẩm</title>
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
    <div class="container-fluid" style="background: #f6f6f6; padding-top: 20px; padding-bottom: 10px">
        <div class="container"
             style="padding: 35px 40px 48px; background: #fff; border-radius: 2px; box-shadow: 0 2px 4px 0 darkgray;)">
            <div style="padding-bottom: 28px; border-bottom: 1px solid #ededed;">
                <h2 style="margin-bottom: 6px; font-size: 22px; color: #333333">Thêm 1 sản phẩm mới</h2>
                <p style="color: #999; font-size: 12px">Vui lòng chọn loại sản phẩm phù hợp cho sản phẩm của bạn</p>
            </div>
            <form method="post" class="row g-3">
                <div class="col-md-4">
                    <label for="validationDefault01" class="form-label">Tên sản phẩm</label>
                    <input name="name" type="text" class="form-control" id="validationDefault01" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">Giá</label>
                    <input name="price" type="text" class="form-control" id="validationDefault02" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefaultUsername" class="form-label">Số lượng</label>
                    <div class="input-group">
                        <input name="quantity" type="text" class="form-control" id="validationDefaultUsername"
                               aria-describedby="inputGroupPrepend2" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="validationDefault03" class="form-label">Link Ảnh</label>
                    <input name="image" type="text" class="form-control" id="validationDefault03" required>
                </div>
                <div class="col-md-3">
                    <label for="validationDefault04" class="form-label">Thể loại</label>
                    <select name="idType" class="form-select" id="validationDefault04" required>
                        <option selected disabled value="">Chọn thể loại</option>
                        <c:forEach var="type" items="${typelist}">
                            <option value="${type.id_Type}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Tạo sản phẩm</button>
                </div>
            </form>
            <a href="/shops?action=shopDetail&idShop=${shop.idShop}" class="btn">Quay lại</a>
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
