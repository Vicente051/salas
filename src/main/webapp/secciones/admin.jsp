<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="container col-sm sombreado">
	<H4>Opciones de administraci�n</H4>
	<div class="row">
		<div class="col-6">
			<form id="register-form" action="a�adirJefe" method="post" role="form">
				<div class="form-group">
					A�adir jefe de proyecto:
					<select name="jefeProyecto">
				 		<option>Manuel</option>
						 <option>Pedro</option>
						 <option>Chema</option>
						 <option>Ram�n</option>
			   		</select>
				</div>
				<div class="text-center pt-4">
	        		<button type="submit" class="btn btn-primary">A�adir jefe de proyecto</button>
	        	</div>
			</form>
		</div>
			
		<div class="col-6">	
			<div class="text-center pt-4">
				<a href="addAula" class="btn btn-primary">A�adir aula</a>
			</div>
			<div class="text-center pt-4">
				<a href="addEvento" class="btn btn-primary">A�adir evento</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
