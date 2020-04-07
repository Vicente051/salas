<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="container col-sm sombreado">
	<h4 class="card-title text-center"><B>Horarios disponibles para el evento ${evento.nombre}</B></H4>
	<p><B>Fecha del evento: </B> ${evento.fecha}<br/></p>
	<form:form method="post" action="/manager/fijarHorario" modelAttribute="evento">
		<div class="form-check">
          		<p><B>Horarios disponibles: </B> </p>
          		<c:forEach items="${evento.lista_horarios}" var="sala_horario">
			 	<p><input class="form-check-input" type="checkbox" name="lista_horarios" value="${sala_horario.id}" id="lista_horarios" checked style="width: 15px; height:15px;">
			 	De ${sala_horario.hinicio} a ${sala_horario.hfinal}</p>
			 </c:forEach>
		</div>
	</form:form>
	<div class="text-center pt-4">
		<a href="addAula" class="btn btn-primary">Enviar preferencias</a>
		<a href="eventos" class="btn btn-primary">Volver</a>
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
