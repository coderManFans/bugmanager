<!DOCTYPE html><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--[if !IE]><!--> <html lang="en"> <!--<![endif]--><!-- BEGIN HEAD --><head>	<title>Metronic | Form Stuff - Form Validation</title>	<!-- BEGIN GLOBAL MANDATORY STYLES -->    <%@include file="../includes/globalcss.jsp" %>    <link rel="stylesheet" type="text/css"          href="<c:url value="/static/js/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>"/>	<!-- END GLOBAL MANDATORY STYLES -->	<!-- BEGIN PAGE LEVEL STYLES -->	<link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/select2_metro.css"/>" />	<link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/chosen.css"/>" />	<!-- END PAGE LEVEL STYLES --></head><!-- END HEAD --><!-- BEGIN BODY --><body class="page-header-fixed">	<!-- BEGIN HEADER -->    <%@include file="../includes/head.jsp"%>	<!-- END HEADER -->	<!-- BEGIN CONTAINER -->	<div class="page-container row-fluid">		<!-- BEGIN SIDEBAR -->        <%@include file="../includes/siderbar.jsp" %>		<!-- END SIDEBAR -->		<!-- BEGIN PAGE -->  		<div class="page-content">			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->            <%@include file="../includes/sampleportlet.jsp" %>			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->			<!-- BEGIN PAGE CONTAINER-->			<div class="container-fluid">				<!-- BEGIN PAGE HEADER-->                <%@include file="../includes/page_header.jsp" %>				<!-- END PAGE HEADER-->				<!-- BEGIN PAGE CONTENT-->                <div class="row-fluid">                    <div class="span12">                        <div class="portlet  box blue">                            <div class="portlet-title">                                <div class="tools">                                    <a href="javascript:;" class="collapse"></a>                                </div>                                <div class="actions">                                    <a href="javascript:;" class="btn default yellow-stripe" id="showAddtag"><i                                            class="fa fa-edit"></i><span class="hidden-480"> 添加错误标签</span></a>                                    <a href="javascript:;" class="btn default yellow-stripe" id="dataTableReload"><i                                            class="fa fa-refresh"></i><span class="hidden-480"> 重新载入</span></a>                                    <div class="btn-group">                                        <a class="btn default yellow-stripe" href="#" data-toggle="dropdown">                                            <i class="fa fa-plus"></i>                                            <span class="hidden-480">选择列</span>                                            <i class="fa fa-angle-down"></i>                                        </a>                                        <div class="dropdown-menu hold-on-click dropdown-checkboxes pull-right"                                             id="dataTableToggleColumn">                                            <label><input type="checkbox" checked="checked" data-column="0">序号</label>                                            <label><input type="checkbox" checked="checked" data-column="1">标签名称</label>                                            <label><input type="checkbox" checked="checked" data-column="2">操作</label>                                        </div>                                    </div>                                </div>                            </div>                            <div class="portlet-body">                                <div class="table-container">                                    <table class="table table-striped table-bordered table-hover" id="dataTable">                                        <thead>                                        <tr role="row" class="heading">                                            <th>序号</th>                                            <th>标签名称</th>                                            <th>操作</th>                                        </tr>                                        <tr role="row" class="filter" id="addtagForm" style="display: none">                                            <td>                                            </td>                                            <td>                                                <input type="text" id="addTagName" class="form-control input-sm"/>                                            </td>                                            <td><a class="btn default btn-sm green" href="javascript:;"                                                   id="addtagButton"><i class="fa fa-edit"></i>添加</a>&nbsp;<a                                                    class="cancel btn default btn-sm" href="javascript:;" id="cancelAdd"><i                                                    class="fa fa-times"></i>取消</a></td>                                        </tr>                                        <tr role="row" class="filter">                                            <td></td>                                            <td>                                                <input type="text" class="form-control form-filter input-sm gAuto"                                                       autoFlag="gAutoDictName" name="tagNameQuery" id="tagNameQuery">                                            </td>                                            <td>                                                <div class="margin-bottom-5">                                                    <a class="btn btn-sm yellow filter-submit margin-bottom">                                                        <i class="fa fa-search"></i>查询</a>                                                    <a class="btn btn-sm red filter-cancel">                                                        <i class="fa fa-refresh"></i>重置</a>                                                </div>                                            </td>                                        </tr>                                        </thead>                                        <tbody>                                        </tbody>                                    </table>                                </div>                            </div>                        </div>                    </div>                </div>				<!-- END PAGE CONTENT-->         			</div>			<!-- END PAGE CONTAINER-->		</div>		<!-- END PAGE -->  	</div>    <jsp:include page="../includes/confirmdiv.jsp"/>    <!-- END CONTAINER -->	<!-- BEGIN FOOTER -->    <%@include file="../includes/footer_up.jsp" %>	<!-- END FOOTER -->	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->	<!-- BEGIN CORE PLUGINS -->	<%@include file="../includes/jquerycore.jsp"%>	<!-- END CORE PLUGINS -->    <script type="text/javascript"            src="<c:url value="/static/js/bower_components/DataTables/media/js/jquery.dataTables.min.js"/>"></script>    <script type="text/javascript"            src="<c:url value="/static/js/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"/>"></script>    <script src="<c:url value="/static/js/global/scripts/datatable.js"/>"></script>    <script src="<c:url value="/static/js/system/bugtag/tag.js"/>"></script>    <script>		jQuery(document).ready(function() {   		   // initiate layout and plugins            tagListTable.init();		});	</script>	<!-- END JAVASCRIPTS -->    </body><!-- END BODY --></html>