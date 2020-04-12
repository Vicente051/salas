<%@ include file="/encabezados/header.jsp"%>



<!DOCTYPE html>
<html>
  <head>
      <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
      <title>Spring Boot Chat Application</title>
      <link rel="stylesheet" href="/css/chat.css" />
  </head>
  <body>
    <noscript>
      <h2>Sorry! Your browser doesn't support Javascript</h2>
    </noscript>
    
     <div id="evento-id">
                    <input type="text" id="eventoid" placeholder="Escribe nombre usuario..." autocomplete="off" class="form-control" />
                                        
                </div>

    <div id="username-page">
        <div class="username-page-container">
            <h1 class="title">Nombre de usuario</h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Escribe nombre usuario..." autocomplete="off" class="form-control" />
                                        
                </div>
                <div id="evento-id">
                    <input type="number" id="eventoid" placeholder="Escribe nombre usuario..." autocomplete="off" class="form-control" />
                                        
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
    <script src="/js/chat.js"></script>
  </body>
</html>

<%@ include file="/encabezados/footer.jsp"%>