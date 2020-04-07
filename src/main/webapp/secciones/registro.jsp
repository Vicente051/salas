<%@ include file="/../encabezados/cabecera.jsp" %>
<%@ include file="/../encabezados/menu.jsp" %>

<div class="container sombreado">
  <div class="card mx-auto border-0 bg-transparent">
    <div class="card-header border-bottom-0 bg-transparent">
      <ul class="nav nav-tabs justify-content-center pt-4" id="pills-tab" role="tablist">
        <li class="nav-item">
          <a class="nav-link active text-primary" id="pills-login-tab" data-toggle="pill" href="#pills-login" role="tab" aria-controls="pills-login"
             aria-selected="true">Entrar</a>
        </li>

        <li class="nav-item">
          <a class="nav-link text-primary" id="pills-register-tab" data-toggle="pill" href="#pills-register" role="tab" aria-controls="pills-register"
             aria-selected="false">Registro</a>
        </li>
      </ul>
    </div>

    <div class="card-body pb-4">
      <div class="tab-content" id="pills-tabContent">
        <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="pills-login-tab">
          <form>
            <div class="form-group">
              <input type="email" name="email" class="form-control" id="email" placeholder="Email" required autofocus>
            </div>

            <div class="form-group">
              <input type="password" name="password" class="form-control" id="password" id="password" placeholder="Password" required>
            </div>

            

            <div class="text-center pt-4">
              <button type="submit" class="btn btn-primary">Entrar</button>
            </div>

            <div class="text-center pt-2">
              <a class="btn btn-link text-primary" href="#">Contraseņa perdida</a>
            </div>
          </form>
        </div>

        <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="pills-register-tab">
          <form>
            <div class="form-group">
              <input type="text" name="username" id="name" class="form-control" placeholder="Username" required autofocus>
            </div>

            <div class="form-group">
              <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
            </div>

            <div class="form-group">
              <input type="password" name="password" id="password" class="form-control" placeholder="Set a password" required>
            </div>

            <div class="form-group">
              <input type="password" name="password_confirmation" id="password-confirm" class="form-control" placeholder="Confirm password" required>
            </div>

            <div class="text-center pt-2 pb-1">
              <button type="submit" class="btn btn-primary">Registrar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="/../encabezados/pie.jsp" %>
