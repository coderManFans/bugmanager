<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <title>Metronic | Form Stuff - Form Validation</title>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <%@include file="../includes/globalcss.jsp" %>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/js/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>"/>
    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL STYLES -->

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/select2_metro.css"/>" />

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/chosen.css"/>" />

    <!-- END PAGE LEVEL STYLES -->

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN HEADER -->

<%@include file="../includes/head.jsp"%>
<!-- END HEADER -->

<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid">

    <!-- BEGIN SIDEBAR -->

    <%@include file="../includes/siderbar.jsp" %>
    <!-- END SIDEBAR -->

    <!-- BEGIN PAGE -->

    <div class="page-content">

        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <%@include file="../includes/sampleportlet.jsp" %>

        <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <!-- BEGIN PAGE CONTAINER-->

        <div class="container-fluid">

            <!-- BEGIN PAGE HEADER-->
            <%@include file="../includes/page_header.jsp" %>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
<c:forEach items="${bugContentList}" var="bugcontent">
    <div class="row-fluid">
        <div class="span12">
            <!-- BEGIN SAMPLE FORM PORTLET-->
            <div class="portlet box blue">
                <div class="portlet-title">
                    <div class="caption"><i class="icon-reorder"></i></div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                        <a href="#portlet-config" data-toggle="modal" class="config"></a>
                        <a href="javascript:;" class="reload"></a>
                        <a href="javascript:;" class="remove"></a>
                    </div>
                </div>
                <div class="portlet-body form">
                    <!-- BEGIN FORM-->
                    <form action="#" class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label">上传用户:</label>
                            <div class="controls">
                                <span class="help-inline">${bugcontent.userId}</span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">错误原因:</label>
                            <div class="controls">
                                <span class="help-inline">${bugcontent.bugReason}</span>
                            </div>
                        </div>
                        <div class="control-group">
                                <label class="control-label">是否有解决方案:</label>
                                <div class="controls">
                                    <span class="help-inline">${bugcontent.hasSolved}</span>
                                </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">提交时间:</label>
                            <div class="controls">
                                <span class="help-inline">${bugcontent.upDate}</span>
                            </div>
                        </div>
                        <div class="control-group">
                                <label class="control-label">是否有解决方案:</label>
                                <div class="controls">
                                    <span class="help-inline">${bugcontent.upDate}</span>
                                </div>
                        </div>
                        <div class="form-actions">
                            <button type="submit" class="btn blue">Submit</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END SAMPLE FORM PORTLET-->
        </div>
    </div>
</c:forEach>
            <!-- END PAGE CONTENT-->
        </div>
        <!-- END PAGE CONTAINER-->
    </div>
    <!-- END PAGE -->

</div>
<jsp:include page="../includes/confirmdiv.jsp"/>

<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->

<%@include file="../includes/footer_up.jsp" %>
<!-- END FOOTER -->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

<!-- BEGIN CORE PLUGINS -->

<%@include file="../includes/jquerycore.jsp"%>

<!-- END CORE PLUGINS -->
<script type="text/javascript"
        src="<c:url value="/static/js/bower_components/DataTables/media/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/static/js/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"/>"></script>

<script type="text/javascript" src="<c:url value="/static/js/global/scripts/datatable.js"/>"></script>
<%--
<script type="text/javascript" src="<c:url value="/static/js/system/bugcontent/bugcontent.js"/>"></script>
--%>
<script type="text/javascript">


</script>

<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->

</html>