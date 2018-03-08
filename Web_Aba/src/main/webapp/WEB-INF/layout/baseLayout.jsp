<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf_parameter" content="_csrf" />
	<meta name="_csrf_header" content="X-CSRF-TOKEN" />
	<meta name="_csrf" content="${_csrf.token}" />
	<jsp:include page="/WEB-INF/tiles/jscss.jsp"></jsp:include>
	<link rel="shortcut icon" href="favicon.ico" />
	<title>Web Aba</title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="menu" />
	</div>
	<div class="container-fluid">
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<div style="margin-top: 15px;">
			<tiles:insertAttribute name="body" />
		</div>
		<div>
			<tiles:insertAttribute name="modal" />
		</div>
		<div class="row">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>