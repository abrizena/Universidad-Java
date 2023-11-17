
package gm.com.mx.ManejoCabeceros;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 *
 * @author antonio
 */
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {

       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String metodoHttp = request.getMethod();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Headers HTTP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Headers HTTP</h1>");
            out.println("Metodo Http: " + metodoHttp);
            
            String uri = request.getRequestURI();
            out.println("<br>");
            out.println("Uri solicitada:" + uri);
            out.println("<br/>");
            out.println("<br/>");
            //Imprimimos todos los cabeceros disponibles
            Enumeration cabeceros = request.getHeaderNames();
            while(cabeceros.hasMoreElements()){
                String nombreCabecero = (String)cabeceros.nextElement();
                out.println("<b>" + nombreCabecero +"</b>:");
                out.println(request.getHeader(nombreCabecero));
                out.println("<br/>");
            }
//            out.println("<h1>Servlet " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
       
    }

    

}
