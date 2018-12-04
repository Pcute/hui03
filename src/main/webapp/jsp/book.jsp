<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
</head>
<body>
<h2>${sessionScope.userName},欢迎你！</h2>
<h3>图书查询网页正在建设中</h3>
<a href="logout.do">注销</a>
</body>
</html>
