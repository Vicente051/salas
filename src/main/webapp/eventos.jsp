<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="container">
	<div class="text-center pt-4">
		<a href="addEvento" class="btn btn-primary">Añadir evento</a>
		<form id="register-form" action="añadirJefe" method="post" role="form">
			Añadir jefe de proyecto:
			<select name="jefeProyecto">
		 		<option>Manuel</option>
				 <option>Pedro</option>
				 <option>Chema</option>
				 <option>Ramón</option>
	   		</select>
       		<button type="submit" class="btn btn-primary">Añadir jefe de proyecto</button>
		</form>
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
		<div class="row">
		
			<div class="card mb-4 mr-4 sombreado" style="width: 340px;">
				<div class="card-body">
				  	<h5 class="card-title">Evento</h5>
				    <p class="card-text">Fecha: 28 de marzo de 2020 - 20:00h.<p>
				    <p class="card-text">El evento es en el aula 3.</p>
				    <div class="text-center pt-4">
				    	<a class="btn btn-primary" href="editEvento">Editar evento</a>
				    	<a href="doodle" class="btn btn-primary">Preferencias</a>
				    </div>
				</div>
			</div>
			
		</div>
	</div>
</div>
<%@ include file="/../encabezados/pie.jsp" %>
