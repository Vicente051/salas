<%@ include file="/encabezados/header.jsp" %>

<c:forEach items="${errores}" var="error">

	Existe error: ${errores}
	
</c:forEach>
	
	<form:form method="post" action="/admin/guardarSala" modelAttribute="sala">
		<div class="container mt-4 periko_img">
			<div class="row">
				<div class="col-md-12">
					<h1>Sala ${sala.id}</h1>
					<div class="form-row">
						<div>
							<input type="hidden" name="id" value = "${sala.id}"/>
						</div>
						<div class="form-group col-md-3">
							<label for="nombre">Nombre Sala</label>
							<form:input path="nombre" type="text"
								class="form-control" id="nombre" value="${sala.nombre}"
								placeholder="Introduzca un nombre para la sala..." required="required"
								minlength="2" maxlength="50"></form:input>
							<form:errors path="nombre" 	class="form-error">${errors.nombre}</form:errors>
						</div>
						<div class="form-group col-md-3">
							<label for="aforo">Aforo Sala</label>
							<form:input path="aforo" type="number"
								class="form-control" id="aforo" value="${sala.aforo}"
								placeholder="Introduzca el aforo de la sala..." required="required"
								min="2" max="150"></form:input>
							<form:errors path="aforo" class="form-error">${errors.aforo}</form:errors>
						</div>
						
						<div class="form-group col-md-3">
						<label for="medios_tecnicos">Medios Técnicos</label>						
						<c:forEach items="${sala.lista_medios_tecnicos}" var="sala_medio_tecnico">
							<div class="form-check">
							  <input name="lista_medios_tecnicos" class="form-check-input" type="checkbox" 
							  	value="${sala_medio_tecnico.id}" id="lista_medios_tecnicos" checked>
							  <label class="form-check-label" for="lista_medios_tecnicos">
							  	${sala_medio_tecnico.nombre}</label>
							 </div>
						</c:forEach>
						<c:forEach items="${medios_tecnicos}" var="medio_tecnico">
							<div class="form-check">
							  	<input name="lista_medios_tecnicos" class="form-check-input" type="checkbox" 
							  	value="${medio_tecnico.id}" id="lista_medios_tecnicos">
							  <label class="form-check-label" for="lista_medios_tecnicos">
							  	${medio_tecnico.nombre}</label>	
							 </div>
						</c:forEach>
						</div>
						
						<div class="form-group col-md-3">
						<label for="horarios">Horarios</label>						
						<c:forEach items="${sala.lista_horarios}" var="sala_horario">
							<div class="form-check">
							  <input name="lista_horarios" class="form-check-input" type="checkbox" 
							  	value="${sala_horario.id}" id="lista_horarios" checked>
							  <label class="form-check-label" for="lista_horarios">
							  	De ${sala_horario.hinicio} a ${sala_horario.hfinal}</label>
							 </div>
						</c:forEach>
						<c:forEach items="${horarios}" var="horario">
							<div class="form-check">
							  <input name="lista_horarios" class="form-check-input" type="checkbox" 
							  	value="${horario.id}" id="lista_horarios">
							  <label class="form-check-label" for="lista_horarios">
							  	De ${horario.hinicio} a ${horario.hfinal}</label>
							 </div>
						</c:forEach>
						</div>
					</div>				
				<div class="text-center">				
					<!-- Button Editar modal -->					
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarModal">
					  Guardar
					</button>
					<a href="/salas" class="btn btn-secondary">Volver</a>
					<button type="reset" class="btn btn-info">Limpiar Datos</button>
					
					<!-- Editar Modal -->
					<%@ include file="/modales/editarModal.jsp"%>
								
				</div>
			</div>
			</div>
		</div>
	</form:form>
	
<%@ include file="/encabezados/footer.jsp" %>