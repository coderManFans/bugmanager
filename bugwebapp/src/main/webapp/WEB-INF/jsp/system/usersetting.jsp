
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户设置</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/media/css/bootstrap-fileupload.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/main.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/demos.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/static/Jcrop/css/jquery.Jcrop.min.css"/>" type="text/css" />

</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand">bugCollection</a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav">
                                <li class="active">
                                    <a href="#">项目主页</a>
                                </li>
                                <li>
                                    <a href="#">bug库</a>
                                </li>
                                <li>
                                    <a href="#">bug标签</a>
                                </li>
                                <li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">我的bug库<strong class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="<c:url value="/tag/bugtype"/>">添加bug类型</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/tag/tagtype"/>">添加bug标签</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/buginfo/bugcontent/toadd"/>">添加bug内容</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li class="nav-header">
                                            标签
                                        </li>
                                        <li>
                                            <a href="#">显示bug类型列表</a>
                                        </li>
                                        <li>
                                            <a href="#">显示bug标签列表</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav pull-right">
                                <li>
                                    <a href="#">${user.userName}</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/login"/>">登陆</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/user/toregiste"/>">注册</a>
                                </li>
                                <li class="divider-vertical">
                                </li>
                                <li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">下拉菜单<strong class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#">添加bug库</a>
                                        </li>
                                        <li>
                                            <a href="#">下拉导航2</a>
                                        </li>
                                        <li>
                                            <a href="#">我的bug库</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="<c:url value="/user/${user.userName}"/>">个人设置</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>

            </div>


            <div class="accordion" id="accordion-730119">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion-730119" href="#accordion-element-911868">我的头像</a>
                    </div>
                    <div id="accordion-element-911868" class="accordion-body collapse">
                        <div class="accordion-inner">

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
                        </div>
                    </div>
                </div>


                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-730119" href="#accordion-element-782026">修改密码</a>
                    </div>
                    <div id="accordion-element-782026" class="accordion-body in collapse">
                        <div class="accordion-inner">
                           <form class="form-horizontal" role="form">
                               <div class="form-group">
                                   <label class="col-sm-2 control-label">当前密码:</label>
                                   <div class="col-sm-10">
                                       <input class="form-control" type="password" placeholder="password">
                                   </div>
                               </div>

                               <div class="form-group">
                                   <label class="col-sm-2 control-label">新密码:</label>
                                   <div class="col-sm-10">
                                       <input class="form-control" type="password" placeholder="new password">
                                   </div>
                               </div>

                               <div class="form-group">
                                   <label class="col-sm-2 control-label">确认密码:</label>
                                   <div class="col-sm-10">
                                       <input class="form-control" type="password" placeholder="new password">
                                   </div>
                               </div>

                               <div class="form-group">
                                   <div class="col-sm-10">
                                        <button type="button" class="btn btn-success">保存</button>
                                   </div>
                               </div>
                           </form>

                        </div>
                    </div>
                </div>


                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-730119" href="#accordion-element-782026">账号管理</a>
                    </div>
                    <div id="accordion-element-782236" class="accordion-body in collapse">
                        <div class="accordion-inner">
                            <form>
                                <fieldset>
                                    <legend>表单项</legend> <label>表签名</label><input type="text" /> <span class="help-block">这里填写帮助信息.</span> <label class="checkbox"><input type="checkbox" /> 勾选同意</label> <button type="submit" class="btn">提交</button>
                                </fieldset>
                            </form>
                            <form>
                                <fieldset>
                                    <legend>表单项</legend> <label>表签名</label><input type="text" /> <span class="help-block">这里填写帮助信息.</span> <label class="checkbox"><input type="checkbox" /> 勾选同意</label> <button type="submit" class="btn">提交</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-730119" href="#accordion-element-782026">动态设置</a>
                    </div>
                    <div id="accordion-element-782346" class="accordion-body in collapse">
                        <div class="accordion-inner">
                            功能块...
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>



<!--注意先引入jQuery然后再引入bootstrap-->
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
