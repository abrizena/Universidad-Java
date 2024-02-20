
package beans;

import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */
public class HolaMundoAction {
    
    Logger log = LogManager.getLogger(HolaMundoAction.class);
    
    private String saludosAtr;
    
    //Metodo necesario en un archivo ACTION. Es el método que se va a ejecutar, y debemos retornar un String con el nombre de la cadena que indicará el JSP que se va a ejecutar
    private String execute(){
        log.info("Ejecutando metodo execute desde struts2");
        this.saludosAtr = "Saludos desde Struts2";
        return "exito"; //retorna la cadena exito a struts.xml
    } 

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
}
