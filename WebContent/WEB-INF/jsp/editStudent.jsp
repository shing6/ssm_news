<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
</head>
<body>
 <c:forEach var="student" items="${student}">
<form action="${pageContext.request.contextPath}/updateStudent"
		method="post" style="display:block;text-align:center">
		<center ><font size="6">修改信息</font></center><br/>
		<input name="id" type="hidden" value=" ${student.id}">
	   姓名:<input name="username" type="text" value=" ${student.username}"> <br/><br/>
	   性别:<input name="sex" type="text" value=" ${student.sex}"><br/><br/>
	   电话 :<input name="phone" type="text" value=" ${student.phone}"><br/><br/>
	   <input type="submit" value="修改">
	   
	 </form>
	</c:forEach>
</body>
</html>