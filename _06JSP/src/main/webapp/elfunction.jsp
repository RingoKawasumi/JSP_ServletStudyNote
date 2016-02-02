<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/2
  Time: 下午4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="util" uri="http://openhome.cc/util" %>
<html>
<head>
    <title>自定义EL函数</title>
</head>
<body>
${util:length(requestScope.someList)}
</body>
</html>
