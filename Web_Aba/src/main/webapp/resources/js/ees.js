$(document).ready(function() {
	var data;
	$('#ees_ticket').on('dblclick','tr',function() {
		var table = $('#ees_ticket').DataTable();
		var row = table.row($(this));
		var data = row.data();
		$.ajax({  
			type : 'GET',
			url : 'ticketmodal.html',beforeSend : function(xhr) {
				xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $(
							"meta[name='_csrf']").attr("content"));
			},
			data : {"id" : data.nroTicketCallCenter},
			success : function(response) {$('#html-ticket').html(response);},
			error : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);}
		});

		$('#ticket-modal').modal('show');
	});
	$('#ees_table').on('dblclick', 'tr', function() {

		var table = $('#ees_table').DataTable();
		var row = table.row($(this));
		if (row) {
			data = row.data();

			switch ($('.nav-tabs > li.active >a').attr("id")) {
			case "tabinstalacion":
				tableInstalacion(data.rbdId, data.concursoId);
			case "tabadjudicacion":
				tableAdjudicacion(data.rbdId, data.concursoId);
				;
			case "tablespera":
				tableLEspera(data.rbdId, data.concursoId);
			case "tabticket":
				tableTickets(data.rbdId, data.concursoId);
			case "tabcontacto":
				tableContactos(data.rbdId);
			}
		}
	});

	$('#tabinstalacion').on('shown.bs.tab', function() {
		if (data.rbdId != null)
			tableInstalacion(data.rbdId, data.concursoId);
	});

	$('#tabadjudicacion').on('shown.bs.tab', function() {
		if (data.rbdId != null)
			tableAdjudicacion(data.rbdId, data.concursoId);
	});

	$('#tablespera').on('shown.bs.tab', function() {
		if (data.rbdId != null)
			tableLEspera(data.rbdId, data.concursoId);
	});

	$('#tabticket').on('shown.bs.tab', function() {
		if (data.rbdId != null)
			tableTickets(data.rbdId, data.concursoId);
	});

	$('#tabcontacto').on('shown.bs.tab', function() {
		if (data.rbdId != null)
			tableContactos(data.rbdId);
	});

	$('#ees_table').DataTable({
		"bFilter" : false,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"scrollY" : 140,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 1, "asc" ] ],
		"responsive" : true,
		"pagingType" : "full_numbers"
	});

	$('#ees-lespera').DataTable({
		"bFilter" : false,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 1, "asc" ] ],
		"responsive" : true,
		"pagingType" : "full_numbers"
	});
	$('#ees-contactos').DataTable({
		"bFilter" : false,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 1, "asc" ] ],
		"responsive" : true,
		"pagingType" : "full_numbers"
	});
	
	$('#ees-adjudicacion').DataTable({
		"bFilter" : false,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 1, "asc" ] ],
		"responsive" : true,
		"pagingType" : "full_numbers"
	});
	
	$('#ees-instalacion').DataTable({
		"bFilter" : false,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 1, "asc" ] ],
		"responsive" : true,
		"pagingType" : "full_numbers"
	});
	
});

function tableInstalacion(rbdId, concursoId) {

	$('#ees_instalacion').DataTable({
		"bDestroy" : true,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"bFilter" : false,
		"order" : [ [ 2, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"iDisplayLength" : "10",
		"scrollY" : 110,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"lengthChange" : false,
		"ordering" : true,
		"searching" : false,
		"responsive" : true,
		"ajax" : {
			"type" : 'GET',
			"contentType" : 'application/json',
			"url" : 'eesinstalacion.json',
			"beforeSend": function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			},
			"dataType" : 'json',
			"error" : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			},
			"data" : {
				"rbd_id" : rbdId,
				"concurso_id" : concursoId
			}
		},
		"columnDefs" : [ 
			{"defaultContent" : "-","targets" : "_all"},
			{"targets": [ 6 ],className: "dt-right" },
			{"targets": [ 7 ],className: "dt-right" },
			{"targets": [ 8 ],className: "dt-right" }
		],
		"columns" : [ {
			"title" : "Rbd",
			"data" : "rbd"
		}, {
			"title" : "Concurso",
			"data" : "concurso"
		}, {
			"title" : "Estado",
			"data" : "estado"
		}, {
			"title" : "Operadora",
			"data" : "operadora"
		}, {
			"title" : "Tecnología",
			"data" : "tecnologia"
		}, {
			"title" : "Fecha FAS",
			"data" : "fechaFas"
		}, {
			"title" : "Vel. Bajada (Kbps)",
			"data" : "velocidadBajada"
		}, {
			"title" : "Vel. Subida (Kbps)",
			"data" : "velocidadSubida"
		}, {
			"title" : "Precio Mensual",
			"data" : "precioMensual"
		}, {
			"title" : "FAS",
			"data" : "fas"
		} ]
	});
}

