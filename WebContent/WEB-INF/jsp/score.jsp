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

<title>成绩</title>
</head>
<body>
 
  
	
	<table  width=100% border=1 align="center">
		<tr>
		    
			<td>学号</td>
			<td>姓名</td>
			<td>课程号</td>
			<td>课程名</td>
			<td>成绩</td>
			
		</tr>
		 
      <c:forEach var="score" items="${score}">
                            
		<tr>
		   
			<td>${score.id}</td>
			<td>${score.username}</td>
			<td>${score.cid}</td>
			<td>${score.cname}</td>
			<td>${score.score}</td>
			
		</tr>
		</c:forEach>
		
	</table>
	
	
	
	
	
	
</body>
</html>
