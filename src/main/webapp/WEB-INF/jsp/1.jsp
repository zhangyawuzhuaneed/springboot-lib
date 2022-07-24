<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2022/4/12
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon"/>

    <link rel="bookmark" href="/favicon.ico" type="image/x-icon"/>


</head>
<body style="background: url(/resource/images/bg2.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<%--<a th:href="{/user/add}">add</a>|<a th:href="user/update">update</a>|<a th:href="/index">update</a>--%>


　　　　
<form name="form" action="<%=request.getContextPath()%>/index">

    　　 <input type="submit" value="跳转1">

    　　
</form>
</body>
</html>
