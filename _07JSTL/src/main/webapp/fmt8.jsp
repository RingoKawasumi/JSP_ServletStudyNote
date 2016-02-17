<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/17
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<fmt:formatNumber value="12345.678"/><br>
<fmt:formatNumber value="12345.678" type="currency"/><br>
<fmt:formatNumber value="12345.678" type="currency" currencySymbol="新台币"/><br>
<fmt:formatNumber value="12345.678" type="percent"/><br>
<fmt:formatNumber value="12345.678" pattern="#,#00.0#"/><br>
</body>
</html>
