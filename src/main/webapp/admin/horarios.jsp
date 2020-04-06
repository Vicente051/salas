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
									<a class="dropdown-item" href="/admin/horarios_idAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/admin/horarios_idDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">							
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Hora inicial</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/admin/horarios_iniAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/admin/horarios_iniDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">							
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Hora final</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/admin/horarios_finAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/admin/horarios_finDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">Listado Salas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${horarios}" var="horario">
						<tr>							
							<th scope="row">${horario.id}<input type="hidden" name="id" value="${horario.id}"/></th>
							<td>${horario.hinicio}</td>
							<td>${horario.hfinal}</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-info dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Salas</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<c:forEach items="${horario.salas}" var="sala">
											<a class="dropdown-item">${sala.nombre}</a>
										</c:forEach>
									</div>
								</div>
							</td>															
							<td>
								<div class="text-center">
									<a class="btn btn-warning" href="/admin/editarHorario/${horario.id}">Editar</a>
								</div>
							</td>
							<td>
								<div class="text-center">

									<!-- Button Borrar modal -->
									<a type="button" class="btn btn-primary" href="/admin/borrarHorario/${horario.id}">Borrar</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<a href="/admin/agregarHorario" class="btn btn-primary">Agregar Horario</a>
		</div>
		
		<!-- Borrar Modal -->
		<%@ include file="/modales/borrarModal.jsp"%>
	</form:form>
</div>

<%@ include file="/encabezados/footer.jsp"%>