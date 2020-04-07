<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="text-center pt-4" style="margin-bottom: 15px;">
	<a href="addEvento" class="btn btn-primary">Añadir evento</a>
</div>
<!-- BUCLE DE RECORRIDO DE EVENTOS 
<c:forEach items="${eventos}" var="eventos">

<div class="card" style="margin-bottom: 15px;">
  <div class="card-header">
    Evento <c:out value="${eventos.nombre}"/>
  </div>
  <div class="card-body">
    <h5 class="card-title">Fecha: <c:out value="${eventos.fecha}"/></h5>
    <p class="card-text">El evento es en el aula <c:out value="${eventos.id}"/>.</p>
    <a href="editEvento" class="btn btn-primary">Modificar evento</a>
  </div>
</div>
</c:forEach>
FIN DE BUCLE DE RECORRIDO DE EVENTOS-->
<div class="container">
	<div class="card-deck">
		<div class="card-columns row">
			<div class="card sombreado col" style="margin-bottom: 15px; margin-right:15px;">
			  <div class="card-body">
			  	<h5 class="card-title">Evento</h5>
			    <p class="card-text">Fecha: 28 de marzo de 2020 - 20:00h.<p>
			    <p class="card-text">El evento es en el aula 3.</p>
			    <div class="text-center pt-2">
			    	<a href="editEvento" class="btn btn-primary">Modificar evento</a>
			     </div>
			  </div>
			</div>
			<div class="card sombreado col" style="margin-bottom: 15px;">
			  <div class="card-body">
			  	<h5 class="card-title">Evento</h5>
			    <p class="card-text">Fecha: 28 de marzo de 2020 - 20:00h.<p>
			    <p class="card-text">El evento es en el aula 3.</p>
			    <div class="text-center pt-2">
			    	<a href="editEvento" class="btn btn-primary">Modificar evento</a>
			     </div>
			  </div>
			</div>
			<div class="card sombreado col" style="margin-bottom: 15px;">
			  <div class="card-body">
			  	<h5 class="card-title">Evento</h5>
			    <p class="card-text">Fecha: 28 de marzo de 2020 - 20:00h.<p>
			    <p class="card-text">El evento es en el aula 3.</p>
			    <div class="text-center pt-2">
			    	<a href="editEvento" class="btn btn-primary">Modificar evento</a>
			     </div>
			  </div>
			</div>
			<div class="card sombreado col" style="margin-bottom: 15px;">
			  <div class="card-body">
			  	<h5 class="card-title">Evento</h5>
			    <p class="card-text">Fecha: 28 de marzo de 2020 - 20:00h.<p>
			    <p class="card-text">El evento es en el aula 3.</p>
			    <div class="text-center pt-2">
			    	<a href="editEvento" class="btn btn-primary">Modificar evento</a>
			     </div>
			  </div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
