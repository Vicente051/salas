<jsp:directive.include file="/encabezados/cabecera.jsp" />
<jsp:directive.include file="/encabezados/menu.jsp" />

<div class="container sombreado">
	<form:form method="post" action="/admin/guardarMedio" modelAttribute="medio">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">Editar ${medio.nombre}</h3>
				<div class="form-row">
					<div>
						<input type="hidden" name="id" value="${medio.id}" />
					</div>					
					<div class="form-group col-md-6">
						Cambiar nombre
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
					<a href="/admin/medios" class="btn btn-primary">Volver</a>

					<!-- Editar Modal -->
					<%@ include file="/modales/editarModal.jsp"%>

				</div>
			</div>
		</div>
		
	</form:form>
</div>
<jsp:directive.include file="/encabezados/pie.jsp" />