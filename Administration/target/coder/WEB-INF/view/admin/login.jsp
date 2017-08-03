<%--
  Created by IntelliJ IDEA.
  User: Neal
  Date: 17.3.30
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>"/>
    <title>用户登陆</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jQuery-core/jquery-3.1.1.js"></script>
    <%--<script type="text/javascript" src="../js/checkInputNotNull.js"></script>--%>
</head>
<body>
<form id="loginForm">
    <table width="300" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#FF9900">
        <tr>
            <td height="24" colspan="2" align="center" bgcolor="#FFCC66">
                管理员登陆
            </td>
        </tr>
        <tr>
            <td width="77" height="24" align="center" bgcolor="#FFFFFF">
                管理账号
            </td>
            <td width="204" height="24" bgcolor="#FFFFFF">
                <input name="adminName" type="text" id="adminName" value="admin" class="input1">
            </td>
        </tr>
        <tr>
            <td height="24" align="center" bgcolor="#FFFFFF">
                管理密码
            </td>
            <td height="24" bgcolor="#FFFFFF">
                <input name="adminPwd" type="password" id="adminPwd" value="admin" class="input1">
            </td>
        </tr>
        <tr>
            <td height="24" align="center" bgcolor="#FFFFFF">
                管理级别
            </td>
            <td height="24" bgcolor="#FFFFFF">
                <input name="adminLevel" type="radio" value="1" checked>
                管理员
                <input name="adminLevel" type="radio" value="2">
                操作员
            </td>
        </tr>
        <tr style="border: none">
            <td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
                <input type="button" value="进入系统" onClick="checkLogin()">
                &nbsp;&nbsp;
                <%--<input type="hidden" name="targetURL" value="">--%>
            </td>
        </tr>
        <tr>
            <td colspan="2" height="24" id="msgBox" bgcolor="#FFCC66" align="center"><%--信息框--%></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    function checkLogin() {
        if ($("#adminName").val() == null || $("#adminName").val() == "") {
            alert("账号还没填呢！");
            return;
        }
        if ($("#adminPwd").val() == null || $("#adminPwd").val() == "") {
            alert("密码还没填呢！");
            return;
        }
        var adminToLogin = $("#loginForm").serialize();
        $.ajax({
            type: "post",
            url: "admin/checkLogin",
            //contentType: "application/json;charset=utf-8",
            data: adminToLogin,
            success: function (data) {
                console.log(data);
                $("#msgBox").text(data.msg);
                if (data.msgCode == 0) {
                    window.location = "";
                }
            },
            error: function (data) {
                console.log("json 数据请求失败！");
            }
        });
    }
</script>
</html>