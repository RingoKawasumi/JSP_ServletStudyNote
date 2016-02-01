<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/1/25
  Time: 下午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<h1>网页发生错误:</h1><%= exception %>
<h2>显示异常堆栈跟踪:</h2>
<%
    exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>
