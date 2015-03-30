
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bug类型</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap.min.css"/>">

</head>
<body>
<div class="container control-group" >
    <div class="navbar-fixed-form" id="tagform">
        <form class="form-actions" action="<c:url value="/tag/bugtype/add"/>" method="post">
            类型名称:<textarea class="form-inline" name="bugType" id="bugType" rows="3"></textarea>
            类型简介:<textarea class="form-inline" name="bugTypeIntroduce" id="typeIntroduce" rows="3"></textarea>
            <button id="btnsubmit" class="btn btn-success" type="submit" value="提交" ></button>
        </form>
    </div>
</div>
<script  type="application/javascript" src="<c:url value="/static/js/jquery.min.js"/> "></script>
<script type="application/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
</body>
</html>
