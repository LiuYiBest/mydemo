<%--
  Created by IntelliJ IDEA.
  User: Neal
  Date: 17.3.31
  Time: 10:39
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
    <title>部门数据</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jQuery-core/jquery-3.1.1.js"></script>
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
            <c:choose>
            <c:when test="${!empty viewPage && !empty viewPage.rows}">
            <table width="90%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
                <tr>
                    <th width="17%" bgcolor="#FFCC00">
                        部门编号
                    </th>
                    <th width="25%" bgcolor="#FFCC00">
                        部门名称
                    </th>
                    <th width="37%" bgcolor="#FFCC00">
                        部门地址
                    </th>
                    <th width="21%" bgcolor="#FFCC00">
                        操作
                    </th>
                </tr>
                <!-- 循环输出部门记录 -->
                <c:forEach items="${viewPage.rows}" var="dept">
                    <tr>
                        <td bgcolor="#FFFFFF">
                                ${dept.deptId}
                        </td>
                        <td bgcolor="#FFFFFF">
                                ${dept.deptName}
                        </td>
                        <td bgcolor="#FFFFFF">
                                ${dept.loc}
                        </td>
                        <td bgcolor="#FFFFFF">
                            <button><a href="dept/update/${dept.deptId}">修改</a></button>
                            <button onclick="deleteDept(${dept.deptId})">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                <!-- 循环输出部门记录 -->
            </table>
            <br/>
            <div>
                <span><a href="dept/view">首页</a></span>&nbsp;&nbsp;
                <c:if test="${viewPage.currPage > 1}">
                    <span><a href="dept/view/${viewPage.currPage-1}">上一页</a></span>&nbsp;&nbsp;
                </c:if>
                <c:forEach begin="1" end="${viewPage.maxPage}" var="pageNum">
                    <span><a href="dept/view/${pageNum}">${pageNum}</a></span>&nbsp;&nbsp;
                </c:forEach>
                <c:if test="${viewPage.currPage < viewPage.maxPage}">
                    <span><a href="dept/view/${viewPage.currPage+1}">下一页</a></span>&nbsp;&nbsp;
                </c:if>
                <span><a href="dept/view/${viewPage.maxPage}">尾页</a></span>
            </div>
            <br/>
            <p><a href="dept/add">增加新部门</a></p>
        </td>
    </tr>
</table>
</c:when>
<c:otherwise>
    <table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
        <tr>
            <td align="center">
                这里啥也没有哦！！！
            </td>
        </tr>
    </table>
</c:otherwise>
</c:choose>
<!-- 页面底部 -->
<%@ include file="/footer.jsp" %>
<!-- 页面底部 -->
</body>
<script type="text/javascript">
    function deleteDept(deptId) {
        //弹出确认框
        var flag = window.confirm("你确定要删除" + deptId + "号部门吗?");
        //如果单击确定，则执行删除方法
        //先检查 dept 是否有 emp
        if (flag) {
            //先查 dept 下有木有 emp，只有取消了外键关系，才能删除 dept
            $.ajax({
                type: "post",
                url: "emp/lookFk2dept/" + deptId,
                //contentType: "application/json;charset=utf-8",
                //data: "deptId=" + deptId,
                success: function (data) {
                    if (data.msgCode == 200) {//无员工
                        doDelete(deptId);
                    } else {//有员工
                        var flag2 = confirm("警告：该部门下有员工哦，删除该部门将使这些员工失去组织，是否继续？")
                        if (flag2) {
                            doDelete(deptId);
                        }
                    }
                },
                error: function (data) {
                    console.log("json 数据请求失败！");
                }
            });


        }
    }

    function doDelete(deptId) {
        $.ajax({
            type: "post",
            url: "dept/delete/" + deptId,
            //contentType: "application/json;charset=utf-8",
            success: function (data) {
                alert(data.msg);
                window.location.reload();
            },
            error: function (data) {
                console.log("json 数据请求失败！");
            }
        });
    }
</script>
</html>