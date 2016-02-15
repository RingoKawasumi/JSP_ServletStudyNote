<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/15
  Time: 下午2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="cc.openhome.User"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<c:choose>
    <c:when test="${user.valid}">
        <h1>
            <jsp:getProperty name="user" property="name"/>
            登录成功
        </h1>
    </c:when>
    <c:otherwise>
        <h1>登录失败</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
