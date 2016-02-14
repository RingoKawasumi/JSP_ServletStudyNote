<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/14
  Time: 下午5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gossip 微博</title>
</head>
<body>
<%
    List<String> errors = (List<String>) request.getAttribute("errors");
    if (errors != null) {
%>
<h1>新增会员失败</h1>
<ul style="color: rgb(255, 0, 0);">
    <%
        for (String error : errors) {
    %>
    <li><%=error%>
    </li>
    <%
        }
    %>
</ul>
<br>
<%
    }
%>
<h1>会员注册</h1>

<form method="post" action="register.do">
    <table bgcolor="#cccccc">
        <tr>
            <td>邮箱地址:</td>
            <td><input type="text" name="email" value="${param.email}" size="25" maxlength="100"></td>
        </tr>
        <tr>
            <td>名称(最大16字符):</td>
            <td><input type="text" name="username" value="${param.username}" size="25" maxlength="16"></td>
        </tr>
    </table>
</form>
</body>
</html>
