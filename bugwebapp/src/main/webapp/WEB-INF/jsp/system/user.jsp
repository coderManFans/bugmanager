
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap.min.css"/>">
    <script type="application/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
    <script type="application/javascript" src="<c:url value="/static/js/jquery-2.0.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <form class="form-horizontal" id="loginform" action="<c:url value="/user/registe"/>" method="post">
        <div class="control-group">
            <label class="control-label">呢称:</label>
            <div class="controls">
                <input type="text" name="userName" id="required">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">邮箱:</label>
            <div class="controls">
                <input type="text" name="email" id="email">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">密码:</label>
            <div class="controls">
                <input type="password" name="userPass" id="pwd" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">确认密码:</label>
            <div class="controls">
                <input type="password" name="userPass" id="pwd2" />
            </div>
        </div>
        <div class="form-actions">
            <input type="submit" value="注册" class="btn btn-success">
        </div>
    </form>
</div>
</body>
</html>
