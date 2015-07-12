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
    <link href="<c:url value='/css/jqwidgets/jqx.base.css'/>" rel="stylesheet"/>
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
            <li><a href="${ctx}/super/teacher/step1.html"><i class="icon-signin"></i> 教师信息导入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/super/student/step1.html"><i class="icon-signin"></i> 学生信息导入<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">学生信息导入</h1>
          	<c:if test="${not empty ERROR}">
	          	<div class="alert alert-warning" role="alert">
			      <strong>异常信息:</strong> ${ERROR}
			    </div>
          	</c:if>
			<div id="sch-step3" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:120px;display:inline">1.数据上传</li>
					<li style="padding-left:120px;display:inline">2.数据验证</li>
			 		<li style="padding-left:120px;display:inline"><font color="red"><strong>3.确认</strong></font></li>
				  </ol>
			  </div>
			  <div class="panel-body" style="padding:0px 15px">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form id="student-step4-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/student/step4.html">
                     <div id="dataTable"></div>
                 </form>
		      </div>
		      </div>
		      <div class="panel-footer">
			  <form class="form-horizontal">
				  <div class="form-group" style="margin-bottom:0px">
	                   <div class="col-sm-6 col-sm-offset-5">
                           <div class="btn-group" role="group" aria-label="...">
                           <button type="button" class="btn btn-danger" onclick="javascript:history.back(-1);">上一步</button>
			              	  <button type="button" class="btn btn-success" onclick="next('student-step4-form')">完成</button>
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
    
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxcore.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdata.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxbuttons.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxscrollbar.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdatatable.js'/>"></script>
    <script>
    $(document).ready(function(){
		$("#main").addClass("active");

		var source =
        {
            dataType: "json",
            dataFields: [
                { name: 'classCode',type: 'string' },
                { name: 'className',type: 'string' },
                { name: 'stuCode',type: 'string' },
                { name: 'stuName',type: 'string' },
                { name: 'stuGender',type: 'string' },
                { name: 'stuAge',type: 'string' },
                { name: 'stuPhone',type: 'string' },
                { name: 'stuEmail',type: 'string' },
                { name: 'startDate',type: 'string' },
                { name: 'finishDate',type: 'string' }
            ],
            url: "${ctx}/super/student/data"
        };

        var dataAdapter = new $.jqx.dataAdapter(source, 
            {
                formatData: function (data) {
                    $.extend(data, {
                        featureClass: "P",
                        style: "full",
                        username: "jqwidgets",
                        maxRows: 50
                    });
                    return data;
                }
            }
        );
        
        $("#dataTable").jqxDataTable(
        {
            width: '99.8%',
            height:350,
            pageable: true,
            pagerButtonsCount: 10,
            source: dataAdapter,
            columnsResize: true,
            columns: [
                { text:'班级代码', dataField: 'classCode',    width: 100 },
				{ text:'班级名称', dataField: 'className',  width: 200 },
				{ text:'学生代码', dataField: 'stuCode',    width: 100 },
				{ text:'学生姓名', dataField: 'stuName',    width: 100 },
				{ text:'性别', dataField: 'stuGender',  width: 50 },
				{ text:'年龄', dataField: 'stuAge',     width: 50 },
				{ text:'手机号码', dataField: 'stuPhone',   width: 100 },
				{ text:'邮箱地址', dataField: 'stuEmail',   width: 200 },
				{ text:'开始时间', dataField: 'startDate',   width: 100 },
				{ text:'结束时间', dataField: 'finishDate',   width: 100 }
            ]
        });
	});
	</script>
  </body>
</html>
