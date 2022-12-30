<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 처리</title>
</head>
<body>
    <%
        Object loginInfo = session.getAttribute("logininfo");
        if (loginInfo == null) {
    %>
        <a href="login">로그인</a>
    <% } else {
        dto.MemberDTO dto = (dto.MemberDTO) loginInfo;
    %>
      <%= dto.getMname()%> 님 환영합니다.<br/>
    <a href="logout">로그아웃</a>
    <% } %>
</body>
</html>