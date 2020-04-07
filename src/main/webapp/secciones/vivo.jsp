<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<noscript>
   <h2>Sorry! Your browser doesn't support Javascript</h2>
</noscript>
    
<div class="container mt-10">
	<div class="row">
		<div class="col bg-warning" style="border-radius: 15px; margin-left:15px; text-align: center;">
			<H1>PANTALLA</H1>
		</div>
		<div class="col-3 sombreado">
		
		<noscript>
      <h2>Sorry! Your browser doesn't support Javascript</h2>
    </noscript>

    <div id="username-page">
        <div class="username-page-container">
            <h1 class="title">Nombre de usuario</h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Escribe nombre usuario..." autocomplete="off" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="accent username-submit">Empezar a chatear</button>
                </div>
            </form>
        </div>
    </div>

    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Chat de Evento Tal...</h2>
            </div>
            <div class="connecting">
                Conectando...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Escribe un mensaje..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Enviar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="/js/main.js"></script>
    
    
		</div>
		
	</div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
