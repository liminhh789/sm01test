<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/param2/reg" method="get">
    <label>用户名</label>   <input name="username">
     <label>密码</label>    <input name="pwd">
    <label>年龄</label>     <input name="age">
    <input type="submit" value="提交">
</form>
</body>
</html>