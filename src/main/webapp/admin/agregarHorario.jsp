<%@ include file="/encabezados/header.jsp" %>

<form:form method="post" action="/admin/guardarHorario" modelAttribute="horario">
	<div class="container mt-4 periko_img">
		<div class="row">
			<div class="col-md-12">
				<h1>Horario ${horario.id}</h1>
				<div class="form-row">
					<div>
						<input type="hidden" name="id" value="${horario.id}" />
					</div>					
					<div class="form-group col-md-6">
						<label for="nombre">Hora inicial</label>
 						<form:input path="hinicio" type="time" step="900" class="form-control" id="hinicio"
							value="${horario.hinicio}"	placeholder="Introduzca el inicio de la franja horaria..."
							required="required" min="08:00:00" max="23:00:00"></form:input>
						<form:errors path="hinicio" class="form-error">${errors.hinicio}</form:errors>
					</div>
					<div class="form-group col-md-6">
						<label for="nombre">Hora final</label>
 						<form:input path="hfinal" type="time" step="900" class="form-control" id="hfinal"
							value="${horario.hfinal}"	placeholder="...Introduzca el final de la franja horaria"
							required="required" min="08:00:00" max="23:00:00"></form:input>
						<form:errors path="hinicio" class="form-error">${errors.hfinal}</form:errors>
					</div>
				</div>
				<div class="text-center">
					<!-- Button Editar modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#editarModal">Guardar</button>
					<a href="/admin/horarios" class="btn btn-secondary">Volver</a>
					<button type="reset" class="btn btn-info">Limpiar Datos</button>

					<!-- Editar Modal -->
					<%@ include file="/modales/editarModal.jsp"%>

				</div>
			</div>
		</div>
	</div>
</form:form>

<%@ include file="/encabezados/footer.jsp" %>