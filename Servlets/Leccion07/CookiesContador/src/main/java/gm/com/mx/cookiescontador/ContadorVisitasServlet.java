
package gm.com.mx.cookiescontador;

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
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Declaramos una variable contador
        int contador = 0;
        
        //Revisamos si ya existe la cookie contadorVisitas
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies){
                if (c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        //Incrementar el contador en uno
        contador++;
        
        //Agregar la cookie al navegador
        Cookie c= new Cookie("contadorVisitas",Integer.toString(contador));
        c.setMaxAge(3600); //la cookie se almacenará en el cliente por 1 hora = 3600seg
        response.addCookie(c);
        
        //Mandamos el mensaje al navegador
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("Contador de visitas de clientes: "+contador);
    }
    
}
