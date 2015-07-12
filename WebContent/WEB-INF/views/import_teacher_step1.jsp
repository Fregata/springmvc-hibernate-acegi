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
            <li><a href="${ctx}/super/subject/step1.html"><i class="icon-edit"></i> 教学科目信息创建</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/super/teacher/step1.html"><i class="icon-signin"></i> 教师信息导入<span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/student/step1.html"><i class="icon-signin"></i> 学生信息导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">教师信息导入</h1>
			<div id="sch-step1" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:120px;display:inline"><font color="red"><strong>1.数据上传</strong></font></li>
					<li style="padding-left:120px;display:inline">2.数据验证</li>
			 		<li style="padding-left:120px;display:inline">3.确认</li>
				  </ol>
			  </div>
			  <div class="panel-body">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form class="form-horizontal" role="form">
                    <div class="col-sm-4 col-sm-offset-2">
			        <div class="control-group" class="col-sm-4 col-sm-offset-2">
			          <label class="control-label" for="input01">教师信息模板下载</label>
			          <div class="controls">
			            <select name="school" id="school" style="width:200px">
							<option value="" selected="selected">请选择学校</option>
							<c:forEach items="${SCHOOLS}" var="item">
								<option value="${item.schoolRoll.id}">${item.name}</option>
							</c:forEach>
						</select>
			          </div>
			        </div>
			        </div>
                 </form>
                 <form id="teacher-step2-form" action="${ctx}/super/teacher/step2.html" class="form-horizontal" enctype="multipart/form-data" method="POST">
                    <div class="col-sm-6">
			        <div class="control-group" class="col-sm-6">
			          <label class="control-label" for="input01">教师信息数据上传</label>
			          <div class="controls">
			            <input name="teacherData" type="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
			          </div>
			        </div>
			        </div>
                 </form>
		      </div>
		      </div>
		      <div class="panel-footer">
			  <form class="form-horizontal">
				  <div class="form-group" style="margin-bottom:0px">
	                   <div class="col-sm-6 col-sm-offset-5">
                           <div class="btn-group" role="group" aria-label="...">
			              	  <button type="button" class="btn btn-success" onclick="next('teacher-step2-form')">下一步</button>
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
    <script src="<c:url value='/js/business.js'/>"></script>
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
		});
		var school = document.getElementById('school');
		//change school
		school.onchange = function() {
			var url = "${ctx}/super/teacher/"+school.value;
			window.open(url);
		};
	</script>
  </body>
</html>
