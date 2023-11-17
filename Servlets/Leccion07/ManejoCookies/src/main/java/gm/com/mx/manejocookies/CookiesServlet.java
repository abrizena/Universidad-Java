
package gm.com.mx.manejocookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author antonio
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario=true;
        
        //Obtenemos el arreglo de todas las cookies
        Cookie[] cookies = request.getCookies();
        
        //Buscamos si ya hay una cookie creada con anterioridad
        if (cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    nuevoUsuario=false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if (nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente","si");
            response.addCookie(visitanteCookie); //Añadimos cookie al navegador
            mensaje="Gracias por visitar nuestro sitio por primera vez";
            
        } else {
            mensaje="Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: "+mensaje);
        out.close();
    }
}
