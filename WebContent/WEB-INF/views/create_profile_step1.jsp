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
            <li class="active">
              <a href="${ctx}/super/create-profile.html"><i class="icon-search"></i> 学校基础信息创建<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/create-subject.html"><i class="icon-edit"></i> 教学科目信息创建</a></li>
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
			<div id="sch-step1" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:90px;display:inline"><font color="red"><strong>1.学校信息设置</strong></font></li>
					<li style="padding-left:90px;display:inline">2.年级信息设置</li>
			 		<li style="padding-left:90px;display:inline">3.班级信息设置</li>
			 		<li style="padding-left:90px;display:inline">4.确认</li>
				  </ol>
			  </div>
			  <div class="panel-body">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form id="step1-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/profile/step1.html">
                     <div class="col-sm-6 col-sm-offset-2">
	                     <div class="control-group" class="col-sm-6 col-sm-offset-2">
				          <label class="control-label" for="input01">学校名称</label>
				          <div class="controls">
				            <input id="profile_name" name="profile_name" type="text" placeholder="" class="input-xlarge">
				            <p class="help-block">请输入学校的全称</p>
				          </div>
				         </div>
			        </div>
			        <div class="col-sm-8 col-sm-offset-2">
	                     <div class="control-group" class="col-sm-6 col-sm-offset-2">
				          <label class="control-label" for="input01">地理位置</label>
				          <div class="controls">
				            <select name="province" id="province">
								<option value="" selected="selected">省份</option>
								<c:forEach items="${PROVINCE}" var="item">
									<option value="${item.code}">${item.name}</option>
								</c:forEach>
							</select>
							<select name="city" id="city">
								<option value="" selected="selected">地市</option>
							</select>
							<select name="district" id="district" style="display:none">
								<option value="" selected="selected">区县</option>
							</select>
				            <p class="help-block">请选择学校的地理位置信息</p>
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
			              	  <button type="button" class="btn btn-success" onclick="next('step1')">下一步</button>
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
		
		var province = document.getElementById('province');
		var city     = document.getElementById('city');
		//省份改变市
		province.onchange = function() {
			$("#district").hide();
			$.ajax({
				url: "${ctx}/super/city/"+province.value, 
				type: "GET",
				success:function(data,status){
				    city.length = 1;
					$.each(data, function(index,item){
						var cityOption = document.createElement('option');
						cityOption.value = item.code;
						cityOption.text = item.name;
						city.options.add(cityOption); 
			    	});
				}
			});
		};
		
		//地市改变
		city.onchange = function() {
			$.ajax({
				url: "${ctx}/super/district/"+city.value, 
				type: "GET",
				success:function(data,status){
					if(data.length>0){
						$("#district").show();
						var district = document.getElementById('district');
						district.length = 1;
						$.each(data, function(index,item){
							var distOption = document.createElement('option');
							distOption.value = item.code;
							distOption.text = item.name;
							district.options.add(distOption); 
				    	});
					}else if(data.length=0){
						$("#district").hide();
					}
				}
			});
		}
	</script>
  </body>
</html>
