<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	
	$(document).ready(function() {
		$('#ees-lespera').DataTable({
			"bFilter": false,
			"pagingType": "full_numbers"
			});
		$('#ees-contactos').DataTable({
			"bFilter": false,
			"pagingType": "full_numbers"
			});
		$('#ees-adjudicacion').DataTable({
			"bFilter": false,
			"pagingType": "full_numbers"
			});
		$('#ees-instalacion').DataTable({
			"bFilter": false,
			"pagingType": "full_numbers"
			});
	});
</script>
<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-12">
		<form id="ees-detalle" class="form-horizontal" role="form">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="rbd">RBD</label>
						<div class="col-lg-9 col-md-9">
							<input type = "number" id="rbd" name="rbd" class="form-control" value="${ees.rbd}" disabled />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="direccion">Dirección</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="direccion" name="direccion" value="${ ees.direccion }" class="form-control" disabled />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="conectado">Instalación</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="conectado" name="conectado" value="${ ees.estadoConectado }" class="form-control" disabled />
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="nombre">Nombre</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" size = "250" id="nombre" name="nombre" value="${ees.nombreEES}" class="form-control" disabled />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="comuna">Comuna</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="comuna" name="comuna" value="${ ees.comuna }" class="form-control" disabled />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="adjudicado">Adjudicación</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="adjudicado" name="adjudicado" value="${ ees.subEstadoAdjudicado }" class="form-control" disabled />
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="form-group">
							<label class="control-label col-lg-3 col-md-3" for="matricula">Matrícula</label>
						<div class="col-lg-9 col-md-9">
							<input type = "number" id="matricula" name="matricula" value="${ees.matricula}" class="form-control" disabled />
						</div>
					</div>
					<div class="form-group">
							<label class="control-label col-lg-3 col-md-3" for="region">Región</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="region" name="region" value="${ ees.region }" class="form-control" disabled />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-3 col-md-3" for="adjudicado">Mineduc</label>
						<div class="col-lg-9 col-md-9">
							<input type = "text" id="mineduc" name="mineduc" value="${ ees.estadoMineduc }" class="form-control" disabled />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<div class="row modal-tab">
	<div class="col-md-12 col-lg-12">

		<div id="tab" class="panel with-nav-tabs panel-default">
		
			<div class="panel-heading panel-modal">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active" ><a id="tab-instalacion" href="#instalacion"
						data-toggle="tab">Instalación</a></li>
					<li><a id="tab-adjudicacion" href="#adjudicacion" 
						data-toggle="tab">Adjudicación</a></li>
					<li><a id="tab-lespera" href="#lespera"
						data-toggle="tab">Ofertas de Lista de Espera</a></li>
					<li><a id="tab-ticket" href="#ticket"
					data-toggle="tab">Tickets</a></li>
					<li><a id="tab-contacto" href="#contacto"
					data-toggle="tab">Contactos</a></li>
				</ul>
			</div>
			
			<div class="tab-content panel-body">
				<div id="instalacion" class="tab-pane fade in active">
					<table id="ees-instalacion" class="display compact" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Estado</th>
				                <th>Operadora</th>
				                <th>Tecnología</th>
				                <th>Fecha FAS</th>
				                <th>Vel. Bajada (Kbps)</th>
				                <th>Vel. Subida (Kbps)</th>
				                <th>Precio Mensual</th>
				                <th>FAS</th>
				            </tr>
				        </thead>
				        
				        <tbody>
  								<tr>
  									<td>${ees.estadoConectado}</td>
  									<td>${ees.instalacion.operadora}</td>
  									<td>${ees.instalacion.tecnologia}</td>
  									<td>${ees.instalacion.fechaFas}</td>
  									<td>${ees.instalacion.velocidadBajada}</td>
  									<td>${ees.instalacion.velocidadSubida}</td>
  									<td>${ees.instalacion.precioMensual}</td>
  									<td>${ees.instalacion.fas}</td>
  								</tr>
				        </tbody>
				        
				        <tfoot>
				        </tfoot>
				        
				    </table>
				</div>
				<div id="adjudicacion" class="tab-pane fade in">
				
					<table id="ees-adjudicacion" class="display compact" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Tipo</th>
				                <th>Estado</th>
				                <th>Operadora</th>
				                <th>Tecnología</th>
				                <th>Vel. Bajada (Kbps)</th>
				                <th>Vel. Subida (Kbps)</th>
				                <th>Precio Mensual</th>
				                <th>Concurso</th>
				                <th>Fecha adjudicación</th>
				            </tr>
				        </thead>
				        
				        <tbody>
							<tr>
								<td>${ees.adjudicacion.tipo}</td>
								<td>${ees.subEstadoAdjudicado}</td>
								<td>${ees.adjudicacion.operadora}</td>
								<td>${ees.adjudicacion.tecnologia}</td>
								<td>${ees.adjudicacion.velocidadBajada}</td>
								<td>${ees.adjudicacion.velocidadSubida}</td>
								<td>${ees.adjudicacion.precioMensual}</td>
								<td>${ees.adjudicacion.codigoConcurso}</td>
								<td>${ees.adjudicacion.fechaAdjudicacion}</td>
							</tr>
				        </tbody>
				        
				        <tfoot>
				        </tfoot>
				        
				    </table>
				    
				</div>
				<div id="lespera" class="tab-pane fade in">
				
					<table id="ees-lespera" class="display compact" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Concurso</th>
				                <th>Tipo Lista</th>
				                <th>Tecnología</th>
				                <th>Operadora</th>
				                <th>Vel. Bajada (Kbps)</th>
				                <th>Vel. Subida (Kbps)</th>
				                <th>Precio</th>
				            </tr>
				        </thead>
				        
				        <tbody>
				            <c:forEach items="${ees.listaEspera}" var="item">
   								<tr>
   									<td>${item.codigoConcurso}</td>
   									<td>${item.tipoLista}</td>
   									<td>${item.tecnologia}</td>
   									<td>${item.operadora}</td>
   									<td>${item.velocidadBajada}</td>
   									<td>${item.velocidadSubida}</td>
   									<td>${item.precioMensual}</td>
   								</tr>
							</c:forEach>
				        </tbody>
				        
				        <tfoot>
				        </tfoot>
				        
				    </table>
				    
				</div>
				<div id="ticket" class="tab-pane fade in">
				</div>
				<div id="contacto" class="tab-pane fade in">
					
					<table id="ees-contactos" class="display compact" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Nombre</th>
				                <th>Cargo</th>
				                <th>Teléfono 1</th>
				                <th>Teléfono 2</th>
				                <th>Email</th>
				            </tr>
				        </thead>
				        
				        <tbody>
				            <c:forEach items="${ees.contactos}" var="contacto">
   								<tr>
   									<td>${ees.estadoConectado}</td>
   									<td>${contacto.cargo}</td>
   									<td>${contacto.fono1}</td>
   									<td>${contacto.fono2}</td>
   									<td>${contacto.mail}</td>
   								</tr>
							</c:forEach>
				        </tbody>
				        
				        <tfoot>
				        </tfoot>
				        
				    </table>
				</div>
			</div>
		</div>
	</div>
</div>
