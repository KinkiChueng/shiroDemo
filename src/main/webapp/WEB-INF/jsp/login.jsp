<%--
  Created by IntelliJ IDEA.
  User: lasia
  Date: 2019/4/12
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body class="login">
<div class="content">
    <form class="login-form" th:action="login" method="post">
        <h3 class="form-title font-green">用户登录</h3>
        <div class="alert alert-danger display-hide">
            <span> 请输入用户名和密码 </span>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" /> </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" /> </div>
        <div class="form-actions">
            <button type="submit">登录</button>
            <!--<label class="rememberme check mt-checkbox mt-checkbox-outline">-->
            <!--<input type="checkbox" name="remember" value="1" />Remember-->
            <!--<span></span>-->
            <!--</label>-->
            <!--<a href="javascript:;" id="forget-password" class="forget-password">Forgot Password?</a>-->
        </div>
    </form>
</div>
</body>
</html>
