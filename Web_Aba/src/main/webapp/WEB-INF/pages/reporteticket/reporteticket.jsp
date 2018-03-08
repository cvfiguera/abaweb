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
					<li class="active"><a id="tabTickets" href="#tickets"
						data-toggle="tab">Tickets</a></li>
				</ul>
			</div>
			<div class="tab-content panel-body">
				<div id="tickets" class="tab-pane fade in active">
					<div id="report_Ticket"></div>
				</div>
			</div>
		</div>
	</div>
		<script>
				
			$('#report_Ticket').jstree({
				'core' : {
					'data' : {
						"url" : "reporteTicket.html",
						"dataType" : "json" // needed only if you do not supply JSON headers
					}
				}
			});
			
			$('#report_Ticket').bind("dblclick.jstree",function(e, data) {

						var file_data = [];
						
						var objTreeView = $("#report_Ticket");
						var selectedNodes = objTreeView.jstree(true).get_selected();
						
						for (var i = 0; i < selectedNodes.length; i++) {
							var full_node = objTreeView.jstree(true).get_node(
									selectedNodes[i]);
							file_data[i] = objTreeView.jstree(true).get_path(
									full_node, "/");
						};
						$.ajax({
							type : 'GET',
							url : 'downloadFile/ticket.html',
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
		</div>