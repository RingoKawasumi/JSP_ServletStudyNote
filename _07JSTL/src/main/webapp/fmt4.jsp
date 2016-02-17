<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/16
  Time: 下午5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    ResourceBundle zh_TW = ResourceBundle.getBundle("hello", new Locale("zh", "TW"));
    ResourceBundle zh_CN = ResourceBundle.getBundle("hello", new Locale("zh", "CN"));
    ResourceBundle ja_JP = ResourceBundle.getBundle("hello", new Locale("ja", "JP"));
    ResourceBundle en_US = ResourceBundle.getBundle("hello", new Locale("en", "US"));
    pageContext.setAttribute("zh_TW", new LocalizationContext(zh_TW));
    pageContext.setAttribute("zh_CN", new LocalizationContext(zh_CN));
    pageContext.setAttribute("ja_JP", new LocalizationContext(ja_JP));
    pageContext.setAttribute("en_US", new LocalizationContext(en_US));
%>
<html>
<head>
    <title></title>
</head>
<body>
<fmt:message bundle="${zh_TW}" key="cc.openhome.hello"/><br>
<fmt:message bundle="${zh_CN}" key="cc.openhome.hello"/><br>
<fmt:message bundle="${ja_JP}" key="cc.openhome.hello"/><br>
<fmt:message bundle="${en_US}" key="cc.openhome.hello"/><br>
</body>
</html>
