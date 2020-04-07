<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="row">
	<div class="container col-5 sombreado">
		<p>El actual nombre de usuario es: Chema</p>
		<p>La contraseña de usuario es: xxxxx ${usuario.password}</p>
		<c:if test = "${!usuario.admin}">El usuario es administrador.</c:if>
	</div>
	<div class="container col-5 sombreado">
	  			<H3>Modificar datos de usuario:</H3>
		<form>
			<div class="form-group">
		    	<input type="email" name="email" class="form-control" id="email" placeholder="Nuevo nombre" required autofocus>
		    </div>
		
		    <div class="form-group">
		    	<input type="password" name="password" class="form-control" id="password" id="password" placeholder="Nueva contraseña" required>
		    </div>
		    <div class="text-center pt-4">
		    	<button type="submit" class="btn btn-primary">Modificar perfil</button>
		    </div>
		</form>
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
