<jsp:directive.include file="/encabezados/cabecera.jsp" />
<jsp:directive.include file="/encabezados/menu.jsp" />

<div class="container">

	<form:form>
	<div class="text-center pt-4" style="margin-bottom: 15px;">
			<a href="/admin/agregarSala" class="btn btn-primary">Agregar Sala</a>
			<a href="/admin/medios" class="btn btn-primary">Medios</a>
			<a href="/admin/horarios" class="btn btn-primary">Horarios</a>
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Id</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/salas_idAsc">Ordenar de menor a mayor</a>
					<a class="dropdown-item" href="/salas_idDesc">Ordenar de mayor a menor</a>
				</div>
			</div> 
									
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Nombre</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/salas_nombreAsc">Ordenar de la A-Z</a>
					<a class="dropdown-item" href="/salas_nombreDesc">Ordenar de la Z-A</a>
				</div>
			</div> 
								
			<div class="btn-group">
				<button type="button" class="btn btn-secondary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Aforo</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="/salas_aforoAsc">Ordenar de menor a mayor</a>
					<a class="dropdown-item" href="/salas_aforoDesc">Ordenar de mayor a menor</a>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${salas}" var="sala">
					<div class="card mb-4 mr-4 sombreado" style="width: 340px;">
					  <div class="card-body">
					    <h5 class="card-title text-center"><B>${sala.nombre}</B></h5>
					    <img src="../img/sala.jpg" width="290" style="border-radius: 10px; margin-bottom: 10px;">
					    <p class="card-text"><B>ID de la sala:</B> ${sala.id}<br/></p>
					    <p class="card-text"><B>Capacidad de la sala:</B>${sala.aforo}<br/></p>
					    
					    <p class="card-text mb-1"><B>Medios de la sala:</B><br/></p>
					    <c:forEach items="${sala.lista_medios_tecnicos}" var="medio_tecnico">
					    	<p class="card-text" style="margin-left: 15px; font-size: 90%; line-height: 10px;">-${medio_tecnico.nombre}<br/></p>
					    </c:forEach>
					
					
				    	<p class="card-text mb-1"><B>Horarios de la sala:</B><br/></p>
					    <c:forEach items="${sala.lista_horarios}" var="horario">
					    	<p class="card-text" style="margin-left: 15px; font-size: 90%; line-height: 10px;">-De ${horario.hinicio} a ${horario.hfinal}<br/></p>
					    </c:forEach>
					    
					    <div class="text-center pt-4" style="bottom 0px;">
							<a  class="btn btn-primary" href="admin/editarSala${sala.id}">Editar sala</a>
							<a type="button" class="btn btn-primary" data-toggle="modal" data-target="#borrarModal" href="/admin/borrarSala${sala.id}">Borrar</a>
						</div>
					  </div>
					</div>
				</c:forEach>
			<!-- Borrar Modal -->
			<%@ include file="/modales/borrarModal.jsp"%>
			</div>
		</div>
	</form:form>
</div>

<jsp:directive.include file="/encabezados/pie.jsp" />