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
<body style="background: url(/resource/images/single.jpg)">
<div style="width: 1200px;margin: auto">
    <div>
        <h4 align="center">充值页面</h4>
    </div>


    <form style="float: left;margin: 5px;" class="form-inline"
          action="${pageContext.request.contextPath}/single_user/recharge" method="get">
        <div class="form-group">
            <label for="addMon">充值金额</label>
            <input type="Double" name="addMon" id="addMon" class="form-control" placeholder="账号" required=""
                   autofocus="">

        </div>

        <button type="submit" class="btn btn-info">充值</button>
    </form>

</div>
</body>