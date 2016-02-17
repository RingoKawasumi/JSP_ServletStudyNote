<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<%@ page import="javax.servlet.jsp.jstl.fmt.LocalizationContext" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%--
  Created by IntelliJ IDEA.
  User: zhujie
  Date: 16/2/17
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    Locale locale = new Locale("ja", "JP");
    ResourceBundle res = ResourceBundle.getBundle("hello", locale);
    Config.set(pageContext, Config.FMT_LOCALIZATION_CONTEXT, new LocalizationContext(res), PageContext.PAGE_SCOPE);
%>
<html>
<head>
    <title></title>
</head>
<body>
<fmt:message key="cc.openhome.hello"/>
</body>
</html>
