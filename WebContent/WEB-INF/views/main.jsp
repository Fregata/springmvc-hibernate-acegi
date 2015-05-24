<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value='/img/ico.png'/>">

    <title>特警支队情报信息系统</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/dashboard.css'/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<c:url value='/js/ie-emulation-modes-warning.js'/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	<%@ include file="header.jsp"%>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/user/main.html"><i class="icon-tasks"></i> 全部功能</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/user/info.html"><i class="icon-search"></i> 情报查询</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/input.html"><i class="icon-edit"></i> 情报录入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/data.html"><i class="icon-signin"></i> 数据导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">功能介绍</h1>
			<div class="panel panel-success">
			  <div class="panel-heading"><strong>情报查询</strong></div>
			  <div class="panel-body">
			      <div class="row row-offcanvas row-offcanvas-center">
			     		<p> 情报查询</p>
			      </div>
		      </div>
			 </div>
			 
			 <div class="panel panel-success">
			  <div class="panel-heading"><strong>情报导入</strong></div>
			  <div class="panel-body">
			      <div class="row row-offcanvas row-offcanvas-center">
			     		<p>数据导入</p>
			      </div>
		      </div>
			 </div>
			 
			 <div class="panel panel-success">
			  <div class="panel-heading"><strong>系统管理</strong></div>
			  <div class="panel-body">
			      <div class="row row-offcanvas row-offcanvas-center">
			     		<p>系统管理</p>
			      </div>
		      </div>
			 </div>
		 
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="<c:url value='/js/holder.js'/>"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value='/js/ie10-viewport-bug-workaround.js'/>"></script>
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
		});
	</script>
  </body>
</html>
