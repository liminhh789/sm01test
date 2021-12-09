<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<html>
<head>
    <title>reg页面</title>
    <script type="text/javascript"src="statics/js/jquery-1.8.3.min.js"></script>
    <%--js脚本；自动执行--%>
<script type="text/javascript">
    $(function (){
       $.ajax({
      url:"json/getUser.do",//访问控制器
       type:"post",//提交方式
       dateType:"json",//返回值类型
     success:function (data){//结果处理
         $("s1").val("你好"+data.username);
        }
        });
    })
</script>
</head>
<body>
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
</html>
