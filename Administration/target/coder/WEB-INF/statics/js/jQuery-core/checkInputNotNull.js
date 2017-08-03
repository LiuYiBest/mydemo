/**
 * 检查 input 输入框是否为空
 */
/*var script = document.createElement('script');
script.src = "/jQuery-core/jquery-3.1.1.js";
document.head.appendChild(script);*/

/*var inputBoxs = document.querySelectorAll(".inputArea");
 var textArea = document.querySelector("textarea");
 function checkInputBox() {
 for (var i = 0; i < inputBoxs.length; i++) {
 if (inputBoxs[i].value == "" || inputBoxs[i].value == null) {
 return false;
 }
 }
 if (textArea.value == "" || textArea.value == null) {
 return false;
 }
 return true;
 }*/

function checkInputNotNull() {
    console.log("检查输入框啦");
    $("input[type=text]").each(function () {
        console.log("-->" + $(this).val() + "<--");
        console.log("判断1：" + $(this).val() == "");
        console.log("判断2：" + $(this).val() == null);
        if ($(this).val() == "" || $(this).val() == null) {//输入框为空，返回 false
            return false;
        }
        return true;
    });
}
