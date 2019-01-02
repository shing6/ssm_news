<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<%String path=request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script> 
<script type="text/javascript">



</script>

<style type="text/css">
td{
width:15%;/* 80px; */
overflow: hidden;
text-overflow:ellipsis;
text-align: center;
}
div{display:inline-block;  
    margin:0 auto;}
</style>

<title>学生信息</title>
</head>
<body>
 
   <div>
	<form action="${pageContext.request.contextPath}/findStudentById "
		method="post"  >
		学生编号:<input type="text"  name="id" > <input type="submit"
			value="查询" />
	</form>
	</div>
	<div>
	<form action="${pageContext.request.contextPath}/toaddStudent "
		method="post"  >
		
			<input type="submit"  value="添加"  />
	</form>
	</div>
	<div>
	<input type="button" value="删除"  onclick="document.getElementById('form1').submit();"/>
	</div>
	<div>
	<form action="${pageContext.request.contextPath}/findStudentScorce"
		method="post"  >
		<input type="submit" value="查看成绩表" />
	</form>
	</div>
	<br/>
	<form id="form1" action="${pageContext.request.contextPath}/deleteStudentById"
		method="post" style="display:block;text-align:center">
	<table  width=100% border=1 align="center">
		<tr>
		    <td>选择</td>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>操作</td>
		</tr>
		 
      <c:forEach var="student" items="${student}">
                            
		<tr>
		    <td><input name="id" value="${student.id}" type="checkbox"></td>
			<td>${student.id}</td>
			<td>${student.username}</td>
			<td>${student.sex}</td>
			<td>${student.phone}</td>
			<td><a href="${pageContext.request.contextPath}/toupdateStudent?id=${student.id} ">修改</a></td>
			
		</tr>
		</c:forEach>
		
	</table>
	
	
	</form>
	
	
	
</body>
</html>
