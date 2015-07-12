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
    <link href="<c:url value='/css/business.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/jquery.treegrid.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/dashboard.css'/>" rel="stylesheet">

    <script src="<c:url value='/js/ie-emulation-modes-warning.js'/>"></script>
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
            <li class="active">
              <a href="${ctx}/super/profile/step1.html"><i class="icon-search"></i> 学校基础信息创建<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/subject/step1.html"><i class="icon-edit"></i> 教学科目信息创建</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/import-teacher.html"><i class="icon-signin"></i> 教师信息导入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/import-student.html"><i class="icon-signin"></i> 学生信息导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">学校基础信息创建</h1>
          	<c:if test="${not empty ERROR}">
	          	<div class="alert alert-warning" role="alert">
			      <strong>异常信息:</strong> ${ERROR}
			    </div>
          	</c:if>
			<div id="sch-step2" class="panel panel-success">
			  <div class="panel-heading">
			  		<ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:180px;display:inline">1.学校信息设置</li>
					<li style="padding-left:180px;display:inline"><font color="red"><strong>2.确认</strong></font></li>
				  </ol>
			  </div>
			  <div class="panel-body">
			      <div class="row row-offcanvas row-offcanvas-center" style="overflow:auto;height:350px">
			      <div class="table-responsive">
		          <table class="table table-hover table-bordered">
		            <thead>
		             <tr>
		               <th>名称</th>
		               <th>信息</th>
		             </tr>
		            </thead>
		            <tbody>
		               <tr>
		                 <td>学校代码</td>
		                 <td>${schoolroll.code}</td>
		               </tr>
		               <tr>
		                 <td>学校名称</td>
		                 <td>${schoolroll.name}</td>
		               </tr>
		               <tr>
		                 <td>学校类型</td>
		                 <td>${schoolroll.type}</td>
		               </tr>
		               <tr>
		                 <td>学校属性</td>
		                 <td>${schoolroll.prop}</td>
		               </tr>
		               <tr>
		                 <td>学校等级</td>
		                 <td>${schoolroll.level}</td>
		               </tr>
		               <tr>
		                 <td>学校位置</td>
		                 <td>${geograph.name}</td>
		               </tr>
		               <tr>
		                 <td>学校详细地址</td>
		                 <td>${schoolroll.address}</td>
		               </tr>
		             </tbody>
	             </table>
	           </div>
		      <table class="table tree">
	                <tbody>
	                <c:forEach items="${gradeList}" var="item1" varStatus="status1">
		                <tr class="treegrid-${status1.count} treegrid-collapsed">
		                    <td><span class="treegrid-expander glyphicon glyphicon-chevron-down"></span>${item1.code}</td><td>${item1.name}</td>
		                </tr>
		                <c:forEach items="${item1.clzList}" var="item2" varStatus="status2">
		                <tr class="treegrid-${status1.count*100+status2.count} treegrid-parent-${status1.count}">
		                    <td><span class="treegrid-indent"></span><span class="treegrid-expander"></span>${item2.code}</td><td>${item2.name}</td>
		                </tr>
		                </c:forEach>
		            </c:forEach>
	            	</tbody>
	            </table>
		      </div>
			  </div>
		      <div class="panel-footer">
			  <form id="profile-step3-form" class="form-horizontal" method="POST" action="${ctx}/super/profile/step3.html">
				  <div class="form-group" style="margin-bottom:0px">
	                   <div class="col-sm-6 col-sm-offset-5">
                           <div class="btn-group" role="group" aria-label="...">
			              	  <button type="button" class="btn btn-danger" onclick="javascript:history.back(-1);">上一步</button>
			              	  <button type="button" class="btn btn-success" onclick="next('profile-step3-form')">完成</button>
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
    <script src="<c:url value='/js/jquery.treegrid.js'/>"></script>
    <script src="<c:url value='/js/jquery.treegrid.bootstrap3.js'/>"></script>
    <script src="<c:url value='/js/holder.js'/>"></script>
    <script src="<c:url value='/js/ie10-viewport-bug-workaround.js'/>"></script>
    <script src="<c:url value='/js/jquery.form.js'/>"></script>
    <script src="<c:url value='/js/business.js'/>"></script>
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
			$('.tree').treegrid();
		});
	</script>
  </body>
</html>
