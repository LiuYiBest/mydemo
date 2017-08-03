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
    <title>更新部门数据</title>
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
<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
    <tr>
        <td align="center" valign="top">
            <form name="form1" id="deptForm">
                <table width="500" border="0" cellpadding="5" cellspacing="1"
                       bgcolor="#CCCCCC">
                    <tr>
                        <td height="24" colspan="2" align="center" bgcolor="#FFCC00">
                            修改部门信息
                        </td>
                    </tr>
                    <tr>
                        <td width="120" height="24" bgcolor="#FFFFFF">
                            部门编号
                        </td>
                        <td width="357" height="24" bgcolor="#FFFFFF">
                            <input name="deptId" type="text" id="deptId" readonly="readonly" value="${dept.deptId}">
                            <span style="color: red;" id="deptIdCheckRs">不可修改</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="24" bgcolor="#FFFFFF">
                            部门名称
                        </td>
                        <td height="24" bgcolor="#FFFFFF">
                            <input name="deptName" type="text" id="deptName" value="${dept.deptName}"
                                   onblur="checkDeptName4update()">
                            <span style="color: red;" id="deptNameCheckRs">未修改</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="24" bgcolor="#FFFFFF">
                            部门地址
                        </td>
                        <td height="24" bgcolor="#FFFFFF">
                            <input name="loc" type="text" id="location_name" value="${dept.loc}"
                                   onblur="checkDeptLoc()">
                            <span style="color: red;" id="deptLocCheckRs">未修改</span>
                        </td>
                    </tr>
                    <tr>
                        <td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
                            <input type="button" name="Submit" value="更新" onclick="updateDept()"/>
                            <input type="button" name="Submit2" value="取消" onclick="giveup()"/>
                        </td>
                    </tr>
                </table>
            </form>

        </td>
    </tr>
</table>
<!-- 页面底部 -->
<%@ include file="/footer.jsp" %>
<!-- 页面底部 -->
</body>
<script type="text/javascript">
    //改前的值
    var deptNameBeforeEdit = "${dept.deptName}";
    var deptLocBeforeEdit = "${dept.loc}";

    function checkDeptName4update() {
        var deptNameAfterEdit = $("#deptName").val();
        /*console.log("改后-->" + deptNameAfterEdit);
         console.log("改前-->" + deptNameBeforeEdit);*/
        if (deptNameAfterEdit == deptNameBeforeEdit) {//未修改
            $("#deptNameCheckRs").text("未修改");
            return;
        }
        //部门名称已修改，调用查重方法
        checkDeptName();
    }

    function checkDeptLoc() {
        var deptLocAfterEdit = $("#location_name").val();
        /*console.log(deptLocBeforeEdit);
         console.log(deptLocAfterEdit);
         console.log("==>" + (deptLocAfterEdit == deptLocBeforeEdit));*/
        if (deptLocAfterEdit == deptLocBeforeEdit) {
            $("#deptLocCheckRs").text("未修改");
        } else {
            $("#deptLocCheckRs").text("✓");
        }
    }

    function updateDept() {
        if ($("#deptName").val() == null || $("#deptName").val() == "") {
            alert("部门名称还没填呢！");
            return;
        }
        if ($("#location_name").val() == null || $("#location_name").val() == "") {
            alert("部门地址还没填呢！");
            return;
        }
        var deptNameAfterEdit = $("#deptName").val();
        var deptLocAfterEdit = $("#location_name").val();
        /*console.log("部门名改前：" + deptNameBeforeEdit);
         console.log("部门名改后：" + deptNameAfterEdit);
         console.log("部门地址改前：" + deptLocBeforeEdit);
         console.log("部门地址改后：" + deptLocAfterEdit);*/
        //也就是没改
        if (deptNameAfterEdit == deptNameBeforeEdit && deptLocAfterEdit == deptLocBeforeEdit) {
            var flag = confirm("你啥也没改！继续修改请点击“确定”；返回列表页请点击“取消”。");
            if (!flag) {
                giveup();
            }
            return;
        }
        //有改动，调用修改方法
        var deptToUpdate = $("#deptForm").serialize();
        //console.log(deptToUpdate);
        $.ajax({
            type: "post",
            url: "dept/doUpdate",
            //contentType: "application/json;charset=utf-8",
            data: deptToUpdate,
            success: function (data) {
                //console.log(data);
                if (data.msgCode == 100) {//修改成功
                    var flag = confirm(data.msg + "继续修改？请点击“确定”；返回列表请点击“取消”。");
                    if (flag) {//继续修改
                        window.location.reload();
                    } else {//返回列表
                        //history.back();
                        giveup();
                    }
                } else {//修改失败，弹出信息
                    alert(data.msg);
                }
            },
            error: function (data) {
                console.log("json 数据请求失败！");
            }
        });
    }

    /**
     * 取消修改，返回列表页
     */
    function giveup() {
        /**
         * 获取上一个页面的url
         * 当修改后，并点击确定继续修改的时候，页面刷新，
         * 就只能获取update页面了，也就是上一个修改的页面
         */
        var src = document.referrer;
        //var src = top.document.referrer;
        //console.log(src);
        if (src.indexOf("dept/update/") > -1) {//找不到，返回 -1
            src = "dept/view";
        }
        //console.log("===>" + src);
        window.location = src;
    }
</script>
</html>