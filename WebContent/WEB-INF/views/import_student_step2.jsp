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
    <style>
        .failed {
            color: black\9;
            background-color: #f9806f\9;
        }
        .success {
            color: black\9;
            background-color: #63be7b\9;
        }
        .failed:not(.jqx-grid-cell-hover):not(.jqx-grid-cell-selected), .jqx-widget .max:not(.jqx-grid-cell-hover):not(.jqx-grid-cell-selected) {
            color: black;
            background-color: #f9806f;
        }
        .success:not(.jqx-grid-cell-hover):not(.jqx-grid-cell-selected), .jqx-widget .avg:not(.jqx-grid-cell-hover):not(.jqx-grid-cell-selected) {
            color: black;
            background-color: #63be7b;
        }
    </style>
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
			<div id="sch-step2" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:120px;display:inline">1.数据上传</li>
					<li style="padding-left:120px;display:inline"><font color="red"><strong>2.数据验证</strong></font></li>
			 		<li style="padding-left:120px;display:inline">3.确认</li>
				  </ol>
			  </div>
			  <div class="panel-body" style="padding:0px 15px">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form id="student-step3-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/student/step3.html">
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
			              	  <button type="button" class="btn btn-success" onclick="next('student-step3-form')">下一步</button>
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
				{ name: 'isValid',type: 'string' },
                { name: 'classCode',type: 'string' },
                { name: 'className',type: 'string' },
                { name: 'stuCode',type: 'string' },
                { name: 'stuName',type: 'string' },
                { name: 'stuGender',type: 'string' },
                { name: 'stuBirthDate',type: 'string' },
                { name: 'stuPhone',type: 'string' },
                { name: 'stuEmail',type: 'string' },
                { name: 'startDate',type: 'string' },
                { name: 'finishDate',type: 'string' },
                { name: 'stuRollNo',type: 'string' },
                { name: 'stuNative',type: 'string' },
                { name: 'stuIDCard',type: 'string' },
                { name: 'stuAddress',type: 'string' },
                { name: 'stuZipCode',type: 'string' },
                { name: 'stuStatus',type: 'string' },
                { name: 'stuFamilyType',type: 'string' },
                { name: 'stuKnowledgeLevel',type: 'string' },
                { name: 'stuOriginAttr',type: 'string' },
                { name: 'stuPosition',type: 'string' },
                { name: 'stuOnboardDate',type: 'string' },
                { name: 'stuDeboardDate',type: 'string' },
                { name: 'stuEthinc',type: 'string' },
                { name: 'stuBloodCatalog',type: 'string' },
                { name: 'stuNativeAddress',type: 'string' },
                { name: 'stuNativeZipCode',type: 'string' },
                { name: 'stuTelNo',type: 'string' },
                { name: 'stuIMNo',type: 'string' },
                { name: 'stuRemark',type: 'string' }
            ],
            url: "${ctx}/super/student/data"
        };
		var cellClass = function (row, dataField, cellText, rowData) {
			var cellValue = rowData[dataField];
			switch (dataField) {
				case "isValid":
					if (cellValue == 'No') {
						return "failed";
					}
					return "success";
			}
		}
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
            width:'99.8%',
            height:350,
            pageable: true,
            editable: true,
            pagerButtonsCount: 10,
            source: dataAdapter,
            columnsResize: true,
            editSettings: { saveOnPageChange: true, saveOnBlur: true, saveOnSelectionChange: true, cancelOnEsc: true, saveOnEnter: true, editSingleCell: true, editOnDoubleClick: true, editOnF2: true },
            columns: [
				{ text:'校验成功', dataField: 'isValid', editable: false, cellClassName: cellClass, width: 100 },
                { text:'班级代码', dataField: 'classCode', editable: false,   width: 100 },
				{ text:'班级名称', dataField: 'className', editable: false,  width: 200 },
				{ text:'学生代码', dataField: 'stuCode',    width: 100,
					validation: function (cell, value) {
                        if (value.length< 6||value.length>10) return { message: "学生代码6-10位字符", result: false };
                        return true;
                    }
				},
				,
				{ text:'学生姓名', dataField: 'stuName',    width: 100,
					validation: function (cell, value) {
                        if (value.length< 2||value.length>10) return { message: "学生姓名2-10位字符", result: false };
                        return true;
                    }
				},
				{ text:'性别', dataField: 'stuGender',  width: 50 },
				{ text:'出生日期', dataField: 'stuBirthDate',     width: 100 },
				{ text:'手机号码', dataField: 'stuPhone',   width: 100 },
				{ text:'邮箱地址', dataField: 'stuEmail',   width: 200 },
				{ text:'开始时间', dataField: 'startDate',   width: 100 },
				{ text:'结束时间', dataField: 'finishDate',   width: 100 },
				{ text:'学籍号',dataField: 'stuRollNo',type: 'string',width: 100 },
				{ text:'籍贯',dataField: 'stuNative',type: 'string',width: 100 },
				{ text:'身份证',dataField: 'stuIDCard',type: 'string',width: 100 },
				{ text:'家庭住址',dataField: 'stuAddress',type: 'string',width: 100 },
				{ text:'邮编',dataField: 'stuZipCode',type: 'string',width: 100 },
				{ text:'学生状态',dataField: 'stuStatus',type: 'string',width: 100 },
				{ text:'家庭类型',dataField: 'stuFamilyType',type: 'string',width: 100 },
				{ text:'知识等级',dataField: 'stuKnowledgeLevel',type: 'string',width: 100 },
				{ text:'生源性质',dataField: 'stuOriginAttr',type: 'string',width: 100 },
				{ text:'学生职务',dataField: 'stuPosition',type: 'string',width: 100 },
				{ text:'入校日期',dataField: 'stuOnboardDate',type: 'string',width: 100 },
				{ text:'离校日期',dataField: 'stuDeboardDate',type: 'string',width: 100 },
				{ text:'民族',dataField: 'stuEthinc',type: 'string',width: 100 },
				{ text:'血型',dataField: 'stuBloodCatalog',type: 'string',width: 100 },
				{ text:'户籍地址',dataField: 'stuNativeAddress',type: 'string',width: 100 },
				{ text:'户籍邮编',dataField: 'stuNativeZipCode',type: 'string',width: 100 },
				{ text:'固定电话',dataField: 'stuTelNo',type: 'string',width: 100 },
				{ text:'即时通讯',dataField: 'stuIMNo',type: 'string',width: 100 },
				{ text:'备注',dataField: 'stuRemark',type: 'string',width: 100 }
            ]
        });
     // Cell End Edit
        $("#dataTable").on('cellEndEdit', function (event) {
            var args = event.args;
            var rowIndex = args.index;
            var columnDataField = args.dataField;
            var value = args.value;
            $.ajax({
                url:'${ctx}/super/student/data/update',
                data:{  
                         index : rowIndex,  
                         field : columnDataField,  
                         value : value  
                },  
                type:'POST',
                dataType:'json'
            });
            var stuCode = $("#dataTable").jqxDataTable('getCellValue', rowIndex, 'stuCode');
        	var stuName = $("#dataTable").jqxDataTable('getCellValue', rowIndex, 'stuName');
        	if(6<stuCode.length<10&&2<stuName.length<10){
        		$("#dataTable").jqxDataTable('setCellValue', rowIndex, 'isValid', 'Yes');
        		console.log("update isValid");
        	}
        });
	});
	</script>
  </body>
</html>
