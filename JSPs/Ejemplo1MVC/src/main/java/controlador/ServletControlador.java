
package controlador;

import jakarta.servlet.RequestDispatcher;
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
        
        //2. Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        //3. Agregamos una variable mensaje a algún alcance (en este caso utilizaremos alcance de request para el mensaje)
            //Agregamos una variable rectangulo con el JavaBean rec a algún alcance (en este caso utilizaremos alcance de sesión para el ejemplo)
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4. Redireccionamos a la vista seleccionada para mostrar la salida
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request,response);
        
        
        
        
    }
}
