<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="<c:url value='/img/sz.ico'/>">
    <title>教学管理系统</title>
  </head>
  <body>
  <script src="<c:url value='/js/jquery.js'/>"></script>
  <script>
	var form = $("<form></form>");
    form.attr('action',"${ctx}/user/logout.html");
    form.attr('method','get');
    form.attr('target', '_self');
    form.appendTo("body")
    form.css('display','none')
    form.submit()
  </script>
  </body>
</html>