function tableAdjudicacion(rbdId, concursoId) {

	$('#ees_adjudicacion').DataTable({
		"bDestroy" : true,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		
		"processing" : true,
		"serverSide" : true,
		"bDestroy" : true,
		"bFilter" : false,
		"lengthChange" : false,
		"scrollY" : 200,
		"scrollX" : true,
		"responsive" : true,
		"dom" : '<"toolbar">frtip',
		"paging" : true,
		"ordering" : true,
		"info" : true,
		"searching" : false,
		"order" : [ [ 2, "asc" ] ],
		"pagingType" : "full_numbers",
		
		
		
	//	"bFilter" : false,
	//	"order" : [ [ 2, "asc" ] ],
	//	"pagingType" : "full_numbers",
	//	"paging" : true,
	//	"iDisplayLength" : "10",
	//	"scrollY" : 100,
	//	"scrollX" : true,
	//	"dom" : '<"toolbar">frtip',
	//	"lengthChange" : false,
	//	"ordering" : true,
	//	"searching" : false,
	//	"responsive" : true,
		
		
		"ajax" : {
			"type" : 'GET',
			"contentType" : 'application/json',
			"url" : 'eesadjudicacion.json',
			"dataType" : 'json',
			"beforeSend": function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			},
			"error" : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			},
			"data" : {
				"rbd_id" : rbdId,
				"concurso_id" : concursoId
			}
		},
		"columnDefs" : [ 
			{"defaultContent" : "-","targets" : "_all"},
			{"targets": [ 5 ],className: "dt-right" },
			{"targets": [ 6 ],className: "dt-right" },
			{"targets": [ 7 ],className: "dt-right" }
			],
		"columns" : [ {
			"title" : "Rbd",
			"data" : "rbd"
		}, {
			"title" : "Concurso",
			"data" : "concurso"
		}, {
			"title" : "Estado",
			"data" : "estado"
		}, {
			"title" : "Operadora",
			"data" : "operadora"
		}, {
			"title" : "Tecnología",
			"data" : "tecnologia"
		}, {
			"title" : "Vel. Bajada (Kbps)",
			"data" : "velocidadBajada"
		}, {
			"title" : "Vel. Subida (Kbps)",
			"data" : "velocidadSubida"
		}, {
			"title" : "Precio Mensual",
			"data" : "precioMensual"
		}, {
			"title" : "Tipo Adjudicación",
			"data" : "tipo"
		}, {
			"title" : "Fecha adjudicación",
			"data" : "fechaAdjudicacion"
		} ]
	});
}

function tableLEspera(rbdId, concursoId) {

	$('#ees_lespera').DataTable({
		"bDestroy" : true,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"bFilter" : false,
		"order" : [ [ 2, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"iDisplayLength" : "10",
		"lengthChange" : false,
		"ordering" : true,
		"ordering" : true,
		"searching" : false,
		"responsive" : true,
		"ajax" : {
			"type" : 'GET',
			"contentType" : 'application/json',
			"url" : 'eeslespera.json',
			"dataType" : 'json',
			"beforeSend": function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			},
			"error" : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			},
			"data" : {
				"rbd_id" : rbdId,
				"concurso_id" : concursoId
			}
		},
		"columnDefs" : [ {
			"defaultContent" : "-",
			"targets" : "_all"
		} ],
		"columns" : [ {
			"title" : "Rbd",
			"data" : "rbd"
		}, {
			"title" : "Concurso",
			"data" : "concurso"
		}, {
			"title" : "Tipo Lista",
			"data" : "tipoLista"
		}, {
			"title" : "Tecnología",
			"data" : "tecnologia"
		}, {
			"title" : "Operadora",
			"data" : "operadora"
		}, {
			"title" : "Vel. Bajada (Kbps)",
			"data" : "velocidadBajada"
		}, {
			"title" : "Vel. Subida (Kbps)",
			"data" : "velocidadSubida"
		}, {
			"title" : "Precio",
			"data" : "precioMensual"
		} ]
	});
}

function tableContactos(rbdId) {

	$('#ees_contactos').DataTable({
		"bDestroy" : true,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"bFilter" : false,
		"order" : [ [ 1, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"iDisplayLength" : "10",
		"lengthChange" : false,
		"ordering" : true,
		"searching" : false,
		"responsive" : true,
		"ajax" : {
			"type" : 'GET',
			"contentType" : 'application/json',
			"url" : 'eescontactos.json',
			"dataType" : 'json',
			"beforeSend": function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			},
			"error" : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			},
			"data" : {
				"id" : rbdId
			}
		},
		"columnDefs" : [ {
			"defaultContent" : "-",
			"targets" : "_all"
		} ],
		"columns" : [ {
			"title" : "Rbd",
			"data" : "rbd"
		}, {
			"title" : "Nombre",
			"data" : "nombre"
		}, {
			"title" : "Cargo",
			"data" : "cargo"
		}, {
			"title" : "Teléfono 1",
			"data" : "fono1"
		}, {
			"title" : "Teléfono 2",
			"data" : "fono2"
		}, {
			"title" : "Email",
			"data" : "mail"
		} ]
	}).columns.adjust().draw();
}

