<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息添加</title>
</head>
<body>
     <form action="${pageContext.request.contextPath}/insertStudent"  
		method="post" style="display:block;text-align:center">
		<center ><font size="6">请输入学生信息</font></center><br/>
	   姓名:<input name="username" type="text"><br/><br/>
	   性别:<input name="sex" type="text"><br/><br/>
	   电话 :<input name="phone" type="text"><br/><br/>
	   <input type="submit" value="添加">
	 </form>
</body>
</html>