
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
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
                                            <a href="#">个人设置</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>

            </div>

            <form class="form-search">
                <input class="input-medium search-query" type="text">
                <button type="submit" class="btn">查找</button>
            </form>

            <div class="hero-unit">
                <h1>
                    Hello, bug!!!
                </h1>
                <p>
                    这是一个Java web版的bug收集系统，可以添加自己的bug仓库，可以添加bug类型，标签，搜索别人曾经犯过的错误，提高自己的编程效率和
                    实战经验，第一版本中我们提供简单的网站操作功能，后续会进一步的添加和完善，讨论功能，导出博客，导出错误笔记等，敬请期待。
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">了解更多 ?</a>
                </p>
            </div>
            <div class="right-col">
                <div class="pinned note-container">
                    <div class="note">
                        <h3>Pin it!</h3>
                        <p>Great for pinned navigations — or just about anything you want to stick.</p>
                        <p>Developed by <a href="http://www.webpop.com">Webpop</a>.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<%@include file="../jsp/includes/bottom.jsp"%>
<%@include file="../jsp/includes/bottomscript.jsp"%>

</body>
</html>
