<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- requires functions.jsp -->
<script src="<c:url value="/resources/js/ees.js" />"></script>
<script src="<c:url value="/resources/js/util.js" />"></script>

<div class="row">
	<div class="col-md-12 col-lg-12 col-centered">
		<form:form id="filtros" class="form-horizontal" role="form"
			commandName="filtros" action="ees.html">
			<div class="row row-centered">
				<div class="col-lg-10 col-md-10" style="text-align: center;">
					<div class="col-lg-6 col-md-6 col-sm-6 col-centered">
						<div class="form-group">
							<label class="control-label col-lg-4 col-md-4" for="concurso">Concurso</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="concurso" id="concursoE" name="concursoE"
									class="form-control form-control-sm">
									<form:option value="" label="  "></form:option>
									<form:options items="${concurso}" itemValue="id"
										itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-4 col-md-4" for="rbd">RBD</label>
							<div class="col-lg-8 col-md-8">
								<input type="number" id="rbd" name="rbd" class="form-control form-control-sm"
									min="1" />
							</div>
						</div>
						<div class="form-group">
							<label for="region" class="control-label col-lg-4 col-md-4">Región</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="region" id="regionE" name="regionE"
									class="form-control form-control-sm"
									onchange="getComunas($(this).val(), 'comunaE')">
									<form:option value="" label="  "></form:option>
									<form:options items="${region}" itemValue="id"
										itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="comuna" class="control-label col-lg-4 col-md-4">Comuna</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="comuna" id="comunaE" name="comunaE"
									class="form-control form-control-sm">
									<form:option value="" label="  "></form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<div class="form-group">
							<div class="control-label col-lg-4 col-md-4" style="margin-top: 0px; padding-top: 0px;">
								<label class="control-label" for="nombre">Nombre</label>
							</div>
							<div class="col-lg-8 col-md-8">
								<input type="text" size="250" id="nombre" name="nombre"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label for="estado" class="control-label col-lg-4 col-md-4 ">Estado
								Adjudicación</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="estado" id="estadoE" name="estadoE"
									class="form-control form-control-sm"
									onchange="getSubAdjudicacion($(this).val())">
									<form:option value="" label="  "></form:option>
									<form:options items="${adjudicacion}" itemValue="id"
										itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="sub-estado" class="control-label col-lg-4 col-md-4">Subestado
								Adj.</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="subestado" id="subestadoE" name="subestadoE"
									class="form-control form-control-sm">
									<form:option value="" label="  "></form:option>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="estado" class="control-label col-lg-4 col-md-4">Estado
								Conexión</label>
							<div class="col-lg-8 col-md-8">
								<form:select path="estado" id="estadoC" name="estadoC"
									class="form-control form-control-sm">
									<form:option value="" label="  "></form:option>
									<form:options items="${conexion}" itemValue="id"
										itemLabel="nombre" />
								</form:select>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-2">
					<br><br><br><br>
					<div class="form-group btns" style="text-align: left;">
						<button id="buscar" name="buscar" type="button" onclick="javascript:filtrarEES();"
							class="btn btn-primary fa fa-search">Buscar</button>
						<button id="limpiar" name="limpiar" type="button" data-target="#example" onclick="javascript:limpiarOpciones();"
							class="btn btn-warning fa fa-eraser">Limpiar</button>
					</div>
				</div>	
			</div>
		</form:form>
	</div>
</div>

<div class="row" style="margin-top: 10px;">
	<div class="col-md-12 col-lg-12">
		<table id="ees_table" class="table display nowrap cell-border"
			cellspacing="0" width="100%">

			<thead>
				<tr>
					<th class="text-center">RBD</th>
					<th class="text-center">CONCURSO</th>
					<th class="text-center">ESTADO ADJUDICACION</th>
					<th class="text-center">ESTADO MINEDUC</th>
					<th class="text-center">ESTADO CONEXIÓN</th>
					<th class="text-center">NOMBRE EES</th>
					<th class="text-center">DIRECCIÓN</th>
					<th class="text-center">COMUNA</th>
					<th class="text-center">REGIÓN</th>
				</tr>
			</thead>

			<tbody>

			</tbody>

			<tfoot>
			</tfoot>

		</table>
	</div>
</div>
<div class="row" style="margin-top: 10px;">
	<div class="col-md-12 col-lg-12">
		<div id="tab" class="panel with-nav-tabs panel-default">
			<div class="panel-heading panel-modal">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a id="tabinstalacion" href="#instalacion"
						data-toggle="tab">Instalación</a></li>
					<li><a id="tabadjudicacion" href="#adjudicacion"
						data-toggle="tab">Adjudicación</a></li>
					<li><a id="tablespera" href="#lespera" data-toggle="tab">Ofertas
							de Lista de Espera</a></li>
					<li><a id="tabticket" href="#ticket" data-toggle="tab">Tickets</a></li>
					<li><a id="tabcontacto" href="#contacto" data-toggle="tab">Contactos</a></li>
				</ul>
			</div>

			<div class="tab-content panel-body">
				<div id="instalacion" class="tab-pane fade in active">
					<table id="ees_instalacion" class=" table display nowrap cell-border" cellspacing="0" width="100%">
						
					</table>
				</div>
				<div id="adjudicacion" class="tab-pane fade in">
					<table id="ees_adjudicacion" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					</table>
				</div>
				<div id="lespera" class="tab-pane fade in">
					<table id="ees_lespera" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					</table>
				</div>
				<div id="ticket" class="tab-pane fade in">
					<table id="ees_ticket" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					</table>
				</div>
				<div id="contacto" class="tab-pane fade in">
					<table id="ees_contactos" class="display" cellspacing="0" width="100%">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Modal -->
<div id="ticket-modal" class="modal fade" role="dialog">
	<div class="modal-dialog  modal-lg" role="document">

		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Detalle de Ticket</h4>
			</div>

			<div class="modal-body" id="html-ticket"></div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>
