<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/16
  Time: 下午4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<fmt:setBundle basename="messages3"/>
<html>
<head>
    <title><fmt:message key="cc.openhome.title"/></title>
</head>
<body>
<fmt:message key="cc.openhome.forUser">
    <fmt:param value="${param.username}"/>
    <fmt:param value="${now}"/>
    <fmt:param value="${now}"/>
</fmt:message>
</body>
</html>
