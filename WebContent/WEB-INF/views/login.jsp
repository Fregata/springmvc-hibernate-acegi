<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value='/img/sz.ico'/>" rel="icon">
    <title>教学管理系统</title>
    <link href="<c:url value='/css/login.css'/>" rel="stylesheet">
  </head>

  <body>
    <section class="about">
      <p>
        <img src="<c:url value='/img/user.png'/>">
      </p>
      <p>
        <font style="font-size:1 rem;font-family:微软雅黑;">教学管理系统</font>
      </p>
    </section>
    <form method="post" action="${ctx}/j_acegi_security_check" class="login">
      <p>
        <label for="login"><font style="font-size:1 rem;font-family:微软雅黑;">用户名:</font></label>
        <input type="text" name="j_username" id="j_username" value="readonly">
      </p>

      <p>
        <label for="password"><font style="font-size:1 rem;font-family:微软雅黑;">密码:</font></label>
        <input type="password" name="j_password" id="j_password" value="readonly">
      </p>

      <p class="login-submit">
        <button type="submit" class="login-button">登录</button>
      </p>
    </form>
  </body>
</html>
