<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/login.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
        /* function register(){
             let username = document.getElementById("username").value;
             let password  = document.getElementById("password").value;
             alert(username+""+""+password);
             window.location.href="http://localhost:8001/register/";
         }*/
    </script>
</head>


<c:if test="${fail != null} ">
    <div class="alert alert-danger" role="alert">
        <c:out value="${fail}"/>
        <c:remove var="fail" scope="session"/>
    </div>
</c:if>


<div style="color:red;font-size: 30px">
    <c:out value="${fail}"/>
</div>
<body class="text-center" style="background: url(/resource/images/spyder.jpg)">
<form class="form-signin" action="${pageContext.request.contextPath}/registering">
    <img class="mb-4" src="<%=request.getContextPath()%>/resource/images/123.jpg" alt="" width="100" height="150">
    <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
    <label for="username" class="sr-only">账号</label>
    <input type="text" name="username" id="username" class="form-control" placeholder="账号" required="" autofocus="">
    <label for="password" class="sr-only">密码</label>
    <input type="password" name="password" id="password" class="form-control" placeholder="密码" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button type="submit" class="btn btn-primary btn-lg">注册</button>
    <a href="index" class="btn btn-primary btn-lg">登录</a>
    <p class="mt-5 mb-3 text-muted">© 2021</p>
</form>
</body>
</html>

