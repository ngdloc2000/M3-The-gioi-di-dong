<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/15/2021
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <c:if test="${account}">
      ${account.username}
    </c:if>
    <title>$Title$</title>
  </head>
  <body>
<<<<<<< HEAD
  <c:redirect url="product/showProduct.jsp"/>
  <c:forEach items="" var=""
=======
  <c:redirect url="/accounts"/>
>>>>>>> 7d7744a69a61f3479ee7ea10cdadb875cacef130
  $END$
  </body>
</html>
