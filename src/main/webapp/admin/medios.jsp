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
									<a class="dropdown-item" href="/admin/medios_idAsc">Ordenar de menor a mayor</a>
									<a class="dropdown-item" href="/admin/medios_idDesc">Ordenar de mayor a menor</a>
								</div>
							</div> 
						</th>
						<th scope="col">							
							<div class="btn-group">
								<button type="button" class="btn btn-secondary dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Nombre Medio</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="/admin/medios_nombreAsc">Ordenar de la A-Z</a>
									<a class="dropdown-item" href="/admin/medios_nombreDesc">Ordenar de la Z-A</a>
								</div>
							</div> 
						</th>
						<th scope="col">Listado Salas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${medios}" var="medio">
						<tr>							
							<th scope="row">${medio.id}<input type="hidden" name="id" value="${medio.id}"/></th>
							<td>${medio.nombre}</td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-info dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Salas</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<c:forEach items="${medio.salas}" var="sala">
											<a class="dropdown-item">${sala.nombre}</a>
										</c:forEach>
									</div>
								</div>
							</td>															
							<td>
								<div class="text-center">
									<a class="btn btn-warning" href="/admin/editarMedio/${medio.id}">Editar</a>
								</div>
							</td>
							<td>
								<div class="text-center">
									<!-- Button Borrar modal QUITAR EL MODAL SI NO LIO PADRE AL BORRAR-->
									<a type="button" class="btn btn-primary" href="/admin/borrarMedio/${medio.id}">Borrar</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<a href="/admin/agregarMedio" class="btn btn-primary">Agregar Medio</a>
		</div>
		
		<!-- Borrar Modal -->
		<%@ include file="/modales/borrarModal.jsp"%>
	</form:form>
</div>

<%@ include file="/encabezados/footer.jsp"%>