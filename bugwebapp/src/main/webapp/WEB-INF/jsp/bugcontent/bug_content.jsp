<!DOCTYPE html><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--[if !IE]><!--> <html lang="en"> <!--<![endif]--><!-- BEGIN HEAD --><head>	<title>Metronic | Form Stuff - Form Validation</title>    <%@include file="../includes/globalcss.jsp" %>    <!-- END GLOBAL MANDATORY STYLES -->    <!-- BEGIN PAGE LEVEL STYLES -->    <link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/select2_metro.css"/>" />    <link href="<c:url value="/static/js/bower_components/select2/select2.css"/>" rel="stylesheet" type="text/css" />    <link href="<c:url value="/static/js/bower_components/select2/select2-bootstrap.css"/>" rel="stylesheet" type="text/css" />    <link href="<c:url value="/static/ckeditor/contents.css"/>" rel="stylesheet" type="text/css">    <link href="<c:url value="/static/media/css/chosen.css"/>" rel="stylesheet" type="text/css" ></head><!-- END HEAD --><!-- BEGIN BODY --><body class="page-header-fixed">	<!-- BEGIN HEADER -->    <%@include file="../includes/head.jsp"%>	<!-- END HEADER -->	<!-- BEGIN CONTAINER -->	<div class="page-container row-fluid">		<!-- BEGIN SIDEBAR -->        <%@include file="../includes/siderbar.jsp" %>		<!-- END SIDEBAR -->		<!-- BEGIN PAGE -->  		<div class="page-content">			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->            <%@include file="../includes/sampleportlet.jsp" %>			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->			<!-- BEGIN PAGE CONTAINER-->			<div class="container-fluid">				<!-- BEGIN PAGE HEADER-->                <%@include file="../includes/page_header.jsp" %>				<!-- END PAGE HEADER-->				<!-- BEGIN PAGE CONTENT-->                <div class="row-fluid">                    <div class="span12">                        <!-- BEGIN SAMPLE FORM PORTLET-->                        <div class="portlet box blue">                            <div class="portlet-title">                                <div class="caption"><i class="icon-reorder"></i>添加错误说明</div>                                <div class="tools">                                    <a href="javascript:;" class="collapse"></a>                                    <a href="#portlet-config" data-toggle="modal" class="config"></a>                                    <a href="javascript:;" class="reload"></a>                                    <a href="javascript:;" class="remove"></a>                                </div>                            </div>                            <div class="portlet-body form">                                <!-- BEGIN FORM-->                                <form action="buginfo/bugcontent/add" class="form-horizontal" method="post">                                    <div class="control-group select2-container">                                        <label class="control-label">错误类型:</label>                                        <div class="controls">                                            <input type="hidden" name="bugtype" >                                            <select data-placeholder="select bugtypes for the bug" class="select2-choices span12" name="bugIdList" style="width:400px" multiple="multiple" tabindex="6">                                                <option value=""></option>                                                <c:forEach items="${bugTypeList}" var="bugtype">                                                    <option value="${bugtype.bugTypeId}">${bugtype.bugType}</option>                                                </c:forEach>                                            </select>                                        </div>                                    </div>                                    <div class="control-group">                                        <label class="control-label">错误标签:</label>                                        <div class="controls">                                                <select data-placeholder="select tags for the bug" id="select2_sample2" name="tagIdList" class="span12 select2" style="width:400px" multiple="multiple" tabindex="6">                                                    <option value=""></option>                                                    <c:forEach items="${tagTypeList}" var="tagtype">                                                        <option value="${tagtype.tagId}">${tagtype.tagName}</option>                                                    </c:forEach>                                                </select>                                        </div>                                    </div>                                    <div class="control-group">                                        <label class="control-label">错误原因简述:</label>                                        <div class="controls">                                            <textarea class="span6 m-wrap" name="bugReason" rows="6" cols="80"></textarea>                                        </div>                                    </div>                                    <div class="control-group">                                        <label class="control-label">控制台错误日志:</label>                                        <div class="controls">                                            <textarea class="span6 m-wrap" name="consoleError" ></textarea>                                        </div>                                    </div>                                    <div class="control-group">                                        <label class="control-label">程序错误代码:</label>                                        <div class="controls">                                            <textarea class="span6 m-wrap" name="bugCode" rows="3"></textarea>                                        </div>                                    </div>                                    <div class="control-group">                                        <label class="control-label">解决方案:</label>                                        <div class="controls">                                            <label class="radio">                                                <input type="radio" name="optionsRadios1" value="option1" id="hasSolveMethod" />                                                有                                            </label>                                            <label class="radio">                                                <input type="radio" name="optionsRadios1" value="option2" checked />                                                无                                            </label>                                        </div>                                    </div>                                    <div class="modal hide">                                        <div class="modal-header">                                            请填写对应的解决方案：                                        </div>                                        <div class="modal-body">                                            <div class="controls">                                                <textarea class="span6 m-wrap" name="bugAnswer" rows="3"></textarea>                                            </div>                                        </div>                                        <div class="modal-footer">                                            <div class="controls">                                                <button type="button" id="sure" >确定</button>                                                <button type="button" id="reset">重置</button>                                            </div>                                            如无解决方案，可找到解决方式后再补充                                        </div>                                    </div>                                    <div class="form-actions">                                        <button type="submit" class="btn blue">Submit</button>                                        <button type="button" class="btn">Cancel</button>                                    </div>                                </form>                                <!-- END FORM-->                            </div>                        </div>                        <!-- END SAMPLE FORM PORTLET-->                    </div>                </div>                <!-- END PAGE CONTENT-->			</div>			<!-- END PAGE CONTAINER-->		</div>		<!-- END PAGE -->  	</div>	<!-- END CONTAINER -->	<!-- BEGIN FOOTER -->    <%@include file="../includes/footer_up.jsp" %>	<!-- END FOOTER -->    <%@include file="../includes/jquerycore.jsp"%>    <script type="text/javascript" src="<c:url value="/static/js/bower_components/select2/select2.min.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/js/bower_components/select2/select2_locale_zh-CN.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/media/js/chosen.jquery.min.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/media/js/form-components.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/media/js/jquery.multi-select.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/ckeditor/ckeditor.js"/>"></script>    <script type="text/javascript" src="<c:url value="/static/ckeditor/config.js"/>"></script>    <script type="application/javascript">        $(document).ready(function(){           $(".select2-choices").select2();            FormComponents.init();            CKEDITOR.replace('consoleError');            CKEDITOR.replace('bugCode');            $(".modal").hide();        });        $("#hasSolveMethod").click(function(){            CKEDITOR.replace('bugAnswer');            $(".modal").show();        });        $("#reset").click(function(){            CKEDITOR.instances.bugAnswer.setData('');   //清空解决方案        });        $("#sure").click(function(){            $(".modal").hide();  //关闭模态窗口        });    </script>    <!-- END JAVASCRIPTS -->    </body><!-- END BODY --></html>