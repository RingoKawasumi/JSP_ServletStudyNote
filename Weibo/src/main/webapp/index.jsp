<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <a href="register.jsp">还不是会员?</a>

    <p>

    <div style="color: rgb(255, 0, 0);">
        ${requestScope.error}
    </div>
    <form method="post" action="login.do">
        <table bgcolor="#cccccc">
            <tr>
                <td colspan="2">会员登录</td>
            </tr>
            <tr>
                <td>名称:</td>
                <td><input type="text" name="username" value="${param.username}"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
