<%--
  Created by IntelliJ IDEA.
  User: fcs
  Date: 2015/4/6
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/main.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/demos.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/jquery.Jcrop.min.css"/>" type="text/css" />
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span12">
            <div class="jc-demo-box">
                <div class="page-header">
                    <ul class="breadcrumb first">
                        <li><a href="<c:url value="../index.jsp"/>">首页</a> <span class="divider">/</span></li>
                        <li><a href="<c:url value="#"/>">用户设置</a> <span class="divider">/</span></li>
                        <li class="active">头像设置</li>
                    </ul>
                    <h1>请上传你的头像</h1>
                </div>

                <div class="row-fluid">
                    <div class="span9">
                        <div class="form-horizontal">
                            <form action= "<c:url value="/user/uploadPhoto"/>" method="post" enctype="multipart/form-data">
                                点击上传图片:<input type="file" name="photo" id="userPhoto" >
                                <button type="submit" value="上传" class="btn btn-success"/>
                            </form>
                        </div>

                        <div id="cutImage" class="control-group">
                            <div  class="bigImg">
                                <img id="srcImg" src="<c:url value="/static/uploadImage/${userPhoto}"/>" width="150px" height="150px" >
                            </div>
                            <div id="preview_box" class="previewImg">
                                <img id="previewImg" width="120px" >
                            </div>
                        </div>
                        <form action="" method="post" id="crop_form">
                            <input type="hidden" id="bigImage" name="bigImage">
                            <input type="hidden" id="x" nmae="x">
                            <input type="hidden" id="y" name="y">
                            <input type="hidden" id="w" name="w">
                            <input type="hidden" id="h" name="h">
                            <p><button type="submit" value="确认" id="crop_submit">确认</button> </p>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/static/js/jquery.min.js"/>" type="application/javascript"></script>
<script src="<c:url value="/static/Jcrop/js/jquery.Jcrop.min.js"/>" type="application/javascript"></script>
<script src="<c:url value="/static/Jcrop/js/jquery.color.js"/>" type="application/javascript"></script>
<script type="text/javascript">
    $(document).ready(function(){
        //裁剪图像
        $(function(){
            $("#srcImg").Jcrop({
                aspectRatio: 1,
                onChange: showCoords,
                onSelect: showCoords,
                minSize: [200,200]
            });
        });
        //简单的事件处理程序，响应自onChange,onSelect事件爱你，按照上面的Jcrop调用
        function showCoords(obj){
            $("#x").val(obj.x);
            $("#y").val(obj.y);
            $("#w").val(obj.w);
            $("#h").val(obj.h);

            if(parseInt(obj.w) > 0){
                //计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
                var rx = $("#preview_box").width() / obj.w;
                var ry = $("#preview_box").height() / obj.h;
                //通过比例值控制图片的样式与显示
                $("#previewImg").css({
                    width: Math.round(rx * $("#srcImg").width()) +"px",
                    height: Math.round(rx * $("#srcImg").height())+"px",
                    marginLeft: "-"+Math.round(rx * obj.x)+"px",
                    marginTop: "-"+Math.round(ry * obj.y)+"px"
                });
            };
        }
    });
</script>

</body>
</html>
