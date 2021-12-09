<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>reg页面</title>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
    <%--js脚本；自动执行--%>
<script type="text/javascript">
    // $(function (){
    //     alert("hello?");
    //    $.ajax({
    //   url:"json/getUser.do",//访问控制器
    //    type:"post",//提交方式
    //    dataType:"json",//返回值类型    错误应该是data不是date
    //  success:function (data){//结果处理
    //      $("#s1").html("你好"+data.username);
    //     }
    //     });
    $(function() {
        $("#reg").click(function() {
            // alert("---click----");
            var username = $("#name").val();
            var password = $("#pwd").val();
            var regInfo={"username":username,"pwd":password}
            $.ajax({
                url: "json/getJsonRegInfot.do",//访问控制器
                dataType:"json",//提交的数据格式
                data:JSON.stringify(regInfo),//提交的json数据格式
                type: "post",//提交方式
                contentType:"application/json",
                traditional:true,//不进行深度的序列化
                // success: function (data) {//结果处理
                // }
            })
        });
    })
</script>
<body>
<from>
  账号:<input type="text" name="username"/>
    <br>
  密码:<input type="password" name="password"/>
    <input type="button" value="提交" id="reg">
</from>
<div>
    <span id="s1"></span>
</div>

<%--    <h1>云端修改</h1>--%>
<%--    <h1>本地修改到云端</h1>--%>
<%--    <h1>再次测试</h1>--%>
<%--<form action="${pageContext.request.contextPath}/param2/reg" method="get">--%>
<%--    <label>用户名</label>   <input name="username">--%>
<%--     <label>密码</label>    <input name="pwd">--%>
<%--    <label>年龄</label>     <input name="age">--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</head>
</html>
