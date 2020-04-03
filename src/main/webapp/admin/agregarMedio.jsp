<%@ include file="/encabezados/header.jsp" %>

<form:form method="post" action="/admin/guardarMedio" modelAttribute="medio">
	<div class="container mt-4 periko_img">
		<div class="row">
			<div class="col-md-12">
				<h1>Medio ${medio.id}</h1>
				<div class="form-row">
					<div>
						<input type="hidden" name="id" value="${medio.id}" />
					</div>					
					<div class="form-group col-md-6">
						<label for="nombre">Medio Técnico</label>
						<form:input path="nombre" type="text"
								class="form-control" id="nombre" value="${medio.nombre}"
								placeholder="Introduzca un nombre para el medio ténico..." required="required"
								minlength="2" maxlength="50"></form:input>
							<form:errors path="nombre" 	class="form-error">${errors.nombre}</form:errors>
					</div>
				</div>
				<div class="text-center">
					<!-- Button Editar modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#editarModal">Guardar</button>
					<a href="/admin/medios" class="btn btn-secondary">Volver</a>
					<button type="reset" class="btn btn-info">Limpiar Datos</button>

					<!-- Editar Modal -->
					<%@ include file="/modales/editarModal.jsp"%>

				</div>
			</div>
		</div>
	</div>
</form:form>

<%@ include file="/encabezados/footer.jsp" %>