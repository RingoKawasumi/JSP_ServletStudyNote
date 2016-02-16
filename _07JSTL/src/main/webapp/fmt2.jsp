<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/16
  Time: 下午3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages1"/>
<html>
<head>
    <title><fmt:message key="cc.openhome.title"/></title>
</head>
<body>
<h1><fmt:message key="cc.openhome.forGuest"/></h1>
<fmt:bundle basename="messages2">
    <h1><fmt:message key="cc.openhome.forGuest"/></h1>
</fmt:bundle>
</body>
</html>
