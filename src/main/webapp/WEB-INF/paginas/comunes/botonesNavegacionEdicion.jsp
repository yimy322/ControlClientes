<div class="container">
    <h3>Editar cliente</h3>
    <hr class="border border-secondary border-2 opacity-50">
    <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" method="POST" class="was-validated">
        <div class="form-control bg-secondary text-light">
            <div class="row">
                <div class="col-md-6">
                    Nombre: <input type="text" name="nombre" id="" class="form-control" required value="${cliente.nombre}">
                </div>
                <div class="col-md-6">
                    Apellido: <input type="text" name="apellido" id="" class="form-control" required value="${cliente.apellido}">
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    Email: <input type="text" name="" id="email" class="form-control" required value="${cliente.email}">
                </div>
                <div class="col-md-4">
                    Telefono: <input type="number" name="telefono" id="" class="form-control" required value="${cliente.telefono}">
                </div>
                <div class="col-md-4">
                    Saldo: <input type="number" name="saldo" id="" class="form-control" required value="${cliente.saldo}" step="any">
                </div>
            </div>
            <hr class="border border-ligth border-2 opacity-50">
            <div class="row">
                <div class="col-md-4">
                    <a href="index.jsp" class="btn btn-light form-control" type="submit">
                        <i class="fa-solid fa-arrow-left"></i> Regresar al inicio
                    </a>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-success form-control" type="submit">
                        <i class="fa-sharp fa-solid fa-cloud-arrow-up"></i> Guardar cliente
                    </button>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" class="btn btn-danger form-control" type="submit">
                        <i class="fa-solid fa-trash"></i> Eliminar cliente
                    </a>
                </div>
            </div>
        </div>  
    </form>
</div>