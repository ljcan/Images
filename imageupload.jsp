<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'imageupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	body{
	backgroundColor:black;
	}
	.demo{
	backgroundColor:white;
	}
	.bbody{
	backgroundColor:yellow;
	}
	</style>
  </head>
  
  <body>
    <div class="demo">
    	<div class="bheader">
    	<h2>-------图片上传-------</h2>
    	</div>
    </div>
    <div class="bbody">
    	<form id="upload" enctype="multipart/form-data" method="post" action="image.spring">
    	<h2>请选择上传图片</h2>
    	<div>
    	<input type="file" name="image" id="image"/>
    	<input type="submit" value="上传"/>
    	</div>
    	</form>
    </div>
  </body>
</html>
