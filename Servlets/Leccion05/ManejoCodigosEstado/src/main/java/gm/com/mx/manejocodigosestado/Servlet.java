
package gm.com.mx.manejocodigosestado;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author antonio
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Simulando los valores correctos
        String usuarioOk="Juan";
        String passwordOk="123";
        
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        
        PrintWriter out= response.getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)){
            out.println("<h1>");
            out.println("Datos correctos");
            out.println("<br>Usuario:"+usuario);
            out.println("<br>Password:"+password);
            out.println("</h1>");
        } else {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
        out.close();
    }
}
