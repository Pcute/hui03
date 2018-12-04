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
<h2>Hello World!jklkdhfdkjg</h2>
<form action="hello.do" method="get">
    <input type="text" name="mes"/>
    <input type="submit"/>
</form>
</body>
</html>
