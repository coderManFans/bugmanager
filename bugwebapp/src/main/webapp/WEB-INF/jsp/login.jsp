
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
        <form class="form-horizontal" id="loginform" action="<c:url value="/login"/>" method="post">
            <div class="control-group">
                <label class="control-label" for="inputusername">用户名</label>
                <div class="controls ">
                    <input id="inputusername" type="text" name="userName">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputusername">密码</label>
                <div class="controls">
                    <input id="inputpassword" type="text" name="password">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <label class="checkbox">
                        <input type="checkbox" />记住我
                    </label>
                </div>
                <input type="submit" value="登陆" class="btn-large">
            </div>
        </form>
    </div>
</body>
</html>
