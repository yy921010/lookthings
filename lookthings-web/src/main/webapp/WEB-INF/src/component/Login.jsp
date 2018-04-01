<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2018/1/23
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="http://unpkg.com/iview/dist/styles/iview.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/login.css">
</head>
<body>
<div id="user-login">
    <div class="login" @keydown.enter="handleSubmit">
        <div class="login-con">
            <Card :bordered="false">
                <p slot="title">
                    <Icon type="log-in"></Icon>
                    欢迎登录
                </p>
                <div class="form-con">
                    <i-form ref="loginForm" :model="form" :rules="rules">
                        <form-item prop="userName">
                            <i-input v-model="form.userName" placeholder="请输入用户名">
                            <span slot="prepend">
                                    <Icon :size="16" type="person"></Icon>
                                </span>
                            </i-input>
                        </form-item>
                        <form-item prop="password">
                            <i-input type="password" v-model="form.password" placeholder="请输入密码">
                            <span slot="prepend">
                                    <Icon :size="14" type="locked"></Icon>
                                </span>
                            </i-input>
                        </form-item>
                        <form-item>
                            <i-button @click="handleSubmit" type="primary" long>登录</i-button>
                        </form-item>
                    </i-form>
                    <p class="login-tip">输入管理员用户名和密码</p>
                </div>
            </Card>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue"></script>
<script type="text/javascript" src="http://unpkg.com/iview/dist/iview.min.js"></script>
<script type="text/javascript" src="<%=basePath%>scripts/login.js"></script>
</body>
</html>