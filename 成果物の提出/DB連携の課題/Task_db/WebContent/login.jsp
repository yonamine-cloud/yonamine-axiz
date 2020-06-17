<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <p class="error">${fn:escapeXml(error0)}</p>

  <form action="LoginServlet" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginid">
        <span class="error">${fn:escapeXml(error1)}</span>
      </div>
      <div>
        <label>PASS</label>
        <input type="password" name="pass">
        <span class="error">${fn:escapeXml(error2)}</span>
      </div>
    </fieldset>
    <button type="submit">ログイン</button>
  </form>
  <div>
    <a href="index.jsp">TOP画面に戻る</a>
  </div>
</body>
</html>
