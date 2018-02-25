<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
application.setAttribute("loginUser", loginUser);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>どこつぶ</title>
</head>
<body>
<div class="post-title-container"><h1>どこつぶログイン</h1></div>
<div class="jumbotron">
<% 
if(loginUser != null){ 
%>
<p>ログインに成功しました。</p>
<p><%= loginUser.getName() %>=サンようこそ</p>
<a href="/hello_world_now/Main">つぶやき登校・閲覧へ</a>
<%
} else { 
%>
<p>ログインに失敗しました</p>
<a href="/hello_world_now/">TOPへ</a>
<% 
} 
%>
</div>
</body>
</html>