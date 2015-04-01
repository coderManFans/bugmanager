<%--@elvariable id="menu" type="com.threegrand.lucy.develop.model.Menu"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/bootstrap-responsive.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/style-metro.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/style-responsive.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/static/css/default.css"/>" rel="stylesheet" type="text/css" id="style_color"/>
<link href="<c:url value="/static/css/uniform.default.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<c:url value="/static/css/login.css"/>" rel="stylesheet" type="text/css"/>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()%><c:url value="/"/>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

