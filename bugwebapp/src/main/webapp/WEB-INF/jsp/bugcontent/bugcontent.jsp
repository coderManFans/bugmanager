
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bug类型</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap.min.css"/>">

    <link href="<c:url value="/static/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/static/css/style-metro.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/static/css/style-responsive.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/static/css/default.css"/>" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="<c:url value="/static/css/uniform.default.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/chosen.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/select2_metro.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/jquery.tagsinput.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/multi-select-metro.css"/>" />
</head>
<body>
<div class="container control-group" >
    <form class="form-actions form-horizontal" action="<c:url value="/buginfo/bugcontent/add"/>" method="post">
        <div class="control-group">
            <label class="control-label">选择错误类型</label>
            <div class="controls">
                <select id="bugTypeSelect" data-placeholder="Your Favorite Football Teams" class="chosen span6" multiple="multiple" tabindex="6">
                    <option value=""></option>
                        <option>Dallas Cowboys</option>
                        <option>New York Giants</option>
                        <option>Philadelphia Eagles</option>
                        <option>Washington Redskins</option>
                        <option selected>Chicago Bears</option>
                        <option>Detroit Lions</option>
                        <option>Green Bay Packers</option>
                        <option>Minnesota Vikings</option>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label">选择错误标签</label>
            <div class="controls">
                <select id="bugTypeSelect" data-placeholder="Your Favorite Football Teams" class="chosen span6" multiple="multiple" tabindex="6">
                    <option value=""></option>
                    <option>Dallas Cowboys</option>
                    <option>New York Giants</option>
                    <option>Philadelphia Eagles</option>
                    <option>Washington Redskins</option>
                    <option selected>Chicago Bears</option>
                    <option>Detroit Lions</option>
                    <option>Green Bay Packers</option>
                    <option>Minnesota Vikings</option>
                </select>
            </div>
        </div>

        <div class="control-group" id="tagform">
            <label  class="control-label"> 错误描述:</label>
           <textarea name="bugReason" class="form-horizontal" rows="8" placeholder="错误描述"></textarea><br />
        </div>

        <div class="control-group">
            <label  class="control-label"> 出错代码段：</label>
            <div class="controls">
                <textarea name="bugCode" class="form-horizontal" rows="8" cols="20" placeholder="错误代码段"></textarea><br/>
            </div>
        </div>
        <div class="control-group">
            <label  class="control-label"> 控制台主要异常:</label>
            <div class="controls">
                <textarea class="ckeditors" name="consoleError" class="form-horizontal" rows="8" cols="60"></textarea>
            </div>
        </div>
        <div class="control-group">
            <label  class="control-label">解决方案：</label>
            <div class="controls">
                <div data-toggle="buttons-radio" class="btn-group">
                    <button class="btn btn-primary" value="0" name="hasSolved" type="button">没有</button>
                    <button class="btn btn-primary" value="1" name="hasSolved" type="button">一个</button>
                    <button class="btn btn-primary" value="1" name="hasSolved" type="button">多个</button>
                </div>
            </div>
        </div>
        <button id="btnsubmit" class="btn btn-success" type="submit" value="提交" ></button>
    </form>
</div>
<script  type="application/javascript" src="<c:url value="/static/js/jquery-2.0.0.min.js"/> "></script>
<script type="application/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/static/js/system/bugcontent/bugcontent.js"/>"></script>

<script src="<c:url value="/static/js/jquery-migrate-1.2.1.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery-ui-1.10.1.custom.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery.slimscroll.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/static/js/jquery.blockui.min.js"/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/static/js/chosen.jquery.min.js"/>"  ></script>
<script type="text/javascript" src="<c:url value="/static/js/select2.min.js"/>" ></script>

<script type="text/javascript" src="<c:url value="/static/js/jquery.tagsinput.min.js"/>" ></script>

<script type="text/javascript" src="<c:url value="/static/js/jquery.inputmask.bundle.min.js"/> "></script>

<script type="text/javascript" src="<c:url value="/static/js/jquery.multi-select.js"/> "></script>
<script type="text/javascript" src="<c:url value="/static/js/form-components.js"/> "></script>

<script src="<c:url value="/static/js/app.js"/> "></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function() {
        // initiate layout and plugins
        App.init();
        FormComponents.init();
    });

    $(function(){
        bugtagList.init();
    });
</script>
</body>
</html>
