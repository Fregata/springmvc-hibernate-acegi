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

    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/dashboard.css'/>" rel="stylesheet">
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
              <a href="${ctx}/super/profile/step1.html"><i class="icon-search"></i> 学校基础信息创建</a>
            </li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/super/subject/step1.html"><i class="icon-edit"></i> 教学科目信息创建<span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/import-teacher.html"><i class="icon-signin"></i> 教师信息导入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/import-student.html"><i class="icon-signin"></i> 学生信息导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">教学科目信息创建</h1>
          	<c:if test="${not empty ERROR}">
	          	<div class="alert alert-warning" role="alert">
			      <strong>异常信息:</strong> ${ERROR}
			    </div>
          	</c:if>
			<div id="sch-step1" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:120px;display:inline">1.年级选择</li>
					<li style="padding-left:120px;display:inline">2.科目信息设置</li>
			 		<li style="padding-left:120px;display:inline"><font color="red"><strong>3.确认</strong></font></li>
				  </ol>
			  </div>
			  <div class="panel-body">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form id="subject-step4-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/subject/step4.html">
	                <div class="table-responsive">
			          <table class="table table-hover table-bordered">
			            <thead>
			             <tr>
			               <th style='width:50%;'>名称</th>
			               <th style='width:50%;'>信息</th>
			             </tr>
			            </thead>
			            <tbody>
			               <tr>
			                 <td>学校名称</td>
			                 <td>${CHECKEDSCHOOL.name}</td>
			               </tr>
			             </tbody>
			            </table>
			            <table class="table table-hover table-bordered">
				            <thead>
				             <tr>
				               <th style='width:20%;'>年级</th>
				               <th>已选科目</th>
				             </tr>
				            </thead>
				            <tbody id='tbody'>
				            	<c:forEach items="${GRADES}" var="item1">
					               <tr>
					                 <td>${item1.name}</td>
					                 <td>
							         	<div style="font-size: 13px; font-family: Verdana;">
							         		<c:forEach items="${item1.subList}" var="item2">
							         			${item2.name},		
							         		</c:forEach>
							         	</div>
					                 </td>
					               </tr>
					            </c:forEach>
				             </tbody>
			             </table>
			         </div>
                 </form>
		      </div>
		      </div>
		      <div class="panel-footer">
			  <form class="form-horizontal">
				  <div class="form-group" style="margin-bottom:0px">
	                   <div class="col-sm-6 col-sm-offset-5">
                           <div class="btn-group" role="group" aria-label="...">
                           <button type="button" class="btn btn-danger" onclick="javascript:history.back(-1);">上一步</button>
			              	  <button type="button" class="btn btn-success" onclick="next('subject-step4-form')">完成</button>
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
    <script src="<c:url value='/js/holder.js'/>"></script>
    <script src="<c:url value='/js/ie10-viewport-bug-workaround.js'/>"></script>
    <script src="<c:url value='/js/jquery.form.js'/>"></script>
    <script src="<c:url value='/js/business.js'/>"></script>
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
		});
	</script>
  </body>
</html>
