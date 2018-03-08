<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- requires functions.jsp -->
<script src="<c:url value="/resources/js/busquedas.js" />"> </script>
<script src="<c:url value="/resources/js/util.js" />"> </script>

<div class="row">
	<div class="col-md-12">
		<div id="tab" class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active" ><a
						id="tabescuelas" href="#escuelas"
						data-toggle="tab">Escuelas</a></li>
					<li><a id="tabticket" href="#ticket" data-toggle="tab">Ticket</a></li>
					<li><a id="tabfas" href="#fas"
						data-toggle="tab">Formulario Alta Servicio</a></li>
				</ul>
			</div>
			<div class="tab-content panel-body">
				<div id="escuelas" class="tab-pane fade in active">
					<div>
						<form:form id="filtros" class="form-horizontal" role="form" commandName="filtros"
						action="escuelas.html">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="concurso">Concurso</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="concurso" id="concursoE" name="concursoE"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${concurso}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="operadora">Operador</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="operadora" id="operadoraE" name="operadoraE"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${operadora}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="estado" class="control-label col-lg-4 col-md-4">Estado
											Adjudicación</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="estado" id="estadoE" name="estadoE"
												class="form-control" onchange="getSubAdjudicacion($(this).val())">
												<form:option value="" label="  "></form:option>
												<form:options items="${adjudicacion}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label for="sub-estado"
											class="control-label col-lg-4 col-md-4">Subestado
											Adjudicación</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="subestado" id="subestadoE" name="subestadoE"
												class="form-control">
												<form:option value="" label="  "></form:option>
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="instalacion"
											class="control-label col-lg-4 col-md-4">Estado
											Instalacion</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="instalacion" id="instalacionE"
												name="instalacionE" class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${conectado}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="mineduc" class="control-label col-lg-4 col-md-4">Estado
											Mineduc</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="mineduc" id="mineducE" name="mineducE"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${mineduc}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group col-lg-12 col-md-12">
										<p class="form-control-static">BASE AL CIERRE DE : JULIO 2016</p>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-group">
										<label for="tecnologia"
											class="control-label col-lg-2 col-md-2">Tecnología</label>
										<div class="col-lg-10 col-md-10">
											<form:select path="tecnologia" id="tecnologiaE"
												name="tecnologiaE" class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${tecnologia}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="region" class="control-label col-lg-2 col-md-2">Región</label>
										<div class="col-lg-10 col-md-10">
											<form:select path="region" id="regionE" name="regionE"
												class="form-control" onchange="getComunas($(this).val(), 'comunaE')">
												<form:option value="" label="  "></form:option>
												<form:options items="${region}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="comuna" class="control-label col-lg-2 col-md-2">Comuna</label>
										<div class="col-lg-10 col-md-10">
											<form:select path="comuna" id="comunaE" name="comunaE"
												class="form-control">
												<form:option value="" label="  "></form:option>
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-12" for="rbds">Ingrese
											RBDs separados de punto y coma(;)</label>
										<div class="col-lg-12">
											<textarea class="form-control col-lg-12" rows="3" id="rbds"
												placeholder="Ingrese RBDs"></textarea>
										</div>
									</div>
									<div class="btns form-group col-lg-12">
										<button id="buscar" name="buscar"  type="button" onclick="javascript:filtrarEscuelas(1);" class="btn btn-primary fa fa-search">Buscar</button>
										<button id="limpiar" name="limpiar" type="button" onclick="javascript:limpiarOpciones();" class="btn btn-warning fa fa-eraser">Limpiar</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
					<div>
						<table id="escuelas_table" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					        
					        <thead>
					            <tr>
					                <th class="text-center" width="100%">RBD</th>
					                <th class="text-center" >CONCURSO</th>
					                <th class="text-center">NOMBRE EES</th>
					                <th class="text-center">REGION</th>
					               	<th class="text-center">COMUNA</th>
					                <th class="text-center">DIRECCION</th>
					                <th class="text-center">MATRICULA</th>
					                <th class="text-center">ESTADO ADJUDICACION</th>
					                <th class="text-center">ESTADO INSTALACIÓN</th>
					                <th class="text-center">ESTADO MINEDUC</th>
					                <th class="text-center">TECNOLOGIA</th>
					                <th class="text-center">OPERADORA</th>
					                <th class="text-center">PRECIO MENSUAL</th>
					                <th class="text-center">VELOCIDAD BAJADA</th>
					                <th class="text-center">VELOCIDAD SUBIDA</th>
					                <th class="text-center">FECHA FAS</th>
					            </tr>
					        </thead>
					        
					        <tbody>
					           
					        </tbody>
					        
					        <tfoot>
					        </tfoot>
					        
					    </table>
					</div>
					<div class="form-group col-lg-12">
						<button id="exportar" name="exportar"  type="button" onclick="javascript:filtrarEscuelas(2);" class="btn btn-primary fa fa-table">Exportar</button>
					</div>
				</div>
				<div id="ticket" class="tab-pane fade in">
					<div>
						<form:form id="filtrosTicket" class="form-horizontal" role="form" commandName= "filtrosTicket" action="tickets.html">
							<div class="row">
							
								<div class="col-lg-6 col-md-6 col-sm-6">
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="fechaIni">Fecha Inicial</label>
										<div class="col-lg-8 col-md-8">
											<form:input type="date" path="fechaIni" id="fechaIni" class="form-control" value="${fechaIni}" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="fechaFin">Fecha Final</label>
										<div class="col-lg-8 col-md-8">
											<form:input type="date" path="fechaFin" id="fechaFin"  class="form-control" value="${fechaFin}" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="categoria">Categoría</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="categoria" id="categoria" name="categoria"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${categorias}" itemValue="nombre" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="tipo">Tipo</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="tipo" id="tipo" name="tipo"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${tipos}" itemValue="nombre" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="estado">Estado Ticket</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="estadoTicket" id="estadoTicket" name="estadoTicket"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${estados}" itemValue="nombre" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="operadora">Operadora</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="operadora" id="operadora" name="operadora"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${operadoras}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-4 col-md-4" for="tecnologia">Tecnologia</label>
										<div class="col-lg-8 col-md-8">
											<form:select path="tecnologia" id="tecnologia" name="tecnologia"
												class="form-control">
												<form:option value="" label="  "></form:option>
												<form:options items="${tecnologias}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
								</div>
								
								<div class="col-lg-6 col-md-6 col-sm-6">
									
									<div class="form-group">
										<label for="region" class="control-label col-lg-2 col-md-2">Región</label>
										<div class="col-lg-10 col-md-10">
											<form:select path="region" id="regionT" name="regionT"
												class="form-control" onchange="getComunas($(this).val(), 'comunaT')">
												<form:option value="" label="  "></form:option>
												<form:options items="${regiones}" itemValue="id"
													itemLabel="nombre" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label for="comunaT" class="control-label col-lg-2 col-md-2">Comuna</label>
										<div class="col-lg-10 col-md-10">
											<form:select path="comuna" id="comunaT" name="comunaT"
												class="form-control">
												<form:option value="" label="  "></form:option>
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-lg-12" for="rbdsT">Ingrese
											RBDs separados de punto y coma(;)</label>
										<div class="col-lg-12">
											<textarea class="form-control col-lg-12" rows="6" id="rbdsT"
												placeholder="Ingrese RBDs"></textarea>
										</div>
									</div>
								
									<div class="btns form-group col-lg-12">
										<button id="buscar" name="buscar"  type="button" onclick="javascript:filtrarTickets(1);" class="btn btn-primary fa fa-search">Buscar</button>
										<button id="limpiar" name="limpiar" type="button" data-target="#example" onclick="javascript:limpiarOpciones();" class="btn btn-warning fa fa-eraser">Limpiar</button>
									</div>
									
								</div>
							</div>
						</form:form>
					</div>
					<div>
						<table id="ticket_table" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					        
					        <thead>
					            <tr>
					                <th class="text-center">RBD</th>
					                <th class="text-center">CONCURSO</th>
					                <th class="text-center">TICKET ABA</th>
					                <th class="text-center">REGION</th>
					                <th class="text-center">NOMBRE EES</th>
					                <th class="text-center">COMUNA</th>
					                <th class="text-center">GENERADO POR OPERADORA</th>
					                <th class="text-center">FECHA DE APERTURA</th>
					                <th class="text-center">ORIGEN</th>
					                <th class="text-center">CATEGORIA</th>
					                <th class="text-center">TIPO</th>
					                <th class="text-center">MOTIVO</th>
					                <th class="text-center">ESTADO TICKET</th>
					                <th class="text-center">OPERADORA</th>
					                <th class="text-center">TECNOLOGIA</th>
					                <th class="text-center">TICKET OPERADORA</th>
					                <th class="text-center">ESCALADO A:</th>
					            </tr>
					        </thead>
					        
					        <tbody>
					           
					        </tbody>
					        
					        <tfoot>
					        </tfoot>
					        
					    </table>
					</div>
					<div class="form-group col-lg-12">
						<button id="exportarT" name="exportarT"  type="button" onclick="javascript:filtrarTickets(2);" class="btn btn-primary fa fa-table">Exportar</button>
					</div>
				</div>
				<div id="fas" class="tab-pane fade in">
					<div>
						<form:form id="filtrosFas" class="form-horizontal" role="form">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-group">
										<label class="control-label col-lg-12" for="rbdsF">Ingrese
											RBDs separados de punto y coma(;)</label>
										<div class="col-lg-12">
											<textarea class="form-control col-lg-12" rows="6" id="rbdsF"
												placeholder="Ingrese RBDs"></textarea>
										</div>
									</div>
									<div class="btns form-group col-lg-12">
										<button id="buscarFas" name="buscarFas"  type="button" onclick="javascript:filtrarFas();" class="btn btn-primary fa fa-search">Buscar</button>
										<button id="limpiarFas" name="limpiarFas" type="button" onclick="javascript:limpiarOpciones();" class="btn btn-warning fa fa-eraser">Limpiar</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
					<div>
						<table id="fas_table" class=" table display nowrap cell-border" cellspacing="0" width="100%">
					        
					        <thead>
					            <tr>
					                <th class="text-center" width = "5%">FAS</th>
					                <th class="text-center" width = "5%">RBD</th>
					                <th class="text-center" width = 6%>CONCURSO</th>
					                <th class="text-center" width = "18%">NOMBRE EES</th>
					                <th class="text-center" width = "18%">OPERADORA</th>
					                <th class="text-center" width = "10%">ESTADO INSTALACIÓN</th>
					                <th class="text-center" width = "10%">FECHA FAS</th>
					                <th class="text-center" width = "10%">TECNOLOGÍA</th>
					                <th class="text-center" width = "9%">VELOCIDAD BAJADA (Kbps)</th>
					                <th class="text-center" width = "9%">VELOCIDAD SUBIDA (Kbps)</th>
					            </tr>
					        </thead>
					        
					        <tbody>
					           
					        </tbody>
					        
					        <tfoot>
					        </tfoot>
					        
					    </table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="fas-modal" class="modal fade" role="dialog">
  <div class="modal-dialog  modal-lg" role="document">

    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Formulario de Alta de Servicio</h4>
      </div>
      
      <div class="modal-body" id="pdf-fas">

      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
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
      
      <div class="modal-body" id="html-ticket">

      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
      
    </div>

  </div>
</div>