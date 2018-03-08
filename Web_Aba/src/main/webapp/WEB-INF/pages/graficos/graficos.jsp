<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- requires functions.jsp -->
<script src="<c:url value="/resources/js/graficos.js" />"> </script>
    
<div class="row">
	<div class="col-md-12">
		<div id="tab" class="panel with-nav-tabs panel-default">
			<div class="panel-heading">
				<ul class="nav nav-tabs">
			        <li class="active" ><a href="#graficoCero" data-toggle="tab">Concurso</a></li>
			        <li><a href="#graficoUno" data-toggle="tab">Adjudicación</a></li>
			        <li><a href="#graficoDos" data-toggle="tab">Mineduc</a></li>
			        <li><a href="#graficoTres" data-toggle="tab">Instalación</a></li>
			        <li><a href="#graficoCuatro" data-toggle="tab">Operadora</a></li>
			        <li><a href="#graficoCinco" data-toggle="tab">Tecnología</a></li>
			        <li><a href="#graficoSeis" data-toggle="tab">Región</a></li>
				</ul>
			</div>
			
			<div class="tab-content panel-body" id="tabs">
      
		        <div class="tab-pane fade in active" id="graficoCero">
			          <div class="col-md-2 text-left">
				            <h5>Concurso X : Establecimiento al cual le fue adjudicado el servicio de conectividad.</h5>
				            <h5>Concurso Y : Establecimiento al cual no fue adjudicado el servicio de conectividad. </h5>
				          	<h5>Presione el gráfico y luego el <b>Detalle</b> para ver el estado Mineduc.</h5>
			          </div>
			          <div class="col-md-10 graf" id="grafico0"></div>
		     	</div>
		     	
		     	<div class="tab-pane fade in" id="graficoUno">
			          <div class="col-md-2 text-left">
				            <h5>Adjudicado : Establecimiento al cual le fue adjudicado el servicio de conectividad.</h5>
				            <h5>No Adjudicado : Establecimiento al cual no fue adjudicado el servicio de conectividad. </h5>
				          	<h5>Presione el gráfico y luego el <b>Detalle</b> para ver el estado Mineduc.</h5>
			          </div>
			          <div class="col-md-10 graf" id="grafico1"></div>
		     	</div>

        		<div class="tab-pane fade in" id="graficoDos">
		        	<div class="col-md-2 text-left">
			              <h5 >
			                Confirmado : El establecimiento cuenta con las exigencias de MINEDUC.
			              </h5>
			              <h5>
			             	 Rechazado : El establecimiento no cuenta con las exigencias de MINEDUC.
			              </h5>
			          	<h5>Presione el gráfico y luego el <b>Detalle</b> para ver el estado Conectado.</h5>
		          	</div>
	          		<div class="col-md-10" id="grafico2"></div>
	        	</div>
       
       			<div class="tab-pane fade in" id="graficoTres">
        			<div class="col-md-2 text-left">
		          		<h5>
		                	No conectado : Establecimiento que no cuenta con servicio de conectividad debido a infactibilidad técnica u otras razones administrativas.
		              	</h5>
		                <h5>
		                	Desconectado : Establecimiento que estuvo conectado pero fue desconectado al perder el patrocinio de MINEDUC u otras razones administrativas.
		                </h5>
          				<h5>Presione el gráfico y luego <b>Detalle</b> para ver los datos por operadoras.</h5>
          			</div>
          			<div class="col-md-10" id="grafico3"></div>
       			</div>
       
        		<div class="tab-pane fade in" id="graficoCuatro">
			        <div class="col-md-2 text-left">
		                <h5>Distribución por Operador respecto a los Estados seleccionados.</h5>
			          	<h5>Presione el gráfico y luego el <b>Detalle</b> para ver los datos por tecnología.</h5>
		            </div>
			        <div class="col-md-10" id="grafico4"></div>	
        		</div>
       		
        		<div class="tab-pane fade in" id="graficoCinco">
		        	<div class="col-md-2 text-left">
			            <h5>Se presenta la distribución de las Tecnologías del Operador seleccionado.</h5>
			          	<h5>Presione el gráfico y luego el <b>Detalle</b> para ver los datos por región.</h5>
		          	</div>
		          	<div class="col-md-10" id="grafico5"></div>
        		</div>
        		<div class="tab-pane fade in" id="graficoSeis">
       				<div class="col-md-2 text-left">
            			<h5>Distribución por Regiones de la Tecnologí­a seleccionada.</h5>
          				<h5>Presione el gráfico para ver los datos.</h5>
          			</div>
          			<div class="col-md-10" id="grafico6"></div>
        		</div>
     			</div>
		</div>
	</div>
</div>


