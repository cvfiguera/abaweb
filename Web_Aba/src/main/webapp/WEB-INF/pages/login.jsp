<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="bower_components/remarkable-bootstrap-notify/dist/bootstrap-notify.js"></script>

<div class="jumbotron login center-block">
	<h4>Aba Administración | Ingreso</h4>
	<br />
	<form role="form" name='loginForm' id="loginForm"
		action="j_spring_security_check" method="POST">
		<div class="form-group">
			<label class="control-label" for="j_username">Usuario</label> <input
				id="j_username" name="j_username" class="form-control" type="text"></input>
		</div>
		<div class="form-group">
			<label class="control-label" for="j_password">Password</label> <input
				id="j_password" name="j_password" class="form-control"
				type="password" size="15" autocomplete="on"></input>
				<span id="tError"></span>
		</div>
		<div class="form-button">
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>

<script>
	
	$(document).ready(function() {
		
		if (getParameterByName('login')== 'failed') {
			$("#tError").html = "La contraseña es incorrecta.";
			$.notify({
				// options
				icon : 'glyphicon glyphicon-warning-sign',
				message : 'La contraseña es incorrecta.'
			}, {
				// settings
				element : 'body',
				position : null,
				type : 'danger',
				delay : 2000,
				timer : 800,
				animate : {
					enter : 'animated fadeInDown',
					exit : 'animated fadeOutUp'
				}
			});
		}
	});
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	    results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
</script>
