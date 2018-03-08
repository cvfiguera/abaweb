$(document).ready(function() {
	iniTablaEscuelas();
	iniTablaFas();
	iniTablaTickets();
	
		// Datatable FAS - Modal
	$('#fas_table').on('dblclick','tr',function() {
		var table = $('#fas_table').DataTable();
		var tr = $(this);
		var row = table.row(tr);
		var data = row.data();
		$('#pdf-fas').html('<object data="'+ data.url+ '" type="application/pdf" width="100%" height="100%"></object>');
		$('#fas-modal').modal('show');
	});
	$('#fas-modal').on('show.bs.modal',function() {
		$('.modal .modal-body').css('overflow-y','auto');
		$('.modal .modal-body').css('height',
		$(window).height() * 0.7);
	});
		// Datatable Ticket - Modal
	$('#ticket_table').on('dblclick','tr',function() {
		var table = $('#ticket_table').DataTable();
		var row = table.row($(this));
		var data = row.data();
		$.ajax({
			type : 'GET',
			url : 'ticketmodal.html',
			beforeSend : function(xhr) {
				xhr.setRequestHeader($("meta[name='_csrf_header']")
						.attr("content"), $("meta[name='_csrf']").attr("content"));
			},
		data : {"id" : data.nroTicketCallCenter},
		success : function(response) {$('#html-ticket').html(response);},
		error : function(xhr, error, thrown) {
			setError(xhr.status, xhr.responseText);
								}
		});
	$('#ticket-modal').modal('show');
	});
});

