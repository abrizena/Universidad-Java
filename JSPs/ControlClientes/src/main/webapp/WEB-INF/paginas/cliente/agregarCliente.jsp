<%-- 
    Document   : agregarCliente
    Created on : 24 nov 2023, 2:17:07
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarClienteModal" tabindex="-1" aria-labelledby="..." aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h4 class="modal-title"><strong>Agregar Cliente</strong></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                    <!--<span>&times;</span> -->
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required step="any">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
                
            </form>
        </div>
    </div>
</div>

