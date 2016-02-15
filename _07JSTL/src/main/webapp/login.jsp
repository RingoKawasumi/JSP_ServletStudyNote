<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/15
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<c:if test="${param.name == 'momor' && param.password == '1234'}">
    <h1>${param.name} 登录成功</h1>
</c:if>
</body>
</html>
