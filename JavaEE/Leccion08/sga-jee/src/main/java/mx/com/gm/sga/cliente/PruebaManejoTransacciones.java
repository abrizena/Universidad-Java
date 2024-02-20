package mx.com.gm.sga.cliente;

import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */

public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            //Recuperamos instancia de EJB PersonaDb
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            log.debug("Iniciando prueba Manejo transaccional PersonaService");
            
            //MANEJO TRANSACCIONAL
            //Buscar un objeto persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));
            
            log.debug("Persona recuperada:" + persona1);
            
            //Cambiar el apellido persona
            //persona1.setApellido("cambio con error...................................................................................."); //Error se muestra en salida Glashfish por tener más de 45 caracteres
            //persona1.setApellido("Juarez");
            persona1.setApellido("Perez");
            persona1.setEmail("jperez@mail.com");
            
            personaService.modificarPersona(persona1);
            log.debug("Objeto modificado:" + persona1);
            log.debug("Fin prueba EJB transaccional");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
}
