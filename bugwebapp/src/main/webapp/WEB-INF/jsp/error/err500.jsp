<!DOCTYPE html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ page contentType="text/html;charset=UTF-8" language="java" %><!--[if !IE]><!--> <html lang="en"> <!--<![endif]--><!-- BEGIN HEAD --><head>	<title>Metronic | Extra - 500 Page Option 1</title>	<!-- BEGIN GLOBAL MANDATORY STYLES -->    <%@include file="../includes/headcss.jsp" %>	<!-- END GLOBAL MANDATORY STYLES -->	<!-- BEGIN PAGE LEVEL STYLES -->	<link href="<c:url value="/static/media/css/error.css"/>" rel="stylesheet" type="text/css"/>	<!-- END PAGE LEVEL STYLES --></head><!-- END HEAD --><!-- BEGIN BODY --><body class="page-header-fixed">	<!-- BEGIN HEADER -->    <%@include file="../includes/head.jsp"%>	<!-- END HEADER -->	<!-- BEGIN CONTAINER -->	<div class="page-container row-fluid">		<!-- BEGIN SIDEBAR -->		<div class="page-sidebar nav-collapse collapse">			<!-- BEGIN SIDEBAR MENU -->                    <%@include file="../includes/siderbar.jsp" %>			<!-- END SIDEBAR MENU -->		</div>		<!-- END SIDEBAR -->		<!-- BEGIN PAGE -->		<div class="page-content">			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->            <%@include file="../includes/sampleportlet.jsp" %>			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->			<div class="container-fluid">				<!-- BEGIN PAGE HEADER-->                <%@include file="../includes/page_header.jsp" %>				<!-- END PAGE HEADER-->				<!-- BEGIN PAGE CONTENT-->          				<div class="row-fluid">					<div class="span12 page-500">						<div class=" number">							500						</div>						<div class=" details">							<h3>Opps, Something went wrong.</h3>							<p>								We are fixing it!<br />								Please come back in a while.<br /><br />							</p>						</div>					</div>				</div>				<!-- END PAGE CONTENT-->			</div>			<!-- END PAGE CONTAINER-->       		</div>		<!-- BEGIN PAGE -->     	</div>	<!-- END CONTAINER -->	<!-- BEGIN FOOTER -->    <%@include file="../includes/footer_up.jsp" %>	<!-- END FOOTER -->	<%@include file="../includes/jquerycore.jsp" %>	<!-- END CORE PLUGINS -->	<script>		jQuery(document).ready(function() {    		   App.init();		});	</script>	<!-- END JAVASCRIPTS --><script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body><!-- END BODY --></html>