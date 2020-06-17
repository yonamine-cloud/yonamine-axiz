<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <p class="error">${fn:escapeXml(rePasserror)}</p>

  <form action="InsertConfirmServlet" method="post">
    <fieldset class="label-130">
      <div>
        <label>ID</label>
        <input type="text" name="loginId" value="${fn:escapeXml(InsUserInfo.loginId)}" readonly>


      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName" value="${fn:escapeXml(InsUserInfo.userName)}" readonly>


      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel" value="${fn:escapeXml(InsUserInfo.telephone)}" readonly>


      </div>
      <div>
        <label>権限</label>
        <input type="text" name="roleName" value="${fn:escapeXml(InsUserInfo.roleName)}" readonly>

      </div>
      <div>
        <label>PASS（再入力）</label>
        <input type="password" name="rePass">

      </div>
    </fieldset>
    <div>
      <button type="submit">登録</button>
      <button type="submit"
        onclick="location.href='insert.jsp'; return false;">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.html">メニューに戻る</a>
  </div>
</body>
</html>
