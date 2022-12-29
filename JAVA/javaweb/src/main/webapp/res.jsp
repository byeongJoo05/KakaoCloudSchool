<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String name = request.getParameter("name");
    // POST 방식의 파라미터 인코딩 설정
    request.setCharacterEncoding("UTF-8");
    String nickname = request.getParameter("nickname");
  %>
  이름:<%=name%><br/>
  별명:<%=nickname%>
</body>
</html>
