<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<p>登録情報を入力してください。<br>
	※は必須です。</p>



	<form action="InsertServlet" method="post">
    <fieldset>
      <div>
        <label>※ID</label>
        <input type="text" name="loginid" value="${fn:escapeXml(InsUserInfo.loginId)}">

        <span class="error">${fn:escapeXml(Inserror1)}</span>
      </div>
      <div>
        <label>※名前</label>
        <input type="text" name="name" value="${fn:escapeXml(InsUserInfo.userName)}">

        <span class="error">${fn:escapeXml(Inserror2)}</span>
      </div>
       <div>
        <label>※TEL</label>
        <input type="text" name="telephone" value="${fn:escapeXml(InsUserInfo.telephone)}">
        <span class="error">${fn:escapeXml(Inserror3)}</span>
      </div>
       <div>
        <label>※権限</label>
        <select name="role">
			 <c:forEach var="role" items="${role}">
				<option value="${fn:escapeXml(role.roleId)}" <c:if test="${role.roleId eq 2}"> selected</c:if>> ${fn:escapeXml(role.roleName)}</option>
			</c:forEach>
		</select>

      </div>
       <div>
        <label>※PASS</label>
        <input type="password" name="pass" value="${fn:escapeXml(InsUserInfo.password)}">
        <span class="error">${fn:escapeXml(Inserror4)}</span>
      </div>

    </fieldset>
    <button type="submit">確認</button>
  </form>


	</form>
<div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>