
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<script src="<c:url value="/static/js/jquery-1.10.1.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery-migrate-1.2.1.min.js"/>" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value="/static/js/jquery-ui-1.10.1.custom.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="<c:url value='/static/js/excanvas.min.js'/>"></script>
<script src="<c:url value='/static/js/respond.min.js'/>"></script>
<![endif]-->
<script src="<c:url value="/static/js/jquery.slimscroll.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery.blockui.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery.cookie.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery.uniform.min.js"/>" type="text/javascript" ></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<c:url value="/static/js/jquery.validate.min.js"/>" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value="/static/js/app.js"/>" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->