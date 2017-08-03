<%--
  Created by IntelliJ IDEA.
  User: Neal
  Date: 17.3.31
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--设置基础路径--%>
<base href="<%=basePath%>"/>
<%--导航栏--%>
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="80" bgcolor="#FFFFFF">
            <img src="img/bannal.jpg" width="950" height="80">
        </td>
    </tr>
    <tr>
        <td height="24" align="right" bgcolor="#FFFFFF">
            <a href="">首页</a>
            <a href="dept/view">部门查询</a>
            <a href="job/view">职务查询</a>
            <a href="emp/view">员工查询</a>
            &nbsp;&nbsp;&nbsp;
        </td>
    </tr>
    <tr>
        <td height="24" align="right" bgcolor="#9FCCEF">
            <c:choose>
                <c:when test="${!empty admin}">
                    当前用户：${admin.adminName}，身份：
                    <c:choose>
                        <c:when test="${admin.adminLevel == 1}">
                            管理员
                        </c:when>
                        <c:when test="${admin.adminLevel == 2}">
                            操作员
                        </c:when>
                    </c:choose>
                    <a href="admin/logout">退出</a>
                </c:when>
                <c:otherwise>
                    <a href="admin/login">登陆</a>
                </c:otherwise>
            </c:choose>
            &nbsp;&nbsp;&nbsp;
        </td>
    </tr>
</table>