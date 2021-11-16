<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/15/2021
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <c:if test="${account}">
      ${account.username}
    </c:if>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
