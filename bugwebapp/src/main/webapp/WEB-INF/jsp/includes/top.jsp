<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顶部</title>
</head>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.min.css" />"type='text/css' />
<link rel="stylesheet" href="<c:url value="/css/fullcalendar.css"/>" type='text/css' />
<link rel="stylesheet" href="<c:url value="/css/matrix-style.css"/>" type='text/css'/>
<link rel="stylesheet" href="<c:url value="/css/matrix-media.css"/>" type='text/css'/>
<link href="<c:url value="/asserts/font-awesome/css/font-awesome.css"/>" rel="stylesheet" type='text/css'/>
<link rel="stylesheet" href="<c:url value="/css/jquery.gritter.css"/>" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
<body>
<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part-->


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="icon-user"></i> 我的工程文档</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-check"></i>当前任务</a></li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="icon-key"></i>退出登陆</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> 短消息</a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i>收件箱</a></li>
                <li class="divider"></li>
                <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> 发件箱</a></li>
                <li class="divider"></li>
                <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> 垃圾桶</a></li>
            </ul>
        </li>
        <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">个人设置</span></a></li>
        <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出登陆</span></a></li>
    </ul>
</div>
<!--close-top-Header-menu-->

<script src="<c:url  value="/js/excanvas.min.js"/>" ></script>
<script src="<c:url value="/js/jquery.min.js"/>"   ></script>
<script src="<c:url value="/js/jquery.ui.custom.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/jquery.flot.min.js"/>"></script>
<script src="<c:url value="/js/jquery.flot.resize.min.js"/>"></script>
<script src="<c:url value="/js/jquery.peity.min.js"/>"></script>
<script src="<c:url value="/js/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/js/matrix.js"/>"></script>
<script src="<c:url value="/js/matrix.dashboard.js"/>"></script>
<script src="<c:url value="/js/jquery.gritter.min.js"/>"></script>
<script src="<c:url value="/js/matrix.interface.js"/>"></script>
<script src="<c:url value="/js/matrix.chat.js"/>"></script>
<script src="<c:url value="/js/jquery.validate.js"/>"></script>
<script src="<c:url value="/js/matrix.form_validation.js"/>"></script>
<script src="<c:url value="/js/jquery.wizard.js"/>"></script>
<script src="<c:url value="/js/jquery.uniform.js"/>"></script>
<script src="<c:url value="/js/select2.min.js"/>"></script>
<script src="<c:url value="/js/matrix.popover.js"/>"></script>
<script src="<c:url value="/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/js/matrix.tables.js"/>"></script>

<script type="text/javascript">
    // This function is called from the pop-up menus to transfer to
    // a different page. Ignore if the value returned is a null string:
    function goPage (newURL) {

        // if url is empty, skip the menu dividers and reset the menu selection to default
        if (newURL != "") {

            // if url is "-", it is this page -- reset the menu:
            if (newURL == "-" ) {
                resetMenu();
            }
            // else, send page to designated URL
            else {
                document.location.href = newURL;
            }
        }
    }
    // resets the menu selection upon entry to this page:
    function resetMenu() {
        document.gomenu.selector.selectedIndex = 2;
    }
</script>

</body>
</html>
