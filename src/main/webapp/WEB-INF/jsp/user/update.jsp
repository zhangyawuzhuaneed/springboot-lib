<%--
  Created by IntelliJ IDEA.
  User: Xiang
  Date: 2021/9/28
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 1200px;margin: auto">
    <div>
        <h4 align="center">修改书籍信息</h4>
    </div>
    <%--
      bookId int not null primary key auto_increment, --图书id
              name   varchar(50),                             --图书名
              author varchar(50),                             --图书作者
              press  varchar(50),                             --图书出版社
              price  double(6, 2                              --图书单价
      --%>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/update" method="post">
        <input name="bookId" value="${book.bookId}" hidden/>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">图书名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="姓名" value="${book.name}">
            </div>
        </div>

        <div class="form-group">
            <label for="author" class="col-sm-2 control-label">图书作者</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="author" name="author" placeholder="年龄"
                       value="${book.author}">
            </div>
        </div>

        <div class="form-group">
            <label for="press" class="col-sm-2 control-label">图书出版社</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="press" name="press" placeholder="press"
                       value="${book.press}">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">图书单价</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" name="price" placeholder="price"
                       value="${book.price}">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">确认修改</button>

                <input type="button" onclick="history.go(-1)" class="btn btn-warning" value="取消修改"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>

