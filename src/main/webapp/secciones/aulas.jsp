<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="text-center pt-4" style="margin-bottom: 15px;">
	<a href="/addAula" class="btn btn-primary">Añadir aula</a>
</div>
		
<div class="container">
		<div class="card-columns">
		
<!-- BUCLE DE RECORRIDO DE AULAS -->
<c:forEach items="${salas}" var="sala">
	<div class="card mb-3 sombreado" style="width: 340px;">
	  <div class="card-body">
	    <h5 class="card-title text-center"><B><c:out value="${sala.nombre}"/></B></h5>
	    <p class="card-text"><B>ID de la sala:</B> <c:out value="${sala.id}"/><br/></p>
	    <p class="card-text"><B>Capacidad de la sala:</B><c:out value="${sala.aforo}"/> personas.<br/></p>
	    <p class="card-text"><B>Medios de la sala:</B><br/></p>
	    <c:forEach items="${sala.lista_medios_tecnicos}" var="medio_tecnico">
	    	<p class="card-text">-<c:out value="${medio_tecnico.medio}"/><br/></p>
	    </c:forEach>
	    <p class="card-text"><B>Horarios de la sala:</B><br/></p>
	    <c:forEach items="${sala.lista_horarios}" var="horario">
	    	<p class="card-text">-De <c:out value="${horario.hora_inicio}"/> a <c:out value="${horario.hora_final}"/><br/></p>
	    </c:forEach>
	    <div class="text-center pt-4">
			    	<a  class="btn btn-primary" href="admin/editarSala/${sala.id}">Ver sala</a>
			    </div>
	  </div>
	</div>
</c:forEach>
<!-- FIN DE BUCLE DE RECORRIDO DE AULAS-->
		
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>