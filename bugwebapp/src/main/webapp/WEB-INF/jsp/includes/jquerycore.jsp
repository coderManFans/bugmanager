<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

<!-- BEGIN CORE PLUGINS -->

<script src="<c:url value="/static/js/bower_components/jquery/dist/jquery.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/media/js/jquery-migrate-1.2.1.min.js"/>" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script src="<c:url value="/static/media/js/jquery-ui-1.10.1.custom.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/js/bower_components/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>

<!-- BEGIN CORE PLUGINS -->
<script src="<c:url value="/static/media/js/jquery.slimscroll.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/media/js/jquery.blockui.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/media/js/jquery.cookie.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/bower_components/toastr/toastr.min.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/media/js/jquery.uniform.min.js"/>" type="text/javascript" ></script>
<script src="<c:url value="/static/js/bower_components/jquery-validation/dist/jquery.validate.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/bower_components/jquery-validation/src/localization/messages_zh.js"/>" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value="/static/js/global/scripts/metronic.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/media/js/layout.js"/>" type="text/javascript"></script>

<script src="<c:url value="/static/js/global/scripts/global.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/global/scripts/util.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/global/scripts/toast.js"/>"></script>

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });
</script>

