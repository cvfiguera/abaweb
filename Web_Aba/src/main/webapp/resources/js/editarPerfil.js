$(document).ready(function() {
	
	var datos;
	
	$( "#perfilLink" ).click(function() {
		$.ajax({  
			type : 'GET',
			url : 'perfil.json',
			beforeSend : function(xhr) {
				xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $(
							"meta[name='_csrf']").attr("content"));
			},
			success : function(response) {
				datos = response;
				$('#name').val(response.name);
				$('#lastname').val(response.lastname);
				$('#email').val(response.email);
				$('#org').val(response.org);
				$('#pass').val(response.pass);
				$('#repass').val(response.repass);
				$('#newpass').val(response.newpass);
			},
			error : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			}
		});
	});
	
	$('#cambiar').change(function() {
	    var val = this.checked ? this.value : '';
	    
	    if (val == 'on') {
			$('#pass').val('');
			$('#repass').val('');
			$('#newpass').val('');
			$( "#pass" ).prop( "disabled", false );
			$( "#repass" ).prop( "disabled", false );
			$( "#newpass" ).prop( "disabled", false );
		}
	    
	    if (val == ''){
	    	$('#pass').val(datos.pass);
			$('#repass').val(datos.repass);
			$('#newpass').val(datos.newpass);
			$( "#pass" ).prop( "disabled", true );
			$( "#repass" ).prop( "disabled", true );
			$( "#newpass" ).prop( "disabled", true );
		}
	});

});

function validarFormulario() {
	
	var valido = true;
	
	if (!validar("name", "error-name"))
		valido = false;
	if (!validar("lastname", "error-lastname"))
		valido = false;
	if (!validar("email", "error-email"))
		valido = false;
	if (!validar("org", "error-org"))
		valido = false;
	if (!validar("pass", "error-pass"))
		valido = false;
	if (!validar("newpass", "error-newpass"))
		valido = false;
	if (!validar("repass", "error-repass"))
		valido = false;
	if ($('#newpass').val() != $("#repass").val()) {
		valido = false;
		$("#repass").html("Las contraseñas no coinciden.");
	}
		
	return valido;
	
}

function validar(campo, error) {
	
	var requerido = "*Este campo el requerido.";
	var valido = true;
	
	if ($("#" + campo).val()=="") {
		$("#" + campo).addClass("has-error");
		$("#" + error).html(requerido);
		valido = false;
	} else {
		$("#" + error).html("");
	}
	
	return valido;
}

function editarPerfil() {
	if (validarFormulario()) {
		var data;
		
		data = {
				name: $('#name').val(),
				lastname: $('#lastname').val(),
				email: $('#email').val(),
				org: $('#org').val(),
	    		pass: $("#pass").val(),
	    		newpass: $("#newpass").val(),
	    		repass: $("#repass").val()
		};
	    
		$.ajax({
			  type: 'POST',
			  url: 'perfil.json',
			  beforeSend: function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			  },
			  data:data,
			  success: function(response){
				  
				  $.notify({
						// options
						icon : 'glyphicon glyphicon-warning-sign',
						message : response.mensaje
					}, {
						// settings
						element : 'body',
						position : null,
						type : response.tipo,
						delay : 2000,
						timer : 800,
						animate : {
							enter : 'animated fadeInDown',
							exit : 'animated fadeOutUp'
						}
					});
			  },
			  error: function(jqXHR, textStatus, errorThrown ) {
				  $.notify({
						// options
						icon : 'glyphicon glyphicon-warning-sign',
						message : 'Ha ocurrido un errr.'
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
		document.getElementById("perfil").reset();
		$("#cancelar").click();
	}
}