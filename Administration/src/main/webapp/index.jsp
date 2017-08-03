<%--
  Created by IntelliJ IDEA.
  User: Neal
  Date: 17.3.30
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>"/>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jQuery-core/jquery-3.1.1.js"></script>
</head>

<body>
<!-- 页面头部 -->
<jsp:include page="admin/nav"/>
<!-- 页面头部 -->


<!-- 页面内容 -->
<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
    <tr>
        <td align="center">
            <c:choose>
                <c:when test="${!empty admin}">
                    尊敬的 ${admin.adminName}，您已经登陆到羊庄养猪场人力资源管理系统，欢迎使用！
                </c:when>
                <c:otherwise>
                    欢迎来到羊庄养猪场人力资源管理系统，请<a href="admin/login">登陆</a>！
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
<!-- 页面底部 -->
<%@ include file="footer.jsp"%>
<!-- 页面底部 -->
</body>
<%--<script type="text/javascript">
    function logout() {
        $.post("/admin/logout", {"test": "test"}, function (data) {
            alert("退出成功！");
            window.location.reload();
        });
    }
</script>--%>
</html>