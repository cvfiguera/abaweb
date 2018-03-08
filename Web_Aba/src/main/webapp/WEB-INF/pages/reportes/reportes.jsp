<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- requires functions.jsp -->
<%-- <script src="<c:url value="/resources/js/busquedas.js" />"> </script> --%>
<%-- <script src="<c:url value="/resources/js/util.js" />"> </script> --%>


<div class="row">
	<div class="col-md-12">
		<div id="tab" class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a id="tabGestionCC" href="#gestionCallCenter"
						data-toggle="tab">Gestion Call Center</a></li>
					<li><a id="tabReporteOperadora" href="#reporteOperadora"
						data-toggle="tab">Reporte Operadora</a></li>
					<li><a id="tabGestionEntelgy" href="#gestionEntelgy"
						data-toggle="tab">Gestion Entelgy</a></li>
					<li><a id="tabEstadisticas" href="#estadisticas"
						data-toggle="tab">Estadisticas</a></li>
				</ul>
			</div>
			<div class="tab-content panel-body">
				<div id="gestionCallCenter" class="tab-pane fade in active">
					<div id="reporteCallCenter"></div>
				</div>
				<div id="reporteOperadora" class="tab-pane fade in">
					<div id="reporteO"></div>
				</div>
				<div id="gestionEntelgy" class="tab-pane fade in">
					<div id="gestionE"></div>
				</div>
				<div id="estadisticas" class="tab-pane fade in">
					<div id="estadisticaR"></div>
				</div>
			</div>
		</div>
	</div>
</div>
	<script>

		$('#reporteCallCenter').jstree({
			'core' : {
				'data' : {
					"url" : "gestionCC.html",
					"dataType" : "json" // needed only if you do not supply JSON headers
				}
			}
		});
		$('#reporteCallCenter').bind("dblclick.jstree",function(e, data){
			var file_data = [];
			
			var objTreeView = $("#reporteCallCenter");
			var selectedNodes = objTreeView.jstree(true).get_selected();
			
			for (var i = 0; i < selectedNodes.length; i++) {
				var full_node = objTreeView.jstree(true).get_node(
						selectedNodes[i]);
				file_data[i] = objTreeView.jstree(true).get_path(
						full_node, "/");
			};

			$.ajax({
				type : 'GET',
				url : 'downloadFile/gestionCallCenter.html',
				data : {
					"fil" : escape(file_data)
				},
				success : function(data) {
					//		alert(name);
					var blob = new Blob([ data ]);
					var link = document.createElement('a');
					link.href = window.URL.createObjectURL(blob);
					link.download = selectedNodes;
					link.click();
					}
				});
			});
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			var target = $(e.target).attr("href") // activated tab
			if (target == "#reporteOperadora") {
				$('#reporteO').jstree({
					'core' : {
						'data' : {
							"url" : "reporteO.html",
							"dataType" : "json" // needed only if you do not supply JSON headers
						}
					}
				});
			}
			if (target == "#gestionEntelgy") {
				$('#gestionE').jstree({
					'core' : {
						'data' : {
							"url" : "gestionE.html",
							"dataType" : "json" // needed only if you do not supply JSON headers
						}
					}
				});
			}
			if (target == "#estadisticas") {
				$('#estadisticaR').jstree({
					'core' : {
						'data' : {
							"url" : "estadisticaR.html",
							"dataType" : "json" // needed only if you do not supply JSON headers
						}
					}
				});
			}

		});

		$('#reporteO').bind("dblclick.jstree",function(e, data){
			var file_data = [];
			
			var objTreeView = $("#reporteO");
			var selectedNodes = objTreeView.jstree(true).get_selected();
			
			for (var i = 0; i < selectedNodes.length; i++) {
				var full_node = objTreeView.jstree(true).get_node(
						selectedNodes[i]);
				file_data[i] = objTreeView.jstree(true).get_path(
						full_node, "/");
			};

			$.ajax({
				type : 'GET',
				url : 'downloadFile/reporteOperadora.html',
				data : {
					"fil" : escape(file_data)
				},
				success : function(data) {
					//		alert(name);
					var blob = new Blob([ data ]);
					var link = document.createElement('a');
					link.href = window.URL.createObjectURL(blob);
					link.download = selectedNodes;
					link.click();
					}
				});
			});

		$('#gestionE').bind("dblclick.jstree",function(e, data){
			var file_data = [];
			
			var objTreeView = $("#gestionE");
			var selectedNodes = objTreeView.jstree(true).get_selected();
			
			for (var i = 0; i < selectedNodes.length; i++) {
				var full_node = objTreeView.jstree(true).get_node(
						selectedNodes[i]);
				file_data[i] = objTreeView.jstree(true).get_path(
						full_node, "/");
			};

			$.ajax({
				type : 'GET',
				url : 'downloadFile/gestionEntelgy.html',
				data : {
					"fil" : escape(file_data)
				},
				success : function(data) {
					//		alert(name);
					var blob = new Blob([ data ]);
					var link = document.createElement('a');
					link.href = window.URL.createObjectURL(blob);
					link.download = selectedNodes;
					link.click();
					}
				});
			});
		$('#estadisticaR').bind("dblclick.jstree",function(e, data){
			var file_data = [];
			
			var objTreeView = $("#estadisticaR");
			var selectedNodes = objTreeView.jstree(true).get_selected();
			
			for (var i = 0; i < selectedNodes.length; i++) {
				var full_node = objTreeView.jstree(true).get_node(
						selectedNodes[i]);
				file_data[i] = objTreeView.jstree(true).get_path(
						full_node, "/");
			};

			$.ajax({
				type : 'GET',
				url : 'downloadFile/reporteEstadisticas.html',
				data : {
					"fil" : escape(file_data)
				},
				success : function(data) {
					//		alert(name);
					var blob = new Blob([ data ]);
					var link = document.createElement('a');
					link.href = window.URL.createObjectURL(blob);
					link.download = selectedNodes;
					link.click();
					}
				});
			});

	</script>