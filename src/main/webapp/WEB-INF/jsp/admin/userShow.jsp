<%--
  Created by IntelliJ IDEA.
  User: Xiang
  Date: 2021/9/28
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body style="background: url(/resource/images/admin.jpg)">
<div style="width: 1200px;margin: auto">
    <div>
        <h1 align="center">用户管理界面</h1>
    </div>


    <div>
        <a href="/admin/list" class="btn btn-info">图书馆界面</a>

        <form style="float: left;margin: 5px;" class="form-inline"
              action="${pageContext.request.contextPath}/admin/conditionQuery" method="get">
            <div class="form-group">
                <label for="username">姓名</label>
                <input type="text" name="username" class="form-control" id="username">
            </div>


            <button type="submit" class="btn btn-info">查询</button>
        </form>


        <%--        <a style="float: right;margin: 5px;" class="btn btn-primary"--%>
        <%--           href="${pageContext.request.contextPath}/user/list">书籍列表页</a>--%>
        <a style="float: right;margin: 5px;" class="btn btn-primary" href="${pageContext.request.contextPath}/user/add">添加书籍</a>
        <a style="float: right;margin: 5px;" class="btn btn-primary"
           href="${pageContext.request.contextPath}/logout">注销</a>
    </div>

    <%--    <table class="table table-hover">--%>
    <%--
        bookId int not null primary key auto_increment, --图书id
        name   varchar(50),                             --图书名
        author varchar(50),                             --图书作者
        press  varchar(50),                             --图书出版社
        price  double(6, 2                              --图书单价
        --%>
    <table class="table table-striped">
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>用户密码</th>
            <th>用户其它信息</th>
            <%--            <th>图书单价</th>--%>
            <%--            <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>--%>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.passwrod}</td>
                    <%--                <td>${book.press}</td>--%>
                    <%--                <td>${book.price}</td>--%>
                    <%--                <td>${book.bootNum}</td>--%>
                <td>


                    <a href="${pageContext.request.contextPath}/user/delete/${book.bookId}"
                       class="btn btn-danger">删除用户</a>
                    <a href="${pageContext.request.contextPath}/queryBookById/${book.bookId}" class="btn btn-success">查看具体信息</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <%--分页导航标签--%>
    <div class="row">
        <div class="col-md-6">
            第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
        </div>
        <div class="col-md-6 offset-md-4">
            <nav aria-label="Page navigation example">
                <ul class="pagination pagination-sm">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/user/list?page=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user/list?page=${pageInfo.pageNum-1}">上一页</a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                        <c:if test="${page==pageInfo.pageNum}">
                            <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                        </c:if>
                        <c:if test="${page!=pageInfo.pageNum}">
                            <li class="page-item"><a class="page-link"
                                                     href="${pageContext.request.contextPath}/user/list?page=${page}">${page}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user/list?page=${pageInfo.pageNum+1}">下一页</a>
                        </li>
                    </c:if>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/user/list?page=${pageInfo.pages}">末页</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>


</div>
</body>
</html>
