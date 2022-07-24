<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/css/login.css">
    <link rel="icon" href="/favicon.ico"/>
    <link rel="bookmark" href="/favicon.ico"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<%--<body class="text-center" style="background: url(/resource/images/1234.jpg)">--%>
<body class="text-center"
      style="background: url(/resource/images/1234.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<p text="${msg}" style="color: limegreen"></p>
<form class="form-signin" action="<%=request.getContextPath()%>/login">
    <img class="mb-4" src="<%=request.getContextPath()%>/resource/images/三井寿.jpg" alt="" width="100" height="150">
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
    <%--    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>--%>
    <%--    <a href="register.jsp" class="btn btn-lg btn-primary btn-block" type="submit">注册</a>--%>

    <a href="register" type="submit" class="btn btn-primary btn-lg">注册</a>
    <button type="submit" class="btn btn-primary btn-lg">登录</button>

    <p class="mt-5 mb-3 text-muted">© 2021</p>
</form>
</body>
</html>

