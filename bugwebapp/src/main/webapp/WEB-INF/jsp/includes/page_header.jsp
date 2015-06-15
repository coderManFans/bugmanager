
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row-fluid">

    <div class="span12">

        <!-- BEGIN STYLE CUSTOMIZER -->

        <div class="color-panel hidden-phone">

            <div class="color-mode-icons icon-color"></div>

            <div class="color-mode-icons icon-color-close"></div>

            <div class="color-mode">

                <p>THEME COLOR</p>

                <ul class="inline">

                    <li class="color-black current color-default" data-style="default"></li>

                    <li class="color-blue" data-style="blue"></li>

                    <li class="color-brown" data-style="brown"></li>

                    <li class="color-purple" data-style="purple"></li>

                    <li class="color-grey" data-style="grey"></li>

                    <li class="color-white color-light" data-style="light"></li>

                </ul>

                <label>

                    <span>Layout</span>

                    <select class="layout-option m-wrap small">

                        <option value="fluid" selected="selected">Fluid</option>

                        <option value="boxed">Boxed</option>

                    </select>

                </label>

                <label>

                    <span>Header</span>

                    <select class="header-option m-wrap small">

                        <option value="fixed" selected>Fixed</option>

                        <option value="default">Default</option>

                    </select>

                </label>

                <label>

                    <span>Sidebar</span>

                    <select class="sidebar-option m-wrap small">

                        <option value="fixed">Fixed</option>

                        <option value="default" selected>Default</option>

                    </select>

                </label>

                <label>

                    <span>Footer</span>

                    <select class="footer-option m-wrap small">

                        <option value="fixed">Fixed</option>

                        <option value="default" selected>Default</option>

                    </select>

                </label>

            </div>

        </div>

        <!-- END BEGIN STYLE CUSTOMIZER -->

        <!-- BEGIN PAGE TITLE & BREADCRUMB-->

        <h3 class="page-title">

            Dashboard <small>statistics and more</small>

        </h3>

        <ul class="breadcrumb">

            <li>

                <i class="icon-home"></i>

                <a href="index.jsp">Home</a>

                <i class="icon-angle-right"></i>

            </li>

            <li><a href="#">Dashboard</a></li>

            <li class="pull-right no-text-shadow">

                <div id="dashboard-report-range" class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive" data-tablet="" data-desktop="tooltips" data-placement="top" data-original-title="Change dashboard date range">

                    <i class="icon-calendar"></i>

                    <span></span>

                    <i class="icon-angle-down"></i>

                </div>

            </li>

        </ul>

        <!-- END PAGE TITLE & BREADCRUMB-->

    </div>

</div>

