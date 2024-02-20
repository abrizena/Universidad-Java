
package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */
public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso 1. Crea nuevo objeto Persona
        //objeto en estado transitivo
        Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "55778822");
        
        //Paso 2. Crea nuevo objeto Usuario, relacionado con persona1
        //Crear objeto usuario (tiene dependencia con objeto persona)
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);
        
        //Paso 3. Persistimos el objeto usuario únicamente (pues en automático o en cascada también se va a persistir el objeto persona1 relacionado, por la configuración de persistencia en cascada en la clase Usuario)
        em.persist(usuario1);
        
        //Paso 4. commit transacción
        tx.commit();
        
        //Objetos en estado detached (tienen representación en la base de datos)
        log.debug("objeto persistido persona: "+persona1);
        log.debug("objeto persistido usuario: "+usuario1);
        
        em.close();
    }
}
