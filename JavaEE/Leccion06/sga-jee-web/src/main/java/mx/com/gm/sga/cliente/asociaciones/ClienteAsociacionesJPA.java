
package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */
public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        //cerramos la conexión
        em.close();
        
        //Imprimir los objetos de tipo persona
        for(Persona persona : personas){
            log.debug("Persona: "+ persona);
            //recuperamos los usuarios relacionados de cada persona (pues estamos en carga retardada (LAZY es por defecto), y por defecto no se carga la lista de usuarios relacionada con cada persona)
            for(Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario: "+ usuario);
            }
        }
    }
    
}
