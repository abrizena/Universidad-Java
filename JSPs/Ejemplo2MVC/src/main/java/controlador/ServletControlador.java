
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import modelo.Rectangulo;

/**
 *
 * @author antonio
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos los parámetros (en este caso no comprobamos que no existan y no sean vacios
        String accion = request.getParameter("accion");
        
        //2. Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSesion = new Rectangulo(3,4);
        Rectangulo recAplicacion = new Rectangulo(5,6);
        
        //3. Agregamos como atributos un JavaBean (variable de la clase Rectangulo) con nombre  rec* (* según alcance)
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        //revisamos la acción proporcionada con condicional
        if ("agregaVariables".equals(accion)){
            //Alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSesion);
            
            //Alcance aplication
            ServletContext aplicacion = this.getServletContext();
            aplicacion.setAttribute("rectanguloAplicacion", recAplicacion);
            
            //Agregamos un mensaje indicando si las variables fueron agregadas
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //Redireccionamos al JSP  vista/desplegarVariables.jsp las variables 
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if ("listarVariables".equals(accion)){
            //4. Redireccionamos al JSP privado WEB-INF/alcanceVariables.jsp que muestra el alcance de las variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
            
        } else {
            //4. Redireccionamos a la página de inicio
            request.setAttribute("mensaje", "Acción no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Si redireccionamos con sendRedirect no podemos pasar atributos como mensajes (no propaga request y response), por lo que no lo utilizamos en este caso, para poder mostrar el mensaje
            //request.sendRedirect("index.jsp");
        }
        
        
        //4. Redireccionamos a la vista seleccionada para mostrar la salida de una variable rec
//        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
//        rd.forward(request,response);
        
        
        
        
    }
}
