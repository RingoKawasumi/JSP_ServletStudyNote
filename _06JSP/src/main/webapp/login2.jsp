<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/1/26
  Time: 上午11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="cc.openhome.User"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<%
    if (user.isValid()) {
%>
<h1>
    <jsp:getProperty name="user" property="name"/>
    登陆成功
</h1>
<%
} else {
%>
<h1>登陆失败</h1>
<%
    }
%>
</body>
</html>
