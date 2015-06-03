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
    <link href="<c:url value='/img/sz.ico'/>" rel="icon">
    <title>教学管理系统</title>

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
            <li><a href="${ctx}/user/main.html"><i class="icon-tasks"></i> 全部功能</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li>
              <a href="${ctx}/super/create-profile.html"><i class="icon-search"></i> 学校基础信息创建</a>
            </li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/create-subject.html"><i class="icon-edit"></i> 教学科目信息创建</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/import-teacher.html"><i class="icon-signin"></i> 教师信息导入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/super/import-student.html"><i class="icon-signin"></i> 学生信息导入<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">学生信息导入</h1>
			<div class="panel panel-success">
			  <div class="panel-body">
		      <div class="row row-offcanvas row-offcanvas-center">
		     	<div class="table-responsive">
		           <table class="table table-hover">
		             <thead>
		              <tr>
		                <th>序号</th>
		                <th>姓名</th>
		                <th>身份证号码</th>
		                <th>人员属性</th>
		                <th>盘查地点</th>
		                <th>盘查时间</th>
		                <th>出行方式</th>
		                <th>去向</th>
		                <th>查看</th>
		              </tr>
		             </thead>
		             <tbody>
		               <tr>
		                 <td>1</td>
		                 <td>黄晓明</td>
		                 <td>341277193403026728</td>
		                 <td>工作对象</td>
		                 <td>二环路</td>
		                 <td>2015-4-15</td>
		                 <td>私家车</td>
		                 <td>和田</td>
		                 <td><a href="#" data-toggle="collapse" data-target="">详情</a></td>
		               </tr>
		               <tr>
		                 <td>2</td>
		                 <td>黄晓明</td>
		                 <td>341277193403026728</td>
		                 <td>工作对象</td>
		                 <td>二环路</td>
		                 <td>2015-4-15</td>
		                 <td>私家车</td>
		                 <td>和田</td>
		                 <td><a href="#" data-toggle="collapse" data-target="">详情</a></td>
		               </tr>
		               <tr>
		                 <td>3</td>
		                 <td>黄晓明</td>
		                 <td>341277193403026728</td>
		                 <td>工作对象</td>
		                 <td>二环路</td>
		                 <td>2015-4-15</td>
		                 <td>私家车</td>
		                 <td>和田</td>
		                 <td><a href="#" data-toggle="collapse" data-target="">详情</a></td>
		               </tr>
		               <tr>
		                 <td>4</td>
		                 <td>黄晓明</td>
		                 <td>341277193403026728</td>
		                 <td>工作对象</td>
		                 <td>二环路</td>
		                 <td>2015-4-15</td>
		                 <td>私家车</td>
		                 <td>和田</td>
		                 <td><a href="#" data-toggle="collapse" data-target="">详情</a></td>
		               </tr>
		             </tbody>
		           </table>
		          </div>
		      </div>
		      </div>
		      <div class="panel-heading">
			  <form class="form-horizontal">
				  <div class="form-group">
	                   <div class="col-sm-6">
	                       <div class="input-group">
	                       <span class="input-group-addon">
	                           <i class="glyphicon glyphicon-filter"></i>
	                       </span>
	                           <input type="text" class="form-control" name="msg" autocomplete="off">
	                       </div>
	                   </div>
	                   <div class="col-sm-6">
                           <div class="btn-group" role="group" aria-label="...">
			              	  <button type="button" class="btn btn-success" onclick="">全文搜索</button>
			              	  <button type="button" class="btn btn-danger" onclick="">身份证查询</button>
			              	  <button type="button" class="btn btn-success" onclick="">姓名搜索</button>
						   </div>
                       </div>
	               </div>
			  </form>
			  </div>
			 </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
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
