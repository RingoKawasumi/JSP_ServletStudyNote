<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/17
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<html>
<head>
    <title></title>
</head>
<body>
<fmt:formatDate value="${now}"/><br>
<fmt:formatDate value="${now}" dateStyle="full"/><br>
<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
<fmt:formatDate value="${now}" pattern="dd.MM.yy"/><br>
<fmt:timeZone value="GMT+1:00">
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
</fmt:timeZone>
</body>
</html>
