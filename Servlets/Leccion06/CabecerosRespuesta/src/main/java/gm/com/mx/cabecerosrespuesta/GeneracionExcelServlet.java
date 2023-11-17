
package gm.com.mx.cabecerosrespuesta;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author antonio
 */
@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        
        //Indicar al navegador que no guarde cache
        response.setHeader("Content-Disposition","attachment;filename=excelEjemplo.xls"); //Para uso más profesional de Excel utilizar librería poi.apache.org
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires",-1);
        
        //Desplegamos la información al cliente
        PrintWriter out= response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(B2:B3)");
        
    }
}
