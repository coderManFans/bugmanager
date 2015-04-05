
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <%@include file="../includes/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/login-soft.css"/>" />

</head>
<body>
<div class="container">
    <h3 class="form-title"><spring:message code="loginToYourAccount"/></h3>
    <div class="alert alert-danger display-hide">
        <button class="close" data-close="alert"></button>
        <span><spring:message code="enterAnyUsernameAndPassword"/></span>
    </div>
    <form class="form-horizontal" id="loginform" action="<c:url value="/user/registe"/>" method="post">
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9"><spring:message code="username"/></label>
            <div class="cinput-icon">
                <i class="fa fa-user"></i>
                <input type="text" class="form-control placeholder-no-fix"
                       placeholder="<spring:message code="username"/>" name="userName" id="username">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label">邮箱:</label>
            <div class="input-icon">
                <input type="text" name="email" id="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9"><spring:message code="password"/></label>
            <div class="input-icon">
                <input type="password" class="form-control placeholder-no-fix"
                       placeholder="<spring:message code="password"/>"name="userPass" id="password" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label">确认密码:</label>
            <div class="controls">
                <input type="password" name="userPass" id="pwd2" />
            </div>
        </div>
        <div class="form-actions">
            <label class="checkbox">
                <input type="checkbox" name="remember" value="1"/><spring:message code="rememberMe"/></label>
            <button type="button" id="loginBtn" class="btn blue pull-right"><spring:message code="login"/><i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>
    </form>
</div>
<%@include file="../includes/footer.jsp"%>
<%@include file="../includes/bottomscript.jsp"%>
<script src="<c:url value="/static/js/system/security/user.js"/>" type="application/javascript"></script>
<script>
    $(function(){
        Register.init();
        <c:if test="${message!=null}">
            toast.error("${message}");
        </c:if>
    })
</script>
</body>
</html>
