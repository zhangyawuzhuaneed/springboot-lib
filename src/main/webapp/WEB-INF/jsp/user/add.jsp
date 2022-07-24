<%--
  Created by IntelliJ IDEA.
  User: Xiang
  Date: 2021/9/28
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body style="background: url(/resource/images/12.jpg)">
<div style="width: 1200px;margin: auto">
    <div>
        <h4 align="center">添加书箱</h4>
    </div>
    <%--
    bookId int not null primary key auto_increment, --图书id
            name   varchar(50),                             --图书名
            author varchar(50),                             --图书作者
            press  varchar(50),                             --图书出版社
            price  double(6, 2                              --图书单价
    --%>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/add" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">图书名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="图书名">
            </div>
        </div>

        <div class="form-group">
            <label for="author" class="col-sm-2 control-label">图书作者</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="author" name="author" placeholder="图书作者">
            </div>
        </div>

        <div class="form-group">
            <label for="press" class="col-sm-2 control-label">图书出版社</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="press" name="press" placeholder="图书出版社">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">图书单价</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" name="price" placeholder="图书单价">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">确认添加</button>

                <input type="button" onclick="history.go(-1)" class="btn btn-warning" value="取消添加"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>

