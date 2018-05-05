<%--
  Created by IntelliJ IDEA.
  User: Fantasy
  Date: 2018/5/2
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>500 错误信息</title>
    <link rel="stylesheet" type="text/css" href="http://unpkg.com/iview/dist/styles/iview.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/500.css">
</head>
<body>


<div class="error500" id="error500">
    <div class="error500-body-con">
        <Card>
            <div class="error500-body-con-title">
                5<span class="error500-0-span"><Icon type="social-freebsd-devil"></Icon></span><span
                    class="error500-0-span"><Icon type="social-freebsd-devil"></Icon></span>
            </div>
            <p class="error500-body-con-message">Oops!
                <%=exception.getMessage() %>
            </p>
            <div class="error500-btn-con">
                <i-button @click="goHome" size="large" style="width: 200px;" type="text">返回首页</i-button>
                <i-button @click="backPage" size="large" style="width: 200px;margin-left: 40px;" type="primary">返回上一页
                </i-button>
            </div>
        </Card>
    </div>
</div>
<script type="text/javascript" src="http://vuejs.org/js/vue.min.js"></script>
<script type="text/javascript" src="http://unpkg.com/iview/dist/iview.min.js"></script>
<script type="text/javascript">
    new Vue({
        el: '#error500',
        methods: {
            backPage: function () {
                this.$router.go(-1);
            },
            goHome: function () {
                this.$router.push({
                    name: 'home_index'
                });
            }
        }
    });
</script>
</body>
</html>
