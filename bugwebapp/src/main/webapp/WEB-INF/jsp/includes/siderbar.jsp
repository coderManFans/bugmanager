<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>侧边栏</title>
</head>
<body>
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> 指南针</a>
    <ul>
        <li class="active"><a href="index.html"><i class="icon icon-home"></i> <span>我的指南针</span></a> </li>
        <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>项目统计</span></a> </li>
        <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>宽屏</span></a> </li>
        <li><a href="tables.html"><i class="icon icon-th"></i> <span>bug集锦</span></a></li>
        <li><a href="grid.html"><i class="icon icon-fullscreen"></i> <span>全屏</span></a></li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>基本选项</span> <span class="label label-important">3</span></a>
            <ul>
                <li><a href="form-common.html">基本选项2</a></li>
                <li><a href="form-validation.html">基本选项3</a></li>
                <li><a href="form-wizard.html">基本选项4</a></li>
            </ul>
        </li>
        <li><a href="buttons.html"><i class="icon icon-tint"></i> <span>基本选项午</span></a></li>
        <li><a href="interface.html"><i class="icon icon-pencil"></i> <span>基本选项6</span></a></li>
        <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>附件</span> <span class="label label-important">5</span></a>
            <ul>
                <li><a href="index2.html">技术指南杂志</a></li>
                <li><a href="gallery.html">人生画廊</a></li>
                <li><a href="calendar.html">本周计划表</a></li>
                <li><a href="invoice.html">消费单</a></li>
                <li><a href="chat.html">聊天窗口</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>错误演示平台</span> <span class="label label-important">4</span></a>
            <ul>
                <li><a href="403.jsp">Error 403</a></li>
                <li><a href="404.jsp">Error 404</a></li>
                <li><a href="500.jsp">Error 405</a></li>
                <li><a href="error500.html">Error 500</a></li>
            </ul>
        </li>
        <li class="content"> <span>项目一的进度表</span>
            <div class="progress progress-mini progress-danger active progress-striped">
                <div style="width: 77%;" class="bar"></div>
            </div>
            <span class="percent">77%</span>
            <div class="stat">21419.94 / 14000 MB</div>
        </li>
        <li class="content"> <span>项目二的进度表</span>
            <div class="progress progress-mini active progress-striped">
                <div style="width: 87%;" class="bar"></div>
            </div>
            <span class="percent">87%</span>
            <div class="stat">604.44 / 4000 MB</div>
        </li>
    </ul>
</div>
<!--sidebar-menu-->


<script src="<c:url value="/js/jquery.min.js"/>"   ></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/fullcalendar.min.js"/>"></script>
<script src="<c:url value="/js/jquery.validate.js"/>"></script>
<script src="<c:url value="/js/jquery.dataTables.min.js"/>"></script>

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
