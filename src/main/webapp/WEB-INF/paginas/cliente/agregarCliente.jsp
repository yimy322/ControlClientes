  <div class="modal fade" id="agregarClienteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h1 class="modal-title fs-5 text-light" id="staticBackdropLabel"><i class="fa-solid fa-user-plus"></i> Agregar Cliente</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post" class="was-validated">
            <div class="modal-body">
                Nombre: <input type="text" name="nombre" id="" class="form-control" required>
                Apellido: <input type="text" name="apellido" id="" class="form-control" required>
                Email: <input type="text" name="email" id="" class="form-control" required>
                Telefono: <input type="number" name="telefono" id="" class="form-control" required>
                Saldo: <input type="number" name="saldo" id="" class="form-control" required>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
      </div>
    </div>
  </div>