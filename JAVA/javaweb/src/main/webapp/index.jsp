<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    int sum = 0;
      for (int i = 0; i < 10; i++) {
          sum = sum + i;
      }
  %>

    <h1>JSP 생성</h1>
    <div><%=sum%></div>
    <div><%=request.getRemoteAddr()%></div>
</body>
</html>
