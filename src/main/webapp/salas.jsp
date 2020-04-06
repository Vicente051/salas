<%@ include file="/encabezados/header.jsp"%>
<div class="container mt-4 periko_img">
	<form:form>
		<div class="row">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Id</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/salas_idAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/salas_idDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">							
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Nombre</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/salas_nombreAsc">Ordenar de la A-Z</a>
									<a class="dropdown-item" href="/salas_nombreDesc">Ordenar de la Z-A</a>
								</div>
							</div> 
						</th>
						<th scope="col">							
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Aforo</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/salas_aforoAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/salas_aforoDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">Medios Tecnicos</th>
						<th scope="col">Horarios</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${salas}" var="sala">
						<tr>							
							<th scope="row">${sala.id}<input type="hidden" name="id" value="${sala.id}"/></th>
							<td>${sala.nombre}</td>
							<td>${sala.aforo}</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-info dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Medios Técnicos</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<c:forEach items="${sala.lista_medios_tecnicos}"
											var="medio_tecnico">
											<a class="dropdown-item">${medio_tecnico.nombre}</a>
										</c:forEach>
									</div>
								</div>
							</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-info dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Horarios</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<c:forEach items="${sala.lista_horarios}" var="horario">
											<a class="dropdown-item">De ${horario.hinicio} a
												${horario.hfinal}</a>
										</c:forEach>
									</div>
								</div>
							</td>								
							<td>
								<div class="text-center">
									<a class="btn btn-warning" href="admin/editarSala/${sala.id}">Editar</a>
								</div>
							</td>
							<td>
								<div class="text-center">

									<!-- Button Borrar modal -->
									<a type="button" class="btn btn-primary" data-toggle="modal"
										data-target="#borrarModal" href="/admin/borrarSala/${sala.id}">Borrar</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<a href="/admin/agregarSala" class="btn btn-primary">Agregar Sala</a>
		</div>
		
		<!-- Borrar Modal -->
		<%@ include file="/modales/borrarModal.jsp"%>
	</form:form>
</div>

<%@ include file="/encabezados/footer.jsp"%>