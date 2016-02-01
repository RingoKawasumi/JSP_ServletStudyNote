<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/1/25
  Time: 下午2:02
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加法网页 </title>
</head>
<body>
<%
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    out.println("a + b = " + (Integer.parseInt(a) + Integer.parseInt(b)));
%>
<jsp:useBean id=""

</body>
</html>
