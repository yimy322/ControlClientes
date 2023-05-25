<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_PE"/>
        <div class="container">
            <button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#agregarClienteModal"><i class="fa-solid fa-user-plus"></i> Agregar cliente</button>
            <div class="row">
                <div class="col-md-9">
                    <hr class="border border-secondary border-2 opacity-50">
                    <center><h1 class="display-6 fw-bold text-body-emphasis">Listado de clientes</h1></center>
                    <hr class="border border-secondary border-2 opacity-50">
                    <table class="table table-bordered border-secondary">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Saldo</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <tr>
                                    <th scope="row">${status.count}</th>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency" /></td>
                                    <td><a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}" class="btn btn-secondary form-control"><i class="fa-solid fa-pen-to-square"></i> 
                                       Editar</a>
                                    </td>
                                </tr>  
                            </c:forEach>           
                        </tbody>
                    </table>
                </div>
                <div class="col-md-3">
                    <div class="card text-center bg-danger text-light mb-3" style="width: 18rem;">
                        <div class="card-body">
                                <h5 class="card-title">Saldo total</h5>
                                <h4 class="display-6"><fmt:formatNumber value="${saldoTotal}" type="currency" /></h4>
                          </div>                    
                    </div>
                    <br>
                    <div class="card text-center  bg-success text-light mb-3" style="width: 18rem;">
                        <div class="card-body">
                                <h5 class="card-title">Total de clientes</h5>
                                <h4 class="display-6">
                                    <i class="fa-solid fa-users"></i>${totalClientes}
                                </h4>
                          </div>                    
                    </div>
                </div>
            </div>

        </div>   
<!-- Pie de pagina -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>