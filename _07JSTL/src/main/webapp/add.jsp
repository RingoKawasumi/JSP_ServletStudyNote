<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/15
  Time: 下午3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>加法网页</title>
</head>
<body>
<c:catch var="error">
    ${param.a} + ${param.b} = ${param.a + param.b}
</c:catch>
<c:if test="${error != null}">
    <br><span style="color: red;">${error.message}</span>
    <br>${error}
</c:if>
</body>
</html>
