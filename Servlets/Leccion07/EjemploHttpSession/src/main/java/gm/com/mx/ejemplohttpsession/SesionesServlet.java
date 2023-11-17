
package gm.com.mx.ejemplohttpsession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author antonio
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedir el atributo contador visitas a la sesion
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");
        if (contadorVisitas == null){
            contadorVisitas=1;
            titulo="Bienvenido por primera vez";
            
        } else {
            contadorVisitas++;
            titulo="Bienvenido nuevamente";
        }
        //agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br/>");
        out.print("Nº accesos al recurso: "+ contadorVisitas);
        out.print("<br/>");
        out.print("ID de la sesion: " + sesion.getId()); //Retorna el identificador único de la sesion
        out.close();
    }
}