function iniTablaFas() {

	$('#fas_table')
	.DataTable(
	{
		"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
		"bDestroy" : true,
		"destroy":true,
		"data":[],
		"lengthChange" : false,
		"bFilter" : false,
		"order" : [ [ 1, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"ordering" : true,
		"responsive" : true,
		"searching" : false,
		"processing" : true,
		"scrollY" : 200,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"info" : true
	});
}

function filtrarFas() {

	var rbds = $("#rbdsF").val();
	var rbdsArray = (rbds == "") ? null : rbds.split(";");

	if (rbdsArray != null && validarRbds(rbdsArray)) {
		var rbdsArray = rbds.split(";");
		$('#fas_table').DataTable(
		{
			"processing" : true,
			"serverSide" : true,
			"bDestroy" : true,
			"bFilter" : false,
			"lengthChange" : false,
			"responsive" : true,
			"order" : [ [ 3, "asc" ] ],
			"pagingType" : "full_numbers",
			"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
			"scrollY" : 200,
			"scrollX" : true,
			"dom" : '<"toolbar">frtip',
			"paging" : true,
			"ordering" : true,
			"searching" : false,

			"ajax" : {
				"url" : "fas.html",
				"type" : "POST",
				"contentType" : "application/json",
				"dataType" : "json",
				"beforeSend" : function(xhr) {
					xhr.setRequestHeader($(
						"meta[name='_csrf_header']").attr(
						"content"), $("meta[name='_csrf']")
						.attr("content"));
				},
				"error" : function(xhr, error, thrown) {
					setError(xhr.status, xhr.responseText);
				},
				"data" : function(data) {
					var columns = [ "numFAS", "rbd",
					"concurso", "nombreEES",
					"operadora", "estadoConectado",
					"fechaFAS", "tecnologia",
					"velocidadBajada",
					"velocidadSubida" ];

					var dataRes = {
						filtro : {
							fechaIni : null,
							fechaFin : null,
							categoria : null,
							tipo : null,
							estadoTicket : null,
							concurso : null,
							operadora : null,
							estado : null,
							subestado : null,
							instalacion : null,
							mineduc : null,
							tecnologia : null,
							region : null,
							comuna : null,
							rbd : null,
							nombre : null,
							rbds : rbdsArray
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
				{"targets": [ 1 ],className: "dt-right" },
				{"targets": [ 8 ],className: "dt-right" },
				{"targets": [ 7 ],className: "dt-right" }
				],
			"columns" : [ {
				"data" : "numFAS"
			}, {
				"data" : "rbd"
			}, {
				"data" : "concurso"
			}, {
				"data" : "nombreEES"
			}, {
				"data" : "operadora"
			}, {
				"data" : "estadoConectado"
			}, {
				"data" : "fechaFAS"
			}, {
				"data" : "tecnologia"
			}, {
				"data" : "velocidadBajada",
				"className" : "col-right"
			}, {
				"data" : "velocidadSubida",
				"className" : "col-right"
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

function iniTablaEscuelas() {

	$('#escuelas_table')
	.DataTable(
	{	
		"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
		"bDestroy" : true,
		"destroy":true,
		"data":[],
		"lengthChange" : false,
		"bFilter" : false,
		"order" : [ [ 1, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"ordering" : true,
		"responsive" : true,
		"searching" : false,
		"processing" : true,
		"scrollY" : 200,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"info" : true
	});
}

function filtrarEscuelas(accion) {

	var concurso = ($("#concursoE").val() == "") ? null : $("#concursoE").val();
	var operadora = ($("#operadoraE").val() == "") ? null : $("#operadoraE").val();
	var adjudicacion = ($("#estadoE").val() == "") ? null : $("#estadoE").val();
	var subadjudicacion = ($("#subestadoE").val() == "") ? null : $("#subestadoE").val();
	var instalacion = ($("#instalacionE").val() == "") ? null : $("#instalacionE").val();
	var mineduc = ($("#mineducE").val() == "") ? null : $("#mineducE").val();
	var tecnologia = ($("#tecnologiaE").val() == "") ? null : $("#tecnologiaE").val();
	var region = ($("#regionE").val() == "") ? null : $("#regionE").val();
	var comuna = ($("#comunaE").val() == "") ? null : $("#comunaE").val();
	var rbds = $("#rbds").val();
	var rbdsArray = (rbds == "") ? null : rbds.split(";");

	if (concurso != null || operadora != null || adjudicacion != null
		|| subadjudicacion != null || instalacion != null
		|| mineduc != null || tecnologia != null || region != null
		|| comuna != null || (rbdsArray != null && validarRbds(rbdsArray))) {
		if (accion == 1){
			$('#escuelas_table').DataTable({
				"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
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
				"ajax" : {
					"url" : "escuelas.json",
					"type" : "POST",
					"beforeSend" : function(xhr) {
						xhr.setRequestHeader($(
							"meta[name='_csrf_header']")
						.attr("content"), $(
							"meta[name='_csrf']").attr(
							"content"));
					},
					"contentType" : "application/json",
					"dataType" : "json",
					"error" : function(xhr, error, thrown) {
						setError(xhr.status, xhr.responseText);
					},
					"data" : function(data) {

						var columns = [ 
						"rbd", 
						"concurso",
						"nombreEES", 
						"region",
						"comuna", 
						"direccion",
						"matricula",
						"subEstadoAdjudicado",
						"estadoConectado",
						"estadoMineduc", 
						"tecnologia",
						"operadora", 
						"precioMensual",
						"velocidadBajada",
						"velocidadSubida", 
						"fechaFAS" ];

						var dataRes = {
							filtro : {
								fechaIni : null,
								fechaFin : null,
								categoria : null,
								tipo : null,
								estadoTicket : null,
								concurso : concurso,
								operadora : operadora,
								estado : adjudicacion,
								subestado : subadjudicacion,
								instalacion : instalacion,
								mineduc : mineduc,
								tecnologia : tecnologia,
								region : region,
								comuna : comuna,
								rbd : null,
								nombre : null,
								rbds : rbdsArray
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
					{"defaultContent" : "-","targets" : "_all"} ,
					{"targets": [ 6 ],className: "dt-right" },
					{"targets": [ 0 ],className: "dt-right" },
					{"targets": [ 12 ],className: "dt-right" },
					{"targets": [ 13 ],className: "dt-right" },
					{"targets": [ 14 ],className: "dt-right" }
					],
				"columns" : [ 
								
					
					{"data" : "rbd"}, 
					{"data" : "concurso"}, 
					{"data" : "nombreEES"}, 
					{"data" : "region"}, 
					{"data" : "comuna"}, 
					{"data" : "direccion"}, 
					{"data" : "matricula"}, 
					{"data" : "subEstadoAdjudicado"}, 
					{"data" : "estadoConectado"}, 
					{"data" : "estadoMineduc"}, 
					{"data" : "tecnologia"}, 
					{"data" : "operadora"}, 
					{"data" : "precioMensual"}, 
					{"data" : "velocidadBajada"}, 
					{"data" : "velocidadSubida"}, 
					{"data" : "fechaFAS"}

				]
			});
		} else if (accion == 2) {

			url = "reportes/escuelas.xls?";
			url += "concurso=" + $("#concursoE").val() + "&";
			url += "operadora=" + $("#operadoraE").val() + "&";
			url += "estado=" + $("#estadoE").val() + "&";
			url += "subestado=" + $("#subestadoE").val() + "&";
			url += "instalacion=" + $("#instalacionE").val() + "&";
			url += "mineduc=" + $("#mineducE").val() + "&";
			url += "tecnologia=" + $("#tecnologiaE").val() + "&";
			url += "region=" + $("#regionE").val() + "&";
			url += "comuna=" + $("#comunaE").val() + "&";
			url += "rbds=" + $("#rbds").val();

			window.location.href = url;
		}

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

function iniTablaTickets() {

	$('#ticket_table')
	.DataTable(
	{
		"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
		"bDestroy" : true,
		"destroy":true,
		"data":[],
		"lengthChange" : false,
		"bFilter" : false,
		"order" : [ [ 1, "asc" ] ],
		"pagingType" : "full_numbers",
		"paging" : true,
		"ordering" : true,
		"responsive" : true,
		"searching" : false,
		"processing" : true,
		"scrollY" : 200,
		"scrollX" : true,
		"dom" : '<"toolbar">frtip',
		"info" : true
	});
}

function filtrarTickets(accion) {

	var fechaIni = ($("#fechaIni").val() == "") ? null : $("#fechaIni").val();
	var fechaFin = ($("#fechaFin").val() == "") ? null : $("#fechaFin").val();
	var categoria = ($("#categoria").val() == "") ? null : $("#categoria").val();
	var tipo = ($("#tipo").val() == "") ? null : $("#tipo").val();
	var estadoTicket = ($("#estadoTicket").val() == "") ? null : $("#estadoTicket").val();
	var operadora = ($("#operadora").val() == "") ? null : $("#operadora").val();
	var tecnologia = ($("#tecnologia").val() == "") ? null : $("#tecnologia").val();
	var region = ($("#regionT").val() == "") ? null : $("#regionT").val();
	var comuna = ($("#comunaT").val() == "") ? null : $("#comunaT").val();
	var rbds = $("#rbdsT").val();
	var rbdsArray = (rbds == "") ? null : rbds.split(";");

	if (fechaIni != null || fechaFin != null || categoria != null
		|| tipo != null || estadoTicket != null || operadora != null
		|| tecnologia != null || region != null || comuna != null
		|| (rbdsArray != null && validarRbds(rbdsArray))) {
		if (accion == 1) {
			$('#ticket_table').DataTable(
			{
				"processing" : true,
				"serverSide" : true,
				"bDestroy" : true,
				"bFilter" : false,
				"order" : [ [ 2, "asc" ] ],
				"lengthChange" : false,
				"pagingType" : "full_numbers",
				"responsive" : true,
				"oLanguage" : {"sUrl" : "https://cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"},
				"scrollY" : 200,
				"scrollX" : true,
				"dom" : '<"toolbar">frtip',
				"paging" : true,
				"ordering" : true,
				"info" : true,
				"searching" : false,
				"ajax" : {
					"url" : "tickets.html",
					"type" : "POST",
					"contentType" : "application/json",
					"dataType" : "json",
					"beforeSend" : function(xhr) {
						xhr.setRequestHeader($("meta[name='_csrf_header']")
								.attr("content"), $("meta[name='_csrf']").attr("content"));},
					"error" : function(xhr, error, thrown) {setError(xhr.status, xhr.responseText);},
					"data" : function(data) {
						var columns = [ 
							"rbd", 
							"concurso",
							"nroTicketCallCenter",
							"region",
							"nombreEstablecimiento",
							"comuna", 
							"generadoOperadora",
							"fechaAtencion", 
							"origen",
							"categoria", 
							"tipo", 
							"motivo",
							"estado", 
							"operadora",
							"tecnologia",
							"nroTicketEscalado", 
							"escalarA" ];
						var dataRes = {
							filtro : {
								fechaIni : fechaIni,
								fechaFin : fechaFin,
								categoria : categoria,
								tipo : tipo,
								estadoTicket : estadoTicket,
								operadora : operadora,
								tecnologia : tecnologia,
								region : region,
								comuna : comuna,
								rbds : rbdsArray
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
					{"targets": [ 0 ],className: "dt-right" },
					{"targets": [ 2 ],className: "dt-right" }],
				"columns" : [ 
					{"data" : "rbd"}, 
					{"data" : "concurso"}, 
					{"data" : "nroTicketCallCenter"}, 
					{"data" : "region"}, 
					{"data" : "nombreEstablecimiento"}, 
					{"data" : "comuna"}, 
					{"data" : function(data, type, row) {
							return (data.generadoOperadora == true)?"Si":"No";
						}
					},
					{"data" : "fechaAtencion"}, 
					{"data" : "origen"}, 
					{"data" : "categoria"}, 
					{"data" : "tipo"}, 
					{"data" : "motivo"}, 
					{"data" : "estado"}, 
					{"data" : "operadora"}, 
					{"data" : "tecnologia"}, 
					{"data" : "nroTicketEscalado"}, 
					{"data" : "escalarA"} 
					]
			});
		} else if (accion == 2) {

			url = "reportes/tickets.xls?";
			url += "fechaIni=" + $("#fechaIni").val() + "&";
			url += "fechaFin=" + $("#fechaFin").val() + "&";
			url += "categoria=" + $("#categoria").val() + "&";
			url += "tipo=" + $("#tipo").val() + "&";
			url += "estado=" + $("#estadoTicket").val() + "&";
			url += "operadora=" + $("#operadora").val() + "&";
			url += "tecnologia=" + $("#tecnologiaE").val() + "&";
			url += "region=" + $("#regionE").val() + "&";
			url += "comuna=" + $("#comunaE").val() + "&";
			url += "rbds=" + $("#rbds").val();

			window.location.href = url;
		}

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

function limpiarOpciones() {

//	document.getElementById("filtros").reset();
//	document.getElementById("filtrosTicket").reset();
//	document.getElementById("filtrosFas").reset();
//	var table=$('#escuelas_table').DataTable();
//	var rows = table.rows().remove().draw();
//	$('#escuelas_table').DataTable().destroy();
	iniTablaEscuelas();
	
}

function exportarEscuelas() {

}

function validarRbds(rbdsArray) {

	if (rbdsArray != null) {
		var largo = false;
		var nonum = false;

		for (var i = 0; i < rbdsArray.length; i++) {

			if (isNaN(rbdsArray[i])) {
				nonum = true;
			} else {

				if (rbdsArray[i].length > 18) {
					largo = true;
				}
			}
		}

		if (nonum) {
			$.notify({
				// options
				icon : 'glyphicon glyphicon-warning-sign',
				message : 'Alguno de los RBDs introducidos no es numérico.'
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

			return false;
		} else if (largo) {
			$
			.notify(
			{
								// options
								icon : 'glyphicon glyphicon-warning-sign',
								message : 'Alguno de los RBDs introducidos es de longitud no válida.'
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

			return false;
		}

		return true;
	} else {
		return false;
	}
}