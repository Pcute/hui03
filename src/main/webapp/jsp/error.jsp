<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="content-type" content = "text/html;charset=utf-8">
    <base href="<%=basePath%>"/>
</head>
<body>
<h2>Hello World!jklkdhfdkjg</h2>
error,${userName}密码或者用户名有误！
</body>
</html>
