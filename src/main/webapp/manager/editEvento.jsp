<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="row">
	<div class="container col-5 sombreado">
		<H4>Opciones de evento</H4>
		<form id="register-form" action="añ" method="post" role="form">
			<div class="row">
				<div class="col-4">
					 <div class="form-check">
	            		<H5>Horarios:</H5>
						 <p><input class="form-check-input" type="checkbox" name="hora1" value="1" style="width: 15px; height:15px;">
						 10:00-11:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora2" value="2" style="width: 15px; height:15px;">
						 11:00-12:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora3" value="3" style="width: 15px; height:15px;">
						 12:00-13:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora4" value="4" style="width: 15px; height:15px;">
						 13:00-14:00</p>
						 
					</div>
				</div>
				<div class="col-4">
					 
					 <div class="form-check"><br/>
						 <p><input class="form-check-input" type="checkbox" name="hora5" value="5" style="width: 15px; height:15px;">
						 17:00-18:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora6" value="6" style="width: 15px; height:15px;">
						 18:00-19:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora7" value="7" style="width: 15px; height:15px;">
						 20:00-21:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora8" value="8" style="width: 15px; height:15px;">
						 21:00-22:00</p>
					</div>
				</div>
			
		    <div class="text-center pt-4 col-4">
		       	<button type="submit" class="btn btn-primary">Enviar preferencias</button>
		    </div>
		    </div>
		</form>
		<div class="row" style="margin-bottom:15px;">		
			<div class="text-center pt-4 col-4">
			   	<button class="btn btn-primary">Asistir a evento</button>
			</div>
			<div class="text-center pt-4 col-4">
			   	<button class="btn btn-primary">No asistir a evento</button>
			</div>
		</div>
	</div>
	<div class="container col-5 sombreado">
	
		<H4>Modificar evento</H4>
	   <form id="register-form" action="añadirAula" method="post" role="form">
	   	<div class="row">
	    	<div class="form-group col-8">
	    		Nombre del evento:
	        	<input type="text" name="username" id="name" class="form-control" placeholder="Nombre del evento" required autofocus>
	        </div>
	        <div class="form-group col-4">
				Sala:
		        <select id="inputState" class="form-control">
		        	<option>1</option>
		        	<option>2</option>
		        	<option>3</option>
		        	<option>4</option>
		        	<option>5</option>
		        	<option>6</option>
		        	<option>7</option>
		        	<option>8</option>
		        	<option>9</option>
		        	<option>10</option>
		      	</select>
	      	</div>
	    </div>
	       <div class="form-group">
	       	<textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Descripción del evento" rows="3"></textarea>
	       </div>
	       <div class="row">
	  		<div class="form-group col-8">
	  			Fecha
	        	<input type="text" name="fecha" id="name" class="form-control" placeholder="ejem. 12/02/2020" required autofocus>
	        </div>
	        <div class="col">
	            	<div class="form-check">
	            		<H5>Horarios:</H5>
						 <p><input class="form-check-input" type="checkbox" name="hora1" value="1" style="width: 15px; height:15px;">
						 10:00-11:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora2" value="2" style="width: 15px; height:15px;">
						 11:00-12:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora3" value="3" style="width: 15px; height:15px;">
						 12:00-13:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora4" value="4" style="width: 15px; height:15px;">
						 13:00-14:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora5" value="5" style="width: 15px; height:15px;">
						 17:00-18:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora6" value="6" style="width: 15px; height:15px;">
						 18:00-19:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora7" value="7" style="width: 15px; height:15px;">
						 20:00-21:00</p>
						 <p><input class="form-check-input" type="checkbox" name="hora8" value="8" style="width: 15px; height:15px;">
						 21:00-22:00</p>
					</div>
			</div>
		</div>
	    <div class="text-center pt-4">
	    	<button type="submit" class="btn btn-primary">Añadir evento</button>
	    </div>
		</form>
	
		<div class="text-center pt-4">
		   	<button class="btn btn-primary">Eliminar evento</button>
		</div>
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
