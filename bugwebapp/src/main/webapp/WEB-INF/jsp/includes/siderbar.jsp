<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-sidebar nav-collapse collapse">

    <!-- BEGIN SIDEBAR MENU -->

    <ul class="page-sidebar-menu">

        <li>

            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

            <div class="sidebar-toggler hidden-phone"></div>

            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

        </li>

        <li>

            <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

            <form class="sidebar-search">

                <div class="input-box">

                    <a href="javascript:;" class="remove"></a>

                    <input type="text" placeholder="Search..." />

                    <input type="button" class="submit" value=" " />

                </div>

            </form>

            <!-- END RESPONSIVE QUICK SEARCH FORM -->

        </li>

        <li class="start active ">

            <a href="index.jsp">

                <i class="icon-home"></i>

                <span class="title">本周统计</span>

                <span class="selected"></span>

            </a>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-cogs"></i>

                <span class="title">异常管理</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="/tags/tagtype"/>">

                        标签管理</a>

                </li>

                <li >

                    <a href="<c:url value="/tags/bugtype"/>">

                        类型管理</a>

                </li>

                <li >

                    <a href="<c:url value="/buginfo/bugcontent"/>">

                        错误管理</a>

                </li>

                <li >

                    <a href="#">

                        答案管理</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        上传错误日志</a>

                </li>

                <li >

                    <a href="layout_ajax.jsp">

                        查看所有</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Sidebar Closed Page</a>

                </li>

                <li >

                    <a href="#">

                        Blank Page</a>

                </li>

                <li >

                    <a href="#">

                        Boxed Page</a>

                </li>

                <li >

                    <a href="#">

                        Non-Responsive Boxed Layout</a>

                </li>

            </ul>

        </li>

        <li class="" id="userManager">

            <a href="javascript:;">

                <i class="icon-bookmark-empty"></i>

                <span class="title">用户管理</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="#"/>">

                        General</a>

                </li>

                <li >

                    <a href="#">

                        Buttons</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Enhanced Modals</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Tabs & Accordions</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        jQuery UI Components</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Sliders</a>

                </li>

                <li >

                    <a href="#">

                        Tiles</a>

                </li>

                <li >

                    <a href="#">

                        Typography</a>

                </li>

                <li >

                    <a href="#">

                        Tree View</a>

                </li>

                <li >

                    <a href="#">

                        Nestable List</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-table"></i>

                <span class="title">面试笔记</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="#">

                        Form Layouts</a>

                </li>

                <li >

                    <a href="#">

                        Advance Form Samples</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Form Components</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Form Wizard</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Form Validation</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Multiple File Upload</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Dropzone File Upload</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-briefcase"></i>

                <span class="title">博客管理</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="#"/>">

                        <i class="icon-time"></i>

                        Timeline</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        <i class="icon-cogs"></i>

                        Coming Soon</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        <i class="icon-comments"></i>

                        Blog</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        <i class="icon-font"></i>

                        Blog Post</a>

                </li>

                <li >

                    <a href="#">

                        <i class="icon-coffee"></i>

                        News</a>

                </li>

                <li >

                    <a href="#">

                        <i class="icon-bell"></i>

                        News View</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        <i class="icon-group"></i>

                        About Us</a>

                </li>

                <li >

                    <a href="#">

                        <i class="icon-envelope-alt"></i>

                        Contact Us</a>

                </li>

                <li >

                    <a href="#">

                        <i class="icon-calendar"></i>

                        Calendar</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-gift"></i>

                <span class="title">附加功能</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="#"/>">

                        User Profile</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Lock Screen</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        FAQ</a>

                </li>

                <li >

                    <a href="#">

                        Inbox</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Search Results</a>

                </li>

                <li >

                    <a href="#">

                        Invoice</a>

                </li>

                <li >

                    <a href="#">

                        Pricing Tables</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Image Manager</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        404 Page Option 1</a>

                </li>

                <li >

                    <a href="<c:url value="../error/err404.jsp"/>">

                        404 Page Option 2</a>

                </li>

                <li >

                    <a href="#">

                        404 Page Option 3</a>

                </li>

                <li >

                    <a href="<c:url value="../error/err500.jsp"/>">

                        500 Page Option 1</a>

                </li>

                <li >

                    <a href="<c:url value="../error/err403.jsp"/>">

                        503 Page Option 2</a>

                </li>

            </ul>

        </li>

        <li>

            <a class="active" href="javascript:;">

                <i class="icon-sitemap"></i>

                <span class="title">项目管理</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li>

                    <a href="javascript:;">

                        Item 1

                        <span class="arrow"></span>

                    </a>

                    <ul class="sub-menu">

                        <li><a href="#">Sample Link 1</a></li>

                        <li><a href="#">Sample Link 2</a></li>

                        <li><a href="#">Sample Link 3</a></li>

                    </ul>

                </li>

                <li>

                    <a href="javascript:;">

                        Item 1

                        <span class="arrow"></span>

                    </a>

                    <ul class="sub-menu">

                        <li><a href="#">Sample Link 1</a></li>

                        <li><a href="#">Sample Link 1</a></li>

                        <li><a href="#">Sample Link 1</a></li>

                    </ul>

                </li>

                <li>

                    <a href="#">

                        Item 3

                    </a>

                </li>

            </ul>

        </li>

        <li>

            <a href="javascript:;">

                <i class="icon-folder-open"></i>

                <span class="title">4 Level Menu</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li>

                    <a href="javascript:;">

                        <i class="icon-cogs"></i>

                        Item 1

                        <span class="arrow"></span>

                    </a>

                    <ul class="sub-menu">

                        <li>

                            <a href="javascript:;">

                                <i class="icon-user"></i>

                                Sample Link 1

                                <span class="arrow"></span>

                            </a>

                            <ul class="sub-menu">

                                <li><a href="#"><i class="icon-remove"></i> Sample Link 1</a></li>

                                <li><a href="#"><i class="icon-pencil"></i> Sample Link 1</a></li>

                                <li><a href="#"><i class="icon-edit"></i> Sample Link 1</a></li>

                            </ul>

                        </li>

                        <li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>

                        <li><a href="#"><i class="icon-external-link"></i>  Sample Link 2</a></li>

                        <li><a href="#"><i class="icon-bell"></i>  Sample Link 3</a></li>

                    </ul>

                </li>

                <li>

                    <a href="javascript:;">

                        <i class="icon-globe"></i>

                        Item 2

                        <span class="arrow"></span>

                    </a>

                    <ul class="sub-menu">

                        <li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li>

                        <li><a href="#"><i class="icon-external-link"></i>  Sample Link 1</a></li>

                        <li><a href="#"><i class="icon-bell"></i>  Sample Link 1</a></li>

                    </ul>

                </li>

                <li>

                    <a href="#">

                        <i class="icon-folder-open"></i>

                        Item 3

                    </a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-user"></i>

                <span class="title">Login Options</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="../login.jsp"/>">

                        Login Form 1</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Login Form 2</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-th"></i>

                <span class="title">Data Tables</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="#">

                        Basic Tables</a>

                </li>

                <li >

                    <a href="#">

                        Responsive Tables</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Managed Tables</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Editable Tables</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Advanced Tables</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-file-text"></i>

                <span class="title">Portlets</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="<c:url value="#"/>">

                        General Portlets</a>

                </li>

                <li >

                    <a href="<c:url value="#"/>">

                        Draggable Portlets</a>

                </li>

            </ul>

        </li>

        <li class="">

            <a href="javascript:;">

                <i class="icon-map-marker"></i>

                <span class="title">Maps</span>

                <span class="arrow "></span>

            </a>

            <ul class="sub-menu">

                <li >

                    <a href="#">

                        Google Maps</a>

                </li>

                <li >

                    <a href="#">

                        Vector Maps</a>

                </li>

            </ul>

        </li>

        <li class="last ">

            <a href="<c:url value="#"/>">

                <i class="icon-bar-chart"></i>

                <span class="title">访问统计</span>

            </a>

        </li>

    </ul>

    <!-- END SIDEBAR MENU -->

</div>
<script src="<c:url value="/static/media/js/jquery-1.10.1.min.js"/>" type="text/javascript"></script>

<script type="application/javascript">
    <!--动态绑定点击事件-->
    $(function(){
        var lilength = $("ul>li").length;
       $("ul>li").bind({
           click:function(){
               $(this).addClass("active");
               for(var i = 0;i < lilength;i ++){
                   if($("li:eq("+i+")").is($(this))){
                      continue;
                   }
                   $("li:eq("+i+")").removeClass("active");
               }
           }

       })
    });
</script>