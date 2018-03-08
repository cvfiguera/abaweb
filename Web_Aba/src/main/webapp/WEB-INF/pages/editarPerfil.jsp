<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/editarPerfil.js"></script>

<div id="perfilModal" class="modal fade" role="dialog">
	<div class="modal-dialog" role="document">

		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Editar Contraseña</h4>
			</div>

			<div class="modal-body">
				<div class="row">
					<div
						class="col-sm-9 col-md-9 col-lg-9 col-md-offset-1 col--offset-1">
						<form id="perfil" class="form-horizontal" role="form">
							<div id="pass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="name">Nombre:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										id="name" name="name" class="form-control" disabled />
								</div>
								<p id="error-name" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div id="pass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="lastname">Apellido:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										id="lastname" name="lastname" class="form-control" disabled />
								</div>
								<p id="error-name" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div id="pass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="pass">Email:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope"></i></span> <input type="email"
										id="email" name="email" class="form-control" />
								</div>
								<p id="error-email" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div id="pass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="pass">Organización:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-briefcase"></i></span> <input type="text"
										id="org" name="org" class="form-control" disabled />
								</div>
								<p id="error-org" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div class="form-group">
								<div class="checkbox col-lg-12 col-md-12">
									<label for="cambiar" class="control-label">
										<input type="checkbox" id="cambiar" name="cambiar"/>Cambiar contraseña
									</label>
								</div>
							</div>
							<div style="margin-top:5px;" id="pass-group" class="form-group">
								<label class="control-label  col-lg-4 col-md-4" for="cambiar">Contraseña
									actual:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										disabled = "true" id="pass" name="pass" class="form-control" />
								</div>
								<p id="error-pass" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div id="newpass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="newpass">Nueva
									contraseña:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										disabled = "true" id="newpass" name="newpass" class="form-control" />
								</div>
								<p id="error-newpass" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<div id="repass-group" class="form-group">
								<label class="control-label col-lg-4 col-md-4" for="repass">Repetir
									contraseña:</label>
								<div class="input-group col-lg-8 col-md-8">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										disabled = "true" id="repass" name="repass" class="form-control" />
								</div>
								<p id="error-repass" class="has-error col-lg-12 col-md-12">
								<p>
							</div>
							<br>
							<div class="btns form-group col-md-12">
								<button onClick="editarPerfil()" id="aceptar" type="button"
									class="btn btn-primary fa fa-save">Aceptar</button>
								<button id="cancelar" type="button"
									class="btn btn-warning fa fa-cancel" data-dismiss="modal">Cancelar</button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="modal-footer"></div>

		</div>

	</div>
</div>
