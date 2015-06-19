
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <title>Metronic | Form Stuff - Form Validation</title>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <%@include file="../includes/globalcss.jsp" %>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/static/js/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>"/>
    <link href="<c:url value="/static/media/css/bootstrap-modal.css"/>" rel="stylesheet" type="text/css"/>

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
                                <span class="help-inline">${bugcontent.addDate}</span>
                            </div>
                        </div>
                        <div class="control-group">
                                <label class="control-label">控制台错误:</label>
                                <div class="controls">
                                    <span class="help-inline">${bugcontent.consoleError}</span>
                                </div>
                        </div>
                        <div class="control-group hide" hidden="hidden" id="tagsid${bugcontent.bugcontentid}">
                            <label class="control-label">错误类型和标签:</label>
                            <div class="controls">
                                <span class="help-inline">
                                </span>
                            </div>
                        </div>
                        <div class="form-actions">
                            <button type="button" class="btn blue" id="update" data-toggle="modal" href="#responsive" onclick="getUpdate('${bugcontent.bugcontentid}')" >修改</button>
                            <button type="button" class="btn" id="delete" onclick="getDelete('${bugcontent.bugcontentid}')">删除</button>
                            <button type="button" class="btn" id="getTag" onclick="getTagInfo('${bugcontent.bugcontentid}')">显示标签</button>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END SAMPLE FORM PORTLET-->
        </div>
    </div>
</c:forEach>
            <div id="responsive" class="modal hide fade modal_wrapper modal-dialog" tabindex="-1" data-width="760">

                <div class="modal-header">

                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

                    <h3>修改错误信息</h3>

                </div>

                <div class="modal-body">
                    <div class="row-fluid">
                        <div class="span6">
                            <h4>填写信息</h4>

                            <input type="hidden" id="updatebugcontentid" name="bugcontentid" class="span12 m-wrap">
                            <p>错误原因:<input type="text" id="updatebugReasonid" name="bugReason" class="span12 m-wrap"></p>

                            <p>解决方案:
                                <input type="text" id="updatehasSolvedid" name="hasSolved" class="span12 m-wrap">
                            </p>
                        </div>

                    </div>

                </div>

                <div class="modal-footer">

                    <button type="button" data-dismiss="modal" class="btn">Close</button>

                    <button type="button" class="btn blue">Save changes</button>

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
<script src="<c:url value="/static/media/js/bootstrap-modal.js"/>" type="text/javascript" ></script>

<script src="<c:url value="/static/media/js/bootstrap-modalmanager.js"/>" type="text/javascript" ></script>

<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="<c:url value="/static/media/js/ui-modals.js"/>" type="application/javascript"></script>
<script type="text/javascript" language="JavaScript">

    jQuery(document).ready(function(){
       UIModals.init();
    });

    function getUpdate(bugcontentid){
        alert(bugcontentid+"-----");
        $("#updatebugcontentid").attr("value","");
        $("#updatebugReasonid").attr("value","");
        $.ajax({
            url: "bugcontroller/bugcontr/"+bugcontentid,
            type: "POST",
            data: JSON.stringify(bugcontentid),
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                if(data != null){
                    $("#updatebugcontentid").attr("value",data[2]);
                    $("#updatehasSolvedid").attr("value",data[1]);
                    $("#updatebugReasonid").attr("value",data[3]);
                }
            }
        });
    }
    function getDelete(bugcontentid){
        $.ajax({
            url: "bugcontroller/bugcontr/"+bugcontentid,
            type: "DELETE",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                if(data!= null){
                    alert(data+"===========");
                }
            }

        })
    }
    function getTagInfo(bugcontentid){
        $.ajax({
            url: "bugcontroller/bugcontr/gettags/"+bugcontentid,
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function(data){
                if(data!= null){
                    if(data.bugtype == "true"){
                        alert(data+"==========="+data.bugTypeList[0].bugType);
                        alert(data+"==========="+data.tagTypeList[0].tagName);
                         var x = $("#tagsid"+bugcontentid+ " div span");
                        var bugtypestr = '错误类型： ';
                        for(var i =0 ;i <data.bugTypeList.length;i ++ ){
                            bugtypestr+=(data.bugTypeList[i].bugType+',');
                        }
                        bugtypestr+='<br />错误标签： ';
                        for(var i =0 ;i <data.tagTypeList.length;i ++ ){
                            bugtypestr+=(data.tagTypeList[i].tagName+',');
                        }
                        x.html(bugtypestr);
                        $("#tagsid"+bugcontentid).removeProp("hidden");
                        $("#tagsid"+bugcontentid).show();
                    }else{
                        alert("该错误没标签。。。。");
                    }
                }else{
                    alert("抱歉该错误没有添加标签。。。。");
                }
            }

        })
    }

</script>

<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->

</html>