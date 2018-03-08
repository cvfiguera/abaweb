//getSubAdjudicacion()

function setError(code, mensaje) {

	 var error = "";
	 if (code >= 400 && code < 500) error = "El requerimiento enviado es incorrecto.";
	 else if (code>=500 && code<600) error = mensaje;
	 else error = "Ha ocurrido un error desconocido.";
	 $.notify({
			// options
		 	icon: 'glyphicon glyphicon-warning-sign',
			message: error
		},{
			// settings
			element: 'body',
			position: null,
			type: 'danger',
			delay: 2000,
			timer: 800,
			animate: {
				enter: 'animated fadeInDown',
				exit: 'animated fadeOutUp'
			}
		});
}

function getSubAdjudicacion(adjudicacionId){
	
	$("#subestadoE").empty();
	var html = '<option value=""></option>';
	$("#subestadoE").append(html);
	
	if (adjudicacionId != "") {
		$.ajax({
			  type: 'GET',
			  contentType : 'application/json',
			  url: 'subestados.html',
			  dataType: 'json',
			  beforeSend: function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			  },
			  data:{"id":adjudicacionId},
			  success: function(response){
				  var html = '';
				  var subestados = response.subestados;
	              var len = subestados.length;
	              for(var i=0; i<len; i++){
	                   html += '<option value="' + subestados[i].id + '"> ' + subestados[i].nombre +' </option>';
	               }
	              $("#subestadoE").append(html);
			  }
			});
	}
}

//getComunas()
function getComunas(regionId, control){

	$("#" + control).empty();
	var html = '<option value=""></option>';
	$("#" + control).append(html);
	var url="";

	if (control == "comunaT")
		url = "comunas_old.json";
	else
		url="comunas.json";
	
	if (regionId != "") {
		$.ajax({
			  type: 'GET',
			  contentType : 'application/json',
			  beforeSend: function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			  },
			  url: url,
			  data:{"id":regionId},
			  success: function(response){
				  var html = '';
				  var comunas = response.comunas;
	              var len = comunas.length;
	              for(var i=0; i<len; i++){
	                   html += '<option value="' + comunas[i].id + '"> ' + comunas[i].nombre +' </option>';
	               }
	              $("#" + control).append(html);
			  }
			});
	}
}
	
	
