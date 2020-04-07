<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="container sombreado">

	<H4>Añadir nueva sala</H4>
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
		 			<c:forEach items="${medios_tecnicos}" var="medio_tecnico">
			 			<p><input class="form-check-input" type="checkbox" name="lista_medios_tecnicos" value="${medio_tecnico.id}" id="lista_medios_tecnicos" style="width: 15px; height:15px;">
			 				${medio_tecnico.medio}</p>
			 		</c:forEach>
				</div>
			</div> 
			
            <div class="col-6">
            	<div class="form-check">
            		<H5>Horarios:</H5>
					<c:forEach items="${horarios}" var="horario">
						 <p><input class="form-check-input" type="checkbox" name="lista_horarios" value="${horario.id}" id="lista_horarios" style="width: 15px; height:15px;">
						 	De ${horario.hora_inicio} a ${horario.hora_final}</p>
					</c:forEach>
				</div>
			</div>
		</div>

        <div class="text-center pt-4">
        	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarModal">Añadir aula</button>
        </div>
        <!-- Editar Modal -->
					<%@ include file="/modales/editarModal.jsp"%>
	</form:form>
</div>
<div class="text-center pt-4">
	<button type="button" class="btn btn-primary" onclick="history.back()">Volver</button>
</div>
        
<%@ include file="/../encabezados/pie.jsp" %>
