<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-6 col-md-6 col-lg-6">
		
		<table class= "table">
			<tr>
				<td> <b> Ticket ABA </b> </td>
				<td>${ticket.nroTicketCallCenter}</td>
			</tr>
			<tr>
				<td> <b> RBD </b> </td>
				<td>${ticket.rbd}</td>
			</tr>
			<tr>
				<td> <b> Anexo </b> </td>
				<td>${ticket.anexo}</td>
			</tr>
			<tr>
				<td> <b> Nombre EES </b> </td>
				<td>${ticket.nombreEstablecimiento}</td>
			</tr>
			<tr>
				<td> <b> Región </b> </td>
				<td>${ticket.region}</td>
			</tr>
			<tr>
				<td> <b> Comuna </b> </td>
				<td>${ticket.comuna}</td>
			</tr>
			<tr>
				<td> <b> Generado por Operadora </b> </td>
				<td>${ticket.generadoOperadora?"Si":"No"}</td>
			</tr>
			<tr>
				<td> <b> Operadora </b> </td>
				<td>${ticket.operadora}</td>
			</tr>
			<tr>
				<td> <b> Tecnología </b> </td>
				<td>${ticket.tecnologia}</td>
			</tr>
			<tr>
				<td> <b> Origen </b> </td>
				<td>${ticket.origen}</td>
			</tr>
			<tr>
				<td> <b> Estado Ticket </b> </td>
				<td>${ticket.estado}</td>
			</tr>
		</table>
	
	</div>
	
	<div class="col-sm-6 col-md-6 col-lg-6">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<label>Comentario</label>
		</div>
		<div class="col-sm-12 col-md-12 col-lg-12">
			<p>${ticket.comentario}<p>
		</div>
	</div>
</div>
