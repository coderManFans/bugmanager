<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/css/matrix-login.css"/>" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="loginbox">
    <form id="loginform" class="form-vertical" action="<c:url value="/login"/>>" method="post">
        <div class="control-group normal_text"> <h3><img src="img/logo.png" alt="Logo" /></h3></div>
        <h3 class="form-title"><spring:message code="loginToYourAccount"/></h3>
        <div class="alert alert-danger display-hide">
            <button class="close" data-close="alert"></button>
            <span><spring:message code="enterAnyUsernameAndPassword"/></span>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-user"></i></span>
                    <input type="text" placeholder="<spring:message code="username"/>>" name="userName" id="userName" value="admin"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_ly"><i class="icon-lock"></i></span>
                    <input type="password" placeholder="<spring:message  code="password"/>>" name="userPass" id="userPass" value="admin" />
                </div>
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">Lost password?</a></span>
            <span class="pull-right"><a type="submit" href="index.html" class="btn btn-success" > Login</a></span>
        </div>
    </form>
    <form id="recoverform" action="#" class="form-vertical">
        <p class="normal_text">Enter your e-mail address below and we will send you instructions how to recover a password.</p>
        <div class="controls">
            <div class="main_input_box">
                <span class="add-on bg_lo"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" />
            </div>
        </div>
        <div class="form-actions">
            <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
            <span class="pull-right"><a class="btn btn-info" >Reecover</a></span>
        </div>
    </form>
</div>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/matrix.login.js"/>"></script>
</body>
</html>
