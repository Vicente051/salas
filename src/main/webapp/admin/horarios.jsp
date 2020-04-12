<jsp:directive.include file="/encabezados/cabecera.jsp" />
<jsp:directive.include file="/encabezados/menu.jsp" />

<div class="container">
	<h2 class="text-center"><B>Horarios</B></h2>
	<form:form>
		<div class="text-center pt-4" style="margin-bottom: 15px;">
			<a href="/admin/agregarHorario" class="btn btn-primary">Agregar Horario</a>
			<a href="/salas" class="btn btn-primary">Volver</a>
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Id</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/admin/horarios_idAsc">Ordenar de menor a mayor</a>
					<a class="dropdown-item" href="/admin/horarios_idDesc">Ordenar de mayor a menor</a>
				</div>
			</div> 
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Hora inicial</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/admin/horarios_iniAsc">Ordenar de menor a mayor</a>
					<a class="dropdown-item" href="/admin/horarios_iniDesc">Ordenar de mayor a menor</a>
				</div>
			</div> 
									
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Hora final</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/admin/horarios_finAsc">Ordenar de menor a mayor</a>
					<a class="dropdown-item" href="/admin/horarios_finDesc">Ordenar de mayor a menor</a>
				</div>
			</div> 				
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${horarios}" var="horario">
					<div class="card mb-4 mr-4 sombreado" style="width: 340px;">
				  		<div class="card-body">
							<h5 class="card-title text-center"><B>De ${horario.hinicio} a ${horario.hfinal}</B></h5>
							<img src="../img/horarios.jpg" width="290" style="border-radius: 10px; margin-bottom: 10px;">
						    <p class="card-text"><B>ID del horario:</B> ${horario.id}<br/></p>
						    
						    <p class="card-text mb-1"><B>Salas que usan este horario:</B><br/></p>
						    <c:forEach items="${horario.salas}" var="sala">
						    	<p class="card-text" style="margin-left: 15px; font-size: 90%; line-height: 10px;">-${sala.nombre}<br/></p>
						    </c:forEach>
						    <div class="text-center pt-4">
								<a  class="btn btn-primary" href="/admin/editarHorario${horario.id}">Editar</a>
								<a type="button" class="btn btn-primary" href="/admin/borrarHorario${horario.id}">Borrar</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- Borrar Modal -->
		<%@ include file="/modales/borrarModal.jsp"%>
	</form:form>
</div>

<jsp:directive.include file="/encabezados/pie.jsp" />
