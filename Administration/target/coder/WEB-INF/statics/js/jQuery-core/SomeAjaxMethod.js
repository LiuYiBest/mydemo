/**
 * Created by Neal on 17.3.31.
 */
function addDept() {
    if ($("#deptId").val() == null || $("#deptId").val() == "") {
        alert("部门编号还没填呢！");
        return;
    }
    if ($("#deptName").val() == null || $("#deptName").val() == "") {
        alert("部门名称还没填呢！");
        return;
    }
    if ($("#location_name").val() == null || $("#location_name").val() == "") {
        alert("部门地址还没填呢！");
        return;
    }
    var deptToAdd = $("#deptForm").serialize();
    //console.log(deptToAdd);
    $.ajax({
        type: "post",
        url: "dept/doAdd",
        //contentType: "application/json;charset=utf-8",
        data: deptToAdd,
        success: function (data) {
            //console.log(data);
            if (data.msgCode == 10) {
                var flag = confirm(data.msg + "继续添加？请点击“确定”。");
                if (flag) {//继续添加
                    window.location.reload();
                } else {
                    location.href = 'dept/view';
                }
            } else {
                alert(data.msg);
            }
        },
        error: function (data) {
            console.log("json 数据请求失败！");
        }
    });
}

function checkDeptName() {
    var deptToAdd = $("#deptForm").serialize();
    //console.log(deptToAdd);
    if ($("#deptName").val() != null && $("#deptName").val() != "") {
        $.ajax({
            type: "post",
            url: "dept/checkDeptName",
            //contentType: "application/json;charset=utf-8",
            data: deptToAdd,
            success: function (data) {
                $("#deptNameCheckRs").text(data.msg);
            },
            error: function (data) {
                console.log("json 数据请求失败！");
            }
        });
    }
}

function checkDeptId() {
    var deptToAdd = $("#deptForm").serialize();
    //console.log(deptToAdd);
    if ($("#deptId").val() != null && $("#deptId").val() != "") {
        $.ajax({
            type: "post",
            url: "dept/checkDeptId",
            //contentType: "application/json;charset=utf-8",
            data: deptToAdd,
            success: function (data) {
                //console.log(data);
                $("#deptIdCheckRs").text(data.msg);
            },
            error: function (data) {
                console.log("json 数据请求失败！");
            }
        });
    }
}


