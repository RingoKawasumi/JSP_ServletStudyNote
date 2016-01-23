<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/1/23
  Time: 下午1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String name = "caterpillar";
    String password = "123456";

    boolean checkUser(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    if (checkUser(name, password)) {
%>
<h1><%= name %>登陆成功</h1>
<%
} else {
%>
<h1>登陆失败</h1>
<%
    }
%>
</body>
</html>