function tableTickets(rbdId, concursoId) {

	$('#ees_ticket').DataTable({
		"bDestroy" : true,
		"oLanguage" : {
			"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
		},
		"bFilter" : false,
		"order" : [ [ 2, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"scrollY" : 100,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"iDisplayLength" : "10",
		"lengthChange" : false,
		"ordering" : true,
		"searching" : false,
		"responsive" : true,
		"ajax" : {
			"type" : 'GET',
			"contentType" : 'application/json',
			"url" : 'eestickets.json',
			"dataType" : 'json',
			"beforeSend": function(xhr){
			        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
			 },
			"error" : function(xhr, error, thrown) {
				setError(xhr.status, xhr.responseText);
			},
			"data" : {
				"rbd_id" : rbdId,
				"concurso_id" : concursoId
			}
		},
		"columnDefs" : [ {
			"defaultContent" : "-",
			"targets" : "_all"
		} ],
		"columns" : [ {
			"title" : "Rbd",
			"data" : "rbd"
		}, {
			"title" : "Ticket ABA",
			"data" : "nroTicketCallCenter"
		}, {
			"title" : "Generado Operadora",
			"data" : function(data, type, row) {
				return (data.generadoOperadora == true)?"Si":"No";
			}
		}, {
			"title" : "Generado Por",
			"data" : "operadora"
		}, {
			"title" : "Fecha Apertura",
			"data" : "fechaAtencion"
		}, {
			"title" : "Origen",
			"data" : "origen"
		}, {
			"title" : "Categoría",
			"data" : "categoria"
		}, {
			"title" : "Tipo",
			"data" : "tipo"
		}, {
			"title" : "Motivo",
			"data" : "motivo"
		}, {
			"title" : "Estado",
			"data" : "estado"
		}, {
			"title" : "Ticket Operadora",
			"data" : "nroTicketEscalado"
		} ]
	});
}

function limpiarOpciones() {

	document.getElementById("filtros").reset();
}

function filtrarEES() {

	var concurso = ($("#concursoE").val() == "") ? null : $("#concursoE").val();
	var adjudicacion = ($("#estadoE").val() == "") ? null : $("#estadoE").val();
	var subadjudicacion = ($("#subestadoE").val() == "") ? null : $(
			"#subestadoE").val();
	var conexion = ($("#estadoC").val() == "") ? null : $("#estadoC").val();
	var region = ($("#regionE").val() == "") ? null : $("#regionE").val();
	var comuna = ($("#comunaE").val() == "") ? null : $("#comunaE").val();
	var rbd = ($("#rbd").val() == "") ? null : $("#rbd").val();
	var nombre = ($("#nombre").val() == "") ? null : $("#nombre").val();

	if (concurso != null || adjudicacion != null || subadjudicacion != null || conexion != null
			|| region != null || comuna != null || rbd != null || nombre != null) {

		$('#ees_table').DataTable({
				"processing" : true,
				"oLanguage" : {
					"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
				},
				"serverSide" : true,
				"bDestroy" : true,
				"bFilter" : false,
				"responsive" : true,
				"order" : [ [ 0, "asc" ] ],
				"pagingType" : "full_numbers",
				"scrollY" : 140,
				"scrollX" : true,
				"dom" : '<"toolbar">frtip',
				"paging" : true,
				"ordering" : true,
				"info" : true,
				"searching" : false,
				
				"ajax" : {
					"url" : "eesrbd.html",
					"type" : "POST",
					"contentType" : "application/json",
					"dataType" : "json",
					"beforeSend": function(xhr){
					        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
					},
					"error" : function(xhr, error, thrown) {
						setError(xhr.status, xhr.responseText);
					},
					"data" : function(data) {
						var columns = [ "rbd", "concurso",
								"subEstadoAdjudicado",
								"estadoMineduc", "estadoConectado",
								"nombreEES", "direccion", "comuna",
								"region" ];

						var dataRes = {
							filtro : {
								fechaIni : null,
								fechaFin : null,
								categoria : null,
								tipo : null,
								estadoTicket : null,
								concurso : concurso,
								operadora : null,
								estado : adjudicacion,
								subestado : subadjudicacion,
								instalacion : conexion,
								mineduc : null,
								tecnologia : null,
								region : region,
								comuna : comuna,
								rbd : rbd,
								nombre : nombre,
								rbds : null
							},
							opciones : {
								draw : data.draw,
								start : data.start,
								length : data.length,
								columns : columns,
								sortColumn : data.order[0].column,
								sortDir : data.order[0].dir
							}
						};

						return JSON.stringify(dataRes);
					}
				},
				"columnDefs" : [ 
					{"defaultContent" : "-","targets" : "_all"},
					{"targets": [ 0 ],className: "dt-right" }
				],
				"columns" : [ {
					"data" : "rbd"
				}, {
					"data" : "concurso"
				}, {
					"data" : "estadoAdjudicado"
				}, {
					"data" : "estadoMineduc"
				}, {
					"data" : "estadoConectado"
				}, {
					"data" : "nombreEES"
				}, {
					"data" : "direccion"
				}, {
					"data" : "comuna"
				}, {
					"data" : "region"
				} ]
			});
	} else {

		$.notify({
			// options
			icon : 'glyphicon glyphicon-warning-sign',
			message : 'Debe colocar al menos un valor en el filtro.'
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
}
