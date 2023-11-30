
package web;

import datos.*;
import dominio.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author antonio
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion!=null){
            switch(accion){
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);     
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar(); //recupera información (listado clientes)
        System.out.println("clientes = " + clientes); //imprime listado clientes
        
//        request.setAttribute("clientes", clientes); //crea atributo clientes con el listado, en el ambito request
//        request.setAttribute("totalClientes", clientes.size()); //crea atributo totalClientes, en el ambito request
//        request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes)); //crea atributo saldoTotal, en el ambito request
//        request.getRequestDispatcher("clientes.jsp").forward(request, response); //envía el request a clientes.jsp para la salida, aunque hace que no cambie el url por lo que lo cargaría con la acción 
        
        HttpSession sesion=request.getSession();
        sesion.setAttribute("clientes", clientes); //crea atributo clientes con el listado, en el ambito request
        sesion.setAttribute("totalClientes", clientes.size()); //crea atributo totalClientes, en el ambito request
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes)); //crea atributo saldoTotal, en el ambito request
        response.sendRedirect("clientes.jsp"); //redirecciona a clientes.jsp para la salida, mediante RESPONSE, aunque con el url sin acción, pues es lo que queremos
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el idCliente (faltaría calidación idCliente)
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente= new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar="/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion!=null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    
            }
        } else {
            this.accionDefault(request, response);
        }
        
    }

    protected void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos información del formulario agregarCliente
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String email= request.getParameter("email");
        String telefono= request.getParameter("telefono");
        double saldo= 0.0;
        String saldoString=request.getParameter("saldo");
        if (saldoString!=null && !"".equals(saldoString)){
            saldo=Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        
        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
//        System.out.println("registrosModificados = " + registrosModificados);
        
        //Redirigimos hacia la acción por default
        this.accionDefault(request, response);
        
        
   
    }
    
    protected void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos información del formulario editarCliente
        int idCliente= Integer.parseInt(request.getParameter("idCliente"));
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String email= request.getParameter("email");
        String telefono= request.getParameter("telefono");
        double saldo= 0.0;
        String saldoString=request.getParameter("saldo");
        if (saldoString!=null && !"".equals(saldoString)){
            saldo=Double.parseDouble(saldoString);
        }
        
        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        
        //Modificamos el objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //Redirigimos hacia la acción por default
        this.accionDefault(request, response);
   
    }
    
    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos idCliente del formulario editarCliente
        int idCliente= Integer.parseInt(request.getParameter("idCliente"));
        
        if (idCliente!=0){
             //Creamos el objeto de cliente (modelo)
            Cliente cliente = new Cliente(idCliente);
        
            //Eliminamos el objeto en la base de datos
            int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
            System.out.println("registrosModificados = " + registrosModificados);
        }
        
       
        
        //Redirigimos hacia la acción por default
        this.accionDefault(request, response);
        
        
   
    }
   
}
