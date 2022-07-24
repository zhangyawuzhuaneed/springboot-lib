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
<%--<body style="background: url(/resource/images/bg2.jpg) ; background-size:100% 100% ; background-attachment: fixed">--%>
<body >
<div style="width: 1200px;margin: auto">
    <div>
        <h4 align="center">书籍列表展示</h4>
    </div>

    <div>
        <p> 个人账户余额: ${user.money} 用户名: ${user.username} </p>
        <a style="float: right;margin: 5px;" class="btn btn-primary"></a>
        <a style="float: right;margin: 5px;" class="btn btn-primary"
           href="${pageContext.request.contextPath}/logout">注销</a>
        <a href="/user/torecharge" class="btn btn-info">充值界面</a>

        <a href="/single_user/list" class="btn btn-info">个人藏书室</a>
    </div>
    <div>
        <form style="float: left;margin: 5px;" class="form-inline"
              action="${pageContext.request.contextPath}/conditionQuery" method="get">
            <div class="form-group">
                <label for="name">图书名</label>
                <input type="text" name="name" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="author">图书作者</label>
                <input type="text" name="author" class="form-control" id="author">
            </div>
            <div class="form-group">
                <label for="press">图书出版社</label>
                <input type="text" name="press" class="form-control" id="press">
            </div>

            <button type="submit" class="btn btn-info">查询</button>
        </form>
    </div>




    <table class="table table-striped">
        <tr>
            <th>序号</th>
            <th>图书名</th>
            <th>图书作者</th>
            <th>图书出版社</th>
            <th>图书单价</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
        </tr>
        <c:forEach items="${books}" var="book" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.press}</td>
                <td>${book.price}</td>
                <td>${book.bootNum}</td>
                <td>
                        <%--                    这个方法需要修改--%>
                    <a href="${pageContext.request.contextPath}/single_user/purchase/${book.name}"
                       class="btn btn-success">付费购买（下载）</a>
                    <a href="${pageContext.request.contextPath}/single_user/queryBookByName/${book.name}"
                       class="btn btn-success" style="color: royalblue">试读借阅</a>
                        <%--                    <a href="${pageContext.request.contextPath}/queryBookById/${book.bookId}" class="btn btn-success">归还</a>--%>
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

