<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/upload.do">
    上传头像:<input type="file" name="image"><br>
    <input type="submit" value="上传">
</form>
</div>
<div>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/upload2.do">
        上传头像1:<input type="file" name="image"><br>
        上传头像2:<input type="file" name="image"><br>
        上传头像3:<input type="file" name="image"><br>
        <input type="submit" value="批量上传">
    </form>
</div>
<div>
    <h2>点击图片下载</h2>
    <a href="${pageContext.request.contextPath}/user/download.do/blossom1.jpg">
    <image src="${pageContext.request.contextPath}/images/blossom1.jpg" width="300px"></image>
    </a>
    <a href="${pageContext.request.contextPath}/user/download.do/blossom2.jpg">
        <image src="${pageContext.request.contextPath}/images/blossom2.jpg" width="300px"></image>
    </a>
    <a href="${pageContext.request.contextPath}/user/download.do/Desert.jpg">
        <image src="${pageContext.request.contextPath}/images/Desert.jpg" width="300px"></image>
    </a>
    <a href="${pageContext.request.contextPath}/user/download.do/菊花.jpg">
        <image src="${pageContext.request.contextPath}/images/菊花.jpg" width="300px"></image>
    </a>
</div>
<%--hello,${requestScope.username}!!! 密码是:${requestScope.age}你今年${requestScope.age}岁。--%>
<%--hello,${sessionScope.username}!!!你今年${sessionScope.age}岁。--%>
hello,${requestScope.user.username}!!!<br>
年龄,${requestScope.user.age}

<%--密码,${requestScope.user.pwd}--%>
</body>
</html>
