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
            <li class="active"><a href="${ctx}/super/teacher/step1.html"><i class="icon-signin"></i> 教师信息导入<span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/student/step1.html"><i class="icon-signin"></i> 学生信息导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">教师信息导入</h1>
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
		     	<form id="teacher-step4-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/teacher/step4.html">
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
			              	  <button type="button" class="btn btn-success" onclick="next('teacher-step4-form')">完成</button>
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
	
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxcore.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdata.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxbuttons.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxscrollbar.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdatatable.js'/>"></script>
	
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
		});
		var source =
        {
            dataType: "json",
            dataFields: [
                { name: 'classCode',type: 'string' },
                { name: 'className',type: 'string' },
                { name: 'subjectID',type: 'string' },
                { name: 'subjectName',type: 'string' },
                { name: 'teaCode',type: 'string' },
                { name: 'teaName',type: 'string' },
                { name: 'teaGender',type: 'string' },
                { name: 'teaBirthDate',type: 'string' },
                { name: 'teaPhone',type: 'string' },
                { name: 'teaEmail',type: 'string' },
                { name: 'startDate',type: 'string' },
                { name: 'finishDate',type: 'string' },
                { type:'string',name:'teaIDCard' },
				{ type:'string',name:'teaEthinc' },
				{ type:'string',name:'teaNativePlace' },
				{ type:'string',name:'teaCollege' },
				{ type:'string',name:'teaMajor' },
				{ type:'string',name:'teaDegree' },
				{ type:'string',name:'teaStatus' },
				{ type:'string',name:'teaCertificate' },
				{ type:'string',name:'teaPostProp' },
				{ type:'string',name:'teaJobTitle' },
				{ type:'string',name:'teaPosition' },
				{ type:'string',name:'teaOnboardDate' },
				{ type:'string',name:'teaDeboardDate' },
				{ type:'string',name:'teaAddress' },
				{ type:'string',name:'teaZipCode' },
				{ type:'string',name:'teaTelNo' },
				{ type:'string',name:'teaIMNo' },
				{ type:'string',name:'teaRemark' }
            ],
            url: "${ctx}/super/teacher/data"
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
				{ text:'科目代码', dataField: 'subjectID',  width: 100 },
				{ text:'科目名称', dataField: 'subjectName',width: 100 },
				{ text:'教师代码', dataField: 'teaCode',    width: 100 },
				{ text:'教师姓名', dataField: 'teaName',    width: 100 },
				{ text:'性别', dataField: 'teaGender',  width: 50 },
				{ text:'生日', dataField: 'teaBirthDate',     width: 100 },
				{ text:'手机号码', dataField: 'teaPhone',   width: 100 },
				{ text:'邮箱地址', dataField: 'teaEmail',   width: 200 },
				{ text:'开始时间', dataField: 'startDate',   width: 100 },
				{ text:'结束时间', dataField: 'finishDate',   width: 100 },
				{ text:'身份证',dataField:'teaIDCard',width: 100 },
				{ text:'民族',dataField:'teaEthinc',width: 100 },
				{ text:'籍贯',dataField:'teaNativePlace',width: 100 },
				{ text:'毕业学校',dataField:'teaCollege',width: 100 },
				{ text:'专业',dataField:'teaMajor',width: 100 },
				{ text:'教师学历',dataField:'teaDegree',width: 100 },
				{ text:'教师状态',dataField:'teaStatus',width: 100 },
				{ text:'是否有上岗证',dataField:'teaCertificate',width: 100 },
				{ text:'岗位性质',dataField:'teaPostProp',width: 100 },
				{ text:'职称',dataField:'teaJobTitle',width: 100 },
				{ text:'职务',dataField:'teaPosition',width: 100 },
				{ text:'入校日期',dataField:'teaOnboardDate',width: 100 },
				{ text:'离校日期',dataField:'teaDeboardDate',width: 100 },
				{ text:'家庭住址',dataField:'teaAddress',width: 100 },
				{ text:'邮编',dataField:'teaZipCode',width: 100 },
				{ text:'固定电话',dataField:'teaTelNo',width: 100 },
				{ text:'即时通讯号',dataField:'teaIMNo',width: 100 },
				{ text:'备注',dataField:'teaRemark',width: 100 }
				
            ]
            });
	</script>
  </body>
</html>
