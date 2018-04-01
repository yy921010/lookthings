<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2018/1/23
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet" type="text/css" href="http://unpkg.com/iview/dist/styles/iview.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/404.css">
</head>
<body>
<div id="not-found-page">
    <div class="error404">
        <div class="error404-body-con">
            <Card>
                <div class="error404-body-con-title">4<span><Icon type="ios-navigate-outline"></Icon></span>4</div>
                <p class="error404-body-con-message">YOU&nbsp;&nbsp;LOOK&nbsp;&nbsp;LOST</p>
                <div class="error404-btn-con" style="text-align: center;">
                    <i-button @click="goHome" size="large" style="width: 200px;" type="primary">返回首页
                    </i-button>
                </div>
            </Card>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://vuejs.org/js/vue.min.js"></script>
<script type="text/javascript" src="http://unpkg.com/iview/dist/iview.min.js"></script>
<script type="text/javascript" src="<%=basePath%>scripts/404.js"></script>
</body>
</html>
