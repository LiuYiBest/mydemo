<%--
  Created by IntelliJ IDEA.
  User: Neal
  Date: 17.3.31
  Time: 11:58
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
    <title>增加新部门</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jQuery-core/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="js/SomeAjaxMethod.js"></script>
</head>

<body>
<!-- 页面头部 -->
<jsp:include page="/admin/nav"/>
<!-- 页面头部 -->
<!-- 页面内容 -->
<table border="0" width="950" height="350" bgcolor="#ffffff"
       align="center">
    <tr>
        <td align="center" valign="top">
            <form id="deptForm">
                <table width="500" border="0" cellpadding="5" cellspacing="1"
                       bgcolor="#CCCCCC">
                    <tr>
                        <td height="24" colspan="2" align="center" bgcolor="#FFCC00">
                            请填写新部门信息
                        </td>
                    </tr>
                    <tr>
                        <td width="120" height="24" bgcolor="#FFFFFF">
                            部门编号
                        </td>
                        <td width="357" height="24" bgcolor="#FFFFFF">
                            <input name="deptId" type="number" id="deptId" onblur="checkDeptId()">
                            <span style="color: red;" id="deptIdCheckRs">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="24" bgcolor="#FFFFFF">
                            部门名称
                        </td>
                        <td height="24" bgcolor="#FFFFFF">
                            <input name="deptName" type="text" id="deptName" onblur="checkDeptName()">
                            <span style="color: red;" id="deptNameCheckRs">*</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="24" bgcolor="#FFFFFF">
                            部门地址
                        </td>
                        <td height="24" bgcolor="#FFFFFF">
                            <input name="loc" type="text" id="location_name">
                            *
                        </td>
                    </tr>
                    <tr>
                        <td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
                            <input type="button" name="Submit" value="提交" onClick="addDept()">
                            <input type="button" name="Submit2" value="取消" onclick="history.back();">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<!-- 页面底部 -->
<%@ include file="/footer.jsp"%>
<!-- 页面底部 -->
</body>
</html>