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

            <div class="row-fluid">
                <div class="span12">
                    <div class="portlet  box blue">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="active-result"></i>toollsdfs
                            </div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse"></a>
                            </div>
                            <div class="actions">
                                <a href="javascript:;" class="btn default yellow-stripe" id="dataTableReload"><i
                                        class="fa fa-refresh"></i><span class="hidden-480"> 重新载入</span></a>
                                <div class="btn-group">
                                    <a class="btn default yellow-stripe" href="#" data-toggle="dropdown">
                                        <i class="fa fa-plus"></i>
                                        <span class="hidden-480">选择列</span>
                                        <i class="fa fa-angle-down"></i>
                                    </a>
                                    <div class="dropdown-menu hold-on-click dropdown-checkboxes pull-right"
                                         id="dataTableToggleColumn">
                                        <label><input type="checkbox" checked="checked" data-column="0">序号</label>
                                        <label><input type="checkbox" checked="checked" data-column="1">错误原因</label>
                                        <label><input type="checkbox" checked="checked" data-column="2">是否解决</label>
                                        <label><input type="checkbox" checked="checked" data-column="3">上传日期</label>
                                        <label><input type="checkbox" checked="checked" data-column="4">用户序号</label>
                                        <label><input type="checkbox" checked="checked" data-column="5">操作</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-container">
                                <table class="table table-striped table-bordered table-hover" id="dataTable">
                                    <thead>
                                    <tr role="row" class="heading">
                                        <th>序号</th>
                                        <th>错误原因</th>
                                        <th>是否解决</th>
                                        <th>上传日期</th>
                                        <th>用户序号</th>
                                        <th>操作</th>
                                    </tr>
                                    <tr role="row" class="filter">
                                        <td>
                                            <input type="text" class="form-control form-filter input-sm gAuto"
                                                   autoFlag="gAutoDictName" name="userNameQuery" id="userNameQuery">
                                        </td>
                                        <td>
                                            <input type="text" class="form-control form-filter input-sm gAuto"
                                                   autoFlag="gAutoDescribe" name="createDateQuery" id="createDateQuery">
                                        </td>
                                        <td>
                                            <input type="text" class="form-control form-filter input-sm gAuto"
                                                   autoFlag="gAutoDescribe" name="ipQuery" id="ipQuery">
                                        </td>
                                        <td>
                                            <input type="text" class="form-control form-filter input-sm gAuto"
                                                   autoFlag="gAutoDescribe" name="requestUriQuery" id="requestUriQuery">
                                        </td>
                                        <td>
                                            <input type="text" class="form-control form-filter input-sm gAuto"
                                                   autoFlag="gAutoDictName" name="bugReasonQuery" id="bugReasonQuery">
                                        </td>
                                        <td>
                                            <div class="margin-bottom-5">
                                                <a class="btn btn-sm yellow filter-submit margin-bottom">
                                                    <i class="fa fa-search"></i>查询</a>
                                                <a class="btn btn-sm red filter-cancel">
                                                    <i class="fa fa-refresh"></i>重置</a>
                                            </div>
                                        </td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

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
<script type="text/javascript" src="<c:url value="/static/js/system/bugcontent/bugcontent.js"/>"></script>
<script type="text/javascript">

    jQuery(document).ready(function() {
        // initiate layout and plugins
        bugContentListTable.init();
    });
</script>

<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->

</html>