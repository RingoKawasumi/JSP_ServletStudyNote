<%@ page import="cc.openhome.model.BookmarService" %>
<%@ page import="cc.openhome.model.Bookmark" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/1/21
  Time: 下午8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看在线书签</title>
</head>
<body>
<table style='text-align: left; width: 100%;' border='0'>
    <tbody>
    <tr>
        <td style='background-color: rgb(51,255,255); '>网页</td>
        <td style='background-color: rgb(51,255,255); '>分类</td>
    </tr>

    <%
        BookmarService bookmarService = (BookmarService) application.getAttribute("bookmarkService");
        for (Bookmark bookmark : bookmarService.getBookmarks()) {
    %>
    <tr>
        <td><a href="http://<%= bookmark.getUrl()%>>"><%= bookmark.getTitle()%>
        </a></td>
        <td><%= bookmark.getCategory()%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
