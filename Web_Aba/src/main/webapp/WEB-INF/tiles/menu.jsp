<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<c:url var="logout" value="/j_spring_security_logout" /> 
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">	
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" 
				data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Menu</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse" id="navbar-1">
			<ul class="nav navbar-nav">
				<sec:authorize access="hasRole('ADMIN') or hasRole('TS') or hasRole('SUBTEL') or hasRole('COORDINADOR')" >
					<li><a class="m-font" href="busquedas.html">BÚSQUEDA</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') or hasRole('TS') or hasRole('SUBTEL') or hasRole('COORDINADOR')" >
					<li><a class="m-font" href="ees.html">EES</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUBTEL')" >
					<li><a class="m-font" href="graficos.html">GRÁFICOS</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') or hasRole('SUBTEL')" >
					<li><a class="m-font" href="reportes.html">REPORTES</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') or hasRole('COORDINADOR')" >
					<li><a class="m-font" href="reporteTicketOperadora.html">TICKET</a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a id="perfilLink" data-toggle="modal" data-target="#perfilModal" class="m-font"> <span class="fa fa-user"></span> MI PERFIL </a></li>
				<li>
				<li><a class="m-font" href="javascript:logout();"> <span class="fa fa-sign-out"></span> SALIR &nbsp</a></li>
				<form:form id="logout" action="${logout}" method="post">
    				<input type="hidden" name="${_csrf.parameterName} href=" value="${_csrf.token}"/>	
				</form:form>
			</ul>
		</div>
	</nav>
	
	<script>
		function logout() {
			$( "#logout" ).submit();
		}

	    $(document).ready(function () {
	        var url = window.location;

	        $('ul.navbar-nav li').removeClass('active');
	        
	        $('ul.navbar-nav a[href="'+ url +'"]').parent().addClass('active');
	        $('ul.navbar-nav a').filter(function() {
	             return this.href == url;
	        }).parent().addClass('active');
	    });

	</script>
	