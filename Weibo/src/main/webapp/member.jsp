<%@ page import="cc.openhome.model.Blah" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/3
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gossip 微博</title>
</head>
<body>
<div class="leftPanel">
    <img src="images/yingtao.jpg" alt="Gossip 微博"/>
    <br><br>
    <a href='logout.do?username="${sessionScope.login}"'>注销 ${sessionScope.login}
    </a>
</div>
<form method="post" action="message.do">
    分享新鲜事...<br>
    <%
        String blabla = request.getParameter("blabla");
        if (blabla != null) {
    %>
    信息要在140字以内<br>
    <%
        }
    %>
    <textarea cols="60" rows="4" name="blabla">${requestScope.blabla}</textarea><br>
    <button type="submit">送出</button>
</form>
<table style="text-align: left; widows;: 510px; height: 88px;" border="0" cellpadding="2" cellspacing="2">
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
        List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");
        for (Blah blah : blahs) {
    %>
    <tr>
        <td style="vertical-align: top;">
            <%=blah.getUsername()%><br>
            <%=blah.getTxt()%><br>
            <%=dateFormat.format(blah.getDate())%><br>
            <a href="delete.do?message=<%=blah.getDate().getTime()%>">删除</a>
            <hr>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr style="width: 100%; height: 1px;">
</body>
</html>
