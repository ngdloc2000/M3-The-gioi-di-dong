<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17-Nov-21
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <title>Thêm Shop Quản Lý!</title>
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
    <div class="container-fluid">
        <div class="container">
            <form id="form-create-shop" method="post">
                <p style="font-size: 20px; color: #222; text-transform: capitalize; margin-top: 45px; margin-left: 35px;">
                    Nhập thông tin shop</p>
                <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
                    <label class="form-label">Tên shop</label>
                    <input name="name" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary"
                        style="margin-left: 35px; height: 41px; width: 335px; background: #ff5722">Submit
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
