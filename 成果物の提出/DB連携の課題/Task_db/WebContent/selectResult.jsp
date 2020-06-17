<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table>
 	<tr>
 		<th>ID</th>
 		<th>名前</th>
 		<th>TEL</th>
 		<th>権限</th>
 	</tr>
 <c:forEach var="list" items="${list}">
 	<tr>
 		<th>${fn:escapeXml(list.loginId)}</th>
 		<th>${fn:escapeXml(list.userName)}</th>
 		<th>${fn:escapeXml(list.telephone)}</th>
		<th>${fn:escapeXml(list.roleName)}</th>
 	</tr>
 </c:forEach>

 </table>



<form action="menu.jsp">
    <button type="submit">メニューに戻る</button>
</form>


</body>
</html>