<%@ page import="cc.openhome.model.Blah" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/14
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");
    if (blahs != null) {
%>
<div class="leftPanel">
    <img src="images/yingtao.jpg" alt="Gossip 微博"/>
    <br><br>${requestScope.username} 的微博
</div>
<table style="text-align: left; width: 510px; height: 88px;" border="0" cellpadding="2" cellspacing="2">
    <thead>
    <tr>
        <th>
            <hr>
        </th>
    </tr>
    </thead>
    <tbody>
    <%
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
        for (Blah blah : blahs) {
    %>
    <tr>
        <td style="vertical-align: top;">
            <%=blah.getUsername()%><br>
            <%=blah.getTxt()%><br>
            <%=dateFormat.format(blah.getDate())%><br>
            <hr>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr style="width: 100%; height: 1px;">
<%
} else {
%>
<h1 style="color: rgb(255, 0, 0);">${requestScope.username}用户不存在</h1>
<%
    }
%>
</body>
</html>
