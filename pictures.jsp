<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pictures.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table width="100%" align="center">
    <tr>
    <td width="50%" align="center">上传原图</td>
    <td width="50%" align="center">等比缩略图</td>
    </tr>
    <tr>
    <td width="50%" align="center"><img src="${pageContext.request.contextPath}${oldimage}" width="500"/></td>
    <td width="50%" align="center"><img src="${pageContext.request.contextPath}${newimage}"/></td>
    </tr>
    </table>
    <a href="${pageContext.request.contextPath}">返回</a>
  </body>
</html>
