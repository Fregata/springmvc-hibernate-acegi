<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<link href="<c:url value='/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
<nav class="navbar navbar-default navbar-fixed-top" style="background:url(<c:url value='/img/top.png'/>) repeat-x">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="padding:7px 0px 0px 10px">
        <img src="<c:url value='/img/logo.png'/>">
      </a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-left">
        <li id="main"><a href="${ctx}/user/main.html"><i class="icon-home"></i> 首页</a></li>
        <li id="system"><a href="${ctx}/admin/system.html"><i class="icon-desktop"></i> 系统管理</a></li>
        <li id="setting"><a href="${ctx}/admin/setting.html"><i class="icon-cogs"></i> 设置</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${ctx}/user/logout.html"><i class="icon-signout"></i> 退出</a></li>
        <li><a href="#"><i class="icon-info-sign"></i> 帮助</a></li>
      </ul>
    </div>
  </div>
</nav>
