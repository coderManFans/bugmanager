
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--<![endif]-->
<head>
    <title>bug类型</title>
    <%@include file="../../jsp/includes/head.jsp" %>
</head>
<body>
<div class="container" >
    <form class="form-view form-horizontal" id="submitBugContent" action="<c:url value="/buginfo/bugcontent/add"/>" method="post">
        <div class="control-group error">
            <label class="control-label">选择错误类型</label>
            <div class="controls">
                <select id="bugTypeSelect" name="bugIdList" class="chosen span6" multiple="multiple" tabindex="6">
                    <c:forEach items="${bugTypeList}" var="bugType">
                        <option value="${bugType.bugTypeId}">${bugType.bugType}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="control-group error">
            <label class="control-label">选择错误标签</label>
            <input type="hidden" id="12345">
            <div class="controls">
                <select id="tagTypeSelect" name="tagIdList" data-placeholder="the bug tag" class="chosen span6 chzn-select" multiple="multiple" tabindex="6">
                        <c:forEach items="${tagTypeList}" var="tagType">
                            <option value="${tagType.tagId}">${tagType.tagName}</option>
                        </c:forEach>
                </select>
            </div>
        </div>


        <div class="control-group error" id="tagform">
            <label  class="control-label"> 错误描述:</label>
           <textarea name="bugReason" id="bugReasonId" class="form-horizontal" rows="8" placeholder="错误描述"></textarea><br />
        </div>

        <div class="control-group error">
            <label  class="control-label"> 出错代码段：</label>
            <div class="controls">
                <textarea name="bugCode" id="bugCodeId" class="form-horizontal" rows="8" cols="20" placeholder="错误代码段"></textarea><br/>
            </div>
        </div>

        <div class="control-group error">
            <label  class="control-label"> 控制台主要异常:</label>
            <div class="controls">
                <textarea class="ckeditors" id="consoleErrorId" name="consoleError" class="form-horizontal" rows="8" cols="60"></textarea>
            </div>
        </div>

        <div class="control-group ">
            <label  class="control-label">解决方案：</label>
            <div class="controls">
                <div data-toggle="buttons-radio" class="btn-group">
                    <button class="btn btn-primary" value="0" name="hasSolved" type="button">没有</button>
                    <button class="btn btn-primary" value="1" name="hasSolved" type="button" data-toggle="modal" data-target="#answerModal">一个</button>

                </div>
            </div>
        </div>

        <!--modal anwser-->
        <div class="modal fade" id="answerModal" tabindex="-1" role="dialog" aria-labelledby="answerModalBody"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="true" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="modalAnswerTitle">
                                添加解决方案
                            </h4>
                        </div>
                        <div class="modal-body">
                           <textarea name="bugAnswer" id="bugAnswerId" class="form-control" rows="3" placeholder="解决方案"></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary">提交</button>
                        </div>
                    </div>
                </div>
        </div>

        <button type="button" id="submitBtn" class="btn blue pull-right"><i class="m-icon-swapright m-icon-white"></i></button>
    </form>
</div>
<%@include file="../../jsp/includes/bottomscript.jsp"%>
<!-- END PAGE LEVEL SCRIPTS -->

<script type="text/javascript" src="<c:url value="/static/js/system/bugcontent/bugcontent.js"/>"></script>

<script>
    $(function() {
        var editor = null;
        window.onload= function(){
            editor = CKEDITOR.replace("consoleError");
        }

        bugtagList.init();

        App.init();
        FormComponents.init();
        $(".chosen").chosen();
    });
</script>
</body>
</html>
