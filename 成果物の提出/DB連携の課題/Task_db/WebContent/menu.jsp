<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty userInfo}">
  <c:redirect url="/index.jsp"/>
</c:if>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <p>${fn:escapeXml(userInfo.userName)}さん、こんにちは</p>


   <p>
    <a href="select.jsp">検索</a>
  </p>
  <c:if test="${userInfo.roleId == 1}">
    <p>
      <a href="insert.jsp">登録</a>
    </p>
  </c:if>


  <form action="LogoutServlet" method="post">
    <button type="submit">ログアウト</button>
  </form>
</body>
</html>