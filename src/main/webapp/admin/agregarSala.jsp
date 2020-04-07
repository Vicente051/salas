<jsp:directive.include file="/encabezados/cabecera.jsp" />
<jsp:directive.include file="/encabezados/menu.jsp" />


<c:forEach items="${errores}" var="error">

	Existe error: ${errores}
	
</c:forEach>

<div class="container sombreado">
	<H4>Modificar sala</H4>
    <form:form method="post" action="/admin/guardarSala" modelAttribute="sala">
	    <div class="row">
	    	<div class="form-group col-6">
	    		Nombre de la sala:
	        	<input type="text" name="nombre" id="nombre" value="${sala.nombre}" class="form-control" placeholder="Nombre de la sala" required autofocus>
	        </div>
	        <div class="form-group col-6">
				Aforo:
		        <input type="number" name="aforo" id="aforo" class="form-control" value="${sala.aforo}" placeholder="Introduzca el aforo">
	      	</div>
	    </div>
        <div class="row" style="margin-top:15px;">
        	<div class="col-6">
        		<div class="form-check">
        			<H5>Medios técnicos:</H5>
        			<c:forEach items="${sala.lista_medios_tecnicos}" var="sala_medio_tecnico">
		 				<p><input class="form-check-input" type="checkbox" name="lista_medios_tecnicos" value="${sala_medio_tecnico.id}" id="lista_medios_tecnicos" checked style="width: 15px; height:15px;">
		 				${sala_medio_tecnico.nombre}</p>
		 			</c:forEach>
		 			<c:forEach items="${medios_tecnicos}" var="medio_tecnico">
		 			<p><input class="form-check-input" type="checkbox" name="lista_medios_tecnicos" value="${sala_medio_tecnico.id}" id="lista_medios_tecnicos" style="width: 15px; height:15px;">
		 				${medio_tecnico.nombre}</p>
		 			</c:forEach>
				</div>
			</div> 
            <div class="col-6">
            	<div class="form-check">
            		<H5>Horarios:</H5>
            		<c:forEach items="${sala.lista_horarios}" var="sala_horario">
					 	<p><input class="form-check-input" type="checkbox" name="lista_horarios" value="${sala_horario.id}" id="lista_horarios" checked style="width: 15px; height:15px;">
					 	De ${sala_horario.hinicio} a ${sala_horario.hfinal}</p>
					 </c:forEach>
					 <c:forEach items="${horarios}" var="horario">
					 <p><input class="form-check-input" type="checkbox" name="lista_horarios" value="${horario.id}" id="lista_horarios" style="width: 15px; height:15px;">
					 	De ${horario.hinicio} a ${horario.hfinal}</p>
					 </c:forEach>
				</div>
			</div>
		</div>
	
        <div class="text-center pt-4">
        	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarModal">
        		Guardar cambios
        	</button>
        	<button type="button" class="btn btn-primary" onclick="history.back()">Volver</button>
        </div>
        <!-- Editar Modal -->
		<%@ include file="/modales/editarModal.jsp"%>
	</form:form>
</div>	

<jsp:directive.include file="/encabezados/pie.jsp" />
