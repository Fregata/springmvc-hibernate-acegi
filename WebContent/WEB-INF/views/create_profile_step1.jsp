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
    <link rel="stylesheet" href="<c:url value='/css/jqwidgets/jqx.base.css'/>" type="text/css" />
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
            <li><a href="${ctx}/super/teacher/step1.html"><i class="icon-signin"></i> 教师信息导入</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${ctx}/super/student/step1.html"><i class="icon-signin"></i> 学生信息导入</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          	<h1 class="page-header">学校基础信息创建</h1>
			<div id="sch-step1" class="panel panel-success">
			  <div class="panel-heading">
				  <ol style="list-style:none;display:block;width:auto;margin:0px auto">
					<li style="padding-left:180px;display:inline"><font color="red"><strong>1.学校信息设置</strong></font></li>
					<li style="padding-left:180px;display:inline">2.确认</li>
				  </ol>
			  </div>
			  <div class="panel-body">
		      <div class="row row-offcanvas row-offcanvas-center" style="height:350px">
		     	<form id="profile-step2-form" class="form-horizontal" role="form" method="post" action="${ctx}/super/profile/step2.html">
		     	<div class="col-sm-12">
                     <div class="col-sm-4 col-sm-offset-2">
	                     <div class="control-group">
				          <label class="control-label">学校名称</label>
				          <div class="controls">
				            <input id="profile_name" name="profile_name" type="text" style="width:200px">
				          </div>
				         </div>
				         <div class="control-group">
				          <label class="control-label">学校代码</label>
				          <div class="controls">
				            <input id="profile_code" name="profile_code" type="text" style="width:200px">
				          </div>
				         </div>
				         <div class="control-group">
				          <label class="control-label">学校类型</label>
				          <div class="controls">
					          <input id="school-type" name="profile_type" style='display:none'>
					          <div id="profile-type"></div>
				          </div>
				         </div>
				         <div class="control-group">
				          <label class="control-label">学校性质</label>
				          <div class="controls">
				          	<input id="school-attr" name="profile_attr" style='display:none'>
				          	<div id="profile-attr"></div>
				          </div>
				         </div>
				         <div class="control-group">
				          <label class="control-label">学校等级</label>
				          <div class="controls">
				          	<input id="school-level" name="profile_level" style='display:none'>
				          	<div id="profile-level"></div>
				          </div>
				         </div>
			        </div>
			        
			        <input id="grdJson" name="grdJson" style='display:none'>
			        <input id="clzJson" name="clzJson" style='display:none'>
			        <div class="col-sm-6">
	                     <div class="control-group">
				          <label class="control-label" for="input01">班级设置</label>
				          <div class="controls" style="height:300px;">
				          	<div id='jqxTree' style='visibility: hidden; float: left;'>
				                <ul>
				                    <li id="primary">小学部
				                        <ul>
				                            <li id='p100'>一年级
				                                <ul>
				                                    <li id='p101'>一年级(1)班</li>
				                                    <li id='p102'>一年级(2)班</li>
				                                    <li id='p103'>一年级(3)班</li>
				                                    <li id='p104'>一年级(4)班</li>
				                                    <li id='p105'>一年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='p200'>二年级
				                                <ul>
				                                    <li id='p201'>二年级(1)班</li>
				                                    <li id='p202'>二年级(2)班</li>
				                                    <li id='p203'>二年级(3)班</li>
				                                    <li id='p204'>二年级(4)班</li>
				                                    <li id='p205'>二年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='p300'>三年级
				                                <ul>
				                                    <li id='p301'>三年级(1)班</li>
				                                    <li id='p302'>三年级(2)班</li>
				                                    <li id='p303'>三年级(3)班</li>
				                                    <li id='p304'>三年级(4)班</li>
				                                    <li id='p305'>三年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='p400'>四年级
				                                <ul>
				                                    <li id='p401'>四年级(1)班</li>
				                                    <li id='p402'>四年级(2)班</li>
				                                    <li id='p403'>四年级(3)班</li>
				                                    <li id='p404'>四年级(4)班</li>
				                                    <li id='p405'>四年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='p500'>五年级
				                                <ul>
				                                    <li id='p501'>五年级(1)班</li>
				                                    <li id='p502'>五年级(2)班</li>
				                                    <li id='p503'>五年级(3)班</li>
				                                    <li id='p504'>五年级(4)班</li>
				                                    <li id='p505'>五年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='p600'>六年级
				                                <ul>
				                                    <li id='p601'>六年级(1)班</li>
				                                    <li id='p602'>六年级(2)班</li>
				                                    <li id='p603'>六年级(3)班</li>
				                                    <li id='p604'>六年级(4)班</li>
				                                    <li id='p605'>六年级(5)班</li>
				                                </ul>
				                            </li>
				                        </ul>
				                    </li>
				                    <li id='high'>初中部
				                        <ul>
				                            <li id='h700'>七年级
				                                <ul>
				                                    <li id='h701'>七年级(1)班</li>
				                                    <li id='h702'>七年级(2)班</li>
				                                    <li id='h703'>七年级(3)班</li>
				                                    <li id='h704'>七年级(4)班</li>
				                                    <li id='h705'>七年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='h800'>八年级
				                                <ul>
				                                    <li id='h801'>八年级(1)班</li>
				                                    <li id='h802'>八年级(2)班</li>
				                                    <li id='h803'>八年级(3)班</li>
				                                    <li id='h804'>八年级(4)班</li>
				                                    <li id='h805'>八年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='h900'>九年级
				                                <ul>
				                                    <li id='h901'>九年级(1)班</li>
				                                    <li id='h902'>九年级(2)班</li>
				                                    <li id='h903'>九年级(3)班</li>
				                                    <li id='h904'>九年级(4)班</li>
				                                    <li id='h905'>九年级(5)班</li>
				                                </ul>
				                            </li>
				                        </ul>
				                    </li>
				                    <li id='advance' item-checked='true' item-expanded='true'>高中部
				                        <ul>
				                            <li id='a100'>高中一年级
				                                <ul>
				                                    <li id='a101'>高中一年级(1)班</li>
				                                    <li id='a102'>高中一年级(2)班</li>
				                                    <li id='a103'>高中一年级(3)班</li>
				                                    <li id='a104'>高中一年级(4)班</li>
				                                    <li id='a105'>高中一年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='a200'>高中二年级
				                                <ul>
				                                    <li id='a201'>高中二年级(1)班</li>
				                                    <li id='a202'>高中二年级(2)班</li>
				                                    <li id='a203'>高中二年级(3)班</li>
				                                    <li id='a204'>高中二年级(4)班</li>
				                                    <li id='a205'>高中二年级(5)班</li>
				                                </ul>
				                            </li>
				                            <li id='a300'>高中三年级
				                                <ul>
				                                    <li id='a301'>高中三年级(1)班</li>
				                                    <li id='a302'>高中三年级(2)班</li>
				                                    <li id='a303'>高中三年级(3)班</li>
				                                    <li id='a304'>高中三年级(4)班</li>
				                                    <li id='a305'>高中三年级(5)班</li>
				                                </ul>
				                            </li>
				                        </ul>
				                    </li>
				                </ul>
				            </div>
				          	<div>
			                    <input type="button" id='Add' value="增加" />
			                </div>
			                <div style='margin-top: 20px;'>
			                    <input type="button" id='Remove' value="删除" />
			                </div>
			                <div style='margin-top: 20px;'>
			                    <input type="button" id='Update' value="修改" />
			                </div>
					        
					        <div id="updateWindow">
				                <div id="customWindowHeader">
				                    <span id="captureContainer" style="float: left">修改名称 </span>
				                </div>
				                <div id="customWindowContent" style="overflow: hidden">
				                    <div style="margin: 10px">
				                                                                                    输入名称:
				                        <input type="text" style="width: 175px; border: 1px solid #aaa" id="searchTextInput" />
				                        <div style="float: right; margin-top: 15px;">
				                            <input type="button" id="ok" value="确定" style="margin-bottom: 5px;" />
				                            <input type="button" id="cancel" value="取消" />
				                        </div>
				                	</div>
				            	</div>
					        </div>
					        
			          		</div>
				         </div>
			        </div>
			        </div>
			        <div class="col-sm-12  col-sm-offset-2">
	                     <div class="control-group">
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
				          </div>
				         </div>
			        </div>
			        <div class="col-sm-12 col-sm-offset-2">
	                     <div class="control-group">
				          <label class="control-label" for="input01">学校详细地址</label>
				          <div class="controls">
				            <textarea id="profile_address" name="profile_address" rows="1" cols="100"></textarea>
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
			              	  <button type="button" class="btn btn-success" onclick="submitStep1()">下一步</button>
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
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxbuttons.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxscrollbar.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxpanel.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxtree.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxcheckbox.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxwindow.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdata.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxdropdownlist.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jqwidgets/jqxlistbox.js'/>"></script>
    <script>
		$(document).ready(function(){
			$("#main").addClass("active");
			
            var type =
            {
                datatype: "json",
                datafields: [
                    { name: 'label' },
                    { name: 'value' }
                ],
                url: "<c:url value='/resources/school-type.txt'/>",
                async: false
            };
            var attr =
            {
                datatype: "json",
                datafields: [
                    { name: 'label' },
                    { name: 'value' }
                ],
                url: "<c:url value='/resources/school-attribute.txt'/>",
                async: false
            };
            var level =
            {
                datatype: "json",
                datafields: [
                    { name: 'label' },
                    { name: 'value' }
                ],
                url: "<c:url value='/resources/school-level.txt'/>",
                async: false
            };
            var typeAdapter = new $.jqx.dataAdapter(type);
            var attrAdapter = new $.jqx.dataAdapter(attr);
            var levelAdapter = new $.jqx.dataAdapter(level);
            $("#profile-type").jqxDropDownList({
                selectedIndex: 0, source: typeAdapter, displayMember: "label", valueMember: "value", width: 200, height: 25
            });
            $("#profile-attr").jqxDropDownList({
                selectedIndex: 0, source: attrAdapter, displayMember: "label", valueMember: "value", width: 200, height: 25
            });
            $("#profile-level").jqxDropDownList({
                selectedIndex: 0, source: levelAdapter, displayMember: "label", valueMember: "value", width: 200, height: 25
            });
			
			addEventListeners();
            createElements();
            $('#updateWindow').jqxWindow('close');
		});
		
		var province = document.getElementById('province');
		var city     = document.getElementById('city');
		
		var grdList = ["primary","high","advance"];
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
		};
		
		// create jqxTree
        $('#jqxTree').jqxTree({ height: '300px', hasThreeStates: true, checkboxes: true, width: '200px'});
        $('#jqxTree').css('visibility', 'visible');
        $("#jqxTree").jqxTree('selectItem', $("#advance")[0]);
        // Create and initialize Buttons
        $('#Add').jqxButton({ template: "success", height: '25px', width: '100px'});
        $('#Update').jqxButton({ template: "success", height: '25px', width: '100px'});
        $('#Remove').jqxButton({ template: "success", height: '25px', width: '100px'});
        
     	// Add 
        $('#Add').click(function () {
            var selectedItem = $('#jqxTree').jqxTree('selectedItem');
            if (selectedItem != null && selectedItem.hasItems && grdList.indexOf(selectedItem.parentId)!=-1) {
                $('#jqxTree').jqxTree('addTo', { label: selectedItem.label+'(?)班' ,value:''}, selectedItem.element, false);
                // update the tree.
                $('#jqxTree').jqxTree('render');
            }
        });
     	// Remove 
        $('#Remove').click(function () {
            var selectedItem = $('#jqxTree').jqxTree('selectedItem');
            if (selectedItem != null) {
                $('#jqxTree').jqxTree('removeItem', selectedItem.element, false);
                $('#jqxTree').jqxTree('render');
            }
        });
     	// Update
        $('#Update').click(function () {
            var selectedItem = $('#jqxTree').jqxTree('selectedItem');
            var prevItem = $("#jqxTree").jqxTree('getPrevItem', selectedItem.element);
           	var index = parseInt(prevItem.value.charAt(prevItem.value.length-1),10) + 1;
            if (selectedItem != null && !selectedItem.hasItems) {
            	var prefix = selectedItem.label.substr(0,selectedItem.label.indexOf('('));
            	$('#searchTextInput').val(prefix+"("+index+")班");
            	$('#updateWindow').jqxWindow('open');
            }
        });
        function addEventListeners() {
            //Closed event
            $('#ok').on('click', function (event) {
            	var selectedItem = $('#jqxTree').jqxTree('selectedItem');
            	var prevItem = $("#jqxTree").jqxTree('getPrevItem', selectedItem.element);
               	var index = parseInt(prevItem.value.charAt(prevItem.value.length-1),10) + 1;
               	var value = prevItem.value.substr(0,prevItem.value.length-1)+index;
            	var name = $('#searchTextInput').val();
            	$('#jqxTree').jqxTree('updateItem', { label: name,value: value }, selectedItem.element);
                $('#jqxTree').jqxTree('render');
            });
        };
        function createElements() {
            $('#updateWindow').jqxWindow({
                maxHeight: 120, maxWidth: 280, minHeight: 30, minWidth: 250, height: 145, width: 270,
                resizable: false, isModal: true, modalOpacity: 0.3,
                okButton: $('#ok'), cancelButton: $('#cancel'),
                initContent: function () {
                	var items = $('#jqxTree').jqxTree('getItems');
                	$.each(items, function (index) {
                		$('#jqxTree').jqxTree('updateItem', { value:this.id }, this.element);
                    });
                    $('#ok').jqxButton({template: "success", width: '65px' });
                    $('#cancel').jqxButton({template: "success", width: '65px' });
                    $('#ok').focus();
                }
            });
        };
      function submitStep1(){
    	  var items = $("#jqxTree").jqxTree('getCheckedItems');
    	  var type = $("#profile-type").jqxDropDownList('getSelectedItem');
          var attr = $("#profile-attr").jqxDropDownList('getSelectedItem');
          var level = $("#profile-level").jqxDropDownList('getSelectedItem');
          var gradeStr = "";
          var clazzStr = "";
          $.each(items, function (index) {
        	  if(this.hasItems && grdList.indexOf(this.parentId)!=-1){
        		  gradeStr = gradeStr.concat(this.label+'-'+this.value+':');
        	  }else if(!this.hasItems){
        		  clazzStr = clazzStr.concat(this.label+'-'+this.value+':');
        	  }
          });
          $("#grdJson").val(gradeStr);
          $("#clzJson").val(clazzStr);
          $("#school-type").val(type.value);
          $("#school-attr").val(attr.value);
          $("#school-level").val(level.value);
          $("#profile-step2-form").submit();
      };
	</script>
  </body>
</html>
