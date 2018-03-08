<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="resources/css/base.css">
<link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<title>ABA</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="headerLogin" />
		</div>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
</html>