<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.User,model.Mutter,java.util.List,java.sql.*,javax.naming.InitialContext,javax.naming.Context"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	//List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	//ResultSet rset = (ResultSet) application.getAttribute("rset");
	// Oracle JDBC Driverのロード
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn;
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.37.133:1521:XE", "TUBU", "TUBU");
	Statement stmt = conn.createStatement();
	// タイムスタンプ現代順で100件まで表示
	ResultSet result = stmt
			.executeQuery("select * from (select * from TUBUYAKI ORDER BY ENTRY DESC) where rownum <= 100");
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
	<div align="right">
		<ul class="list-inline">
			<li><a href="/hello_world_now/">TOPへ</a></li>
			<li><a href="/hello_world_now/Main">更新</a></li>
		</ul>
	</div>
	<p>
		<%=loginUser.getName()%>さん、ログイン中
	</p>
	<form action="/hello_world_now/Main" method="post">
		<input type="text" name="tubu" required><input type="submit"
			value="つぶやく">
	</form>
	<ul class="list-group">
		<%
			//for (int i = mutterList.size() - 1; i >= 0; i--) {
			//mutterList.get(i).getUserName()
			//mutterList.get(i).getText()
			while (result.next()) {
		%>
		<li class="list-group-item">【<%=result.getString(1)%>】さんは「<%=result.getString(2)%>」とつぶやいた(<%=result.getTimestamp(3)%>)
		</li>
		<%
			}
		%>
	</ul>
</body>
</html>