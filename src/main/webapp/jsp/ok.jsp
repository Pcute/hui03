<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <base href="<%=basePath%>"/>
</head>
<body>
<h2>Hello World!</h2>
<br/>EL<br/>
${userSex}性别，

${sessionScope.userName} ,request恭喜你，登录成功！

<br/>EL<br/>

<a href="clist.do">转到首页</a><br/>
<a href="logout.do">注销</a>
</body>
</html>
