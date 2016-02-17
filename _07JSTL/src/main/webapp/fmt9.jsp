<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/17
  Time: 下午2:44
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
<fmt:setLocale value="zh_TW"/>
<fmt:formatDate value="${now}" type="both"/><br>
<fmt:formatNumber value="12345.678" type="currency"/><br>
<fmt:setLocale value="en_US"/>
<fmt:formatDate value="${now}" type="both"/><br>
<fmt:formatNumber value="12345.678" type="currency"/><br>
<fmt:setLocale value="ja_JP"/>
<fmt:formatDate value="${now}" type="both"/><br>
<fmt:formatNumber value="12345.678" type="currency"/><br>
</body>
</html>
