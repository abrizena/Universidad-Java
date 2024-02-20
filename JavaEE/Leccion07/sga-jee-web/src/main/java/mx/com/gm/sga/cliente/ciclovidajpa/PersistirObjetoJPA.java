
package mx.com.gm.sga.cliente.ciclovidajpa;

import org.apache.logging.log4j.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author antonio
 */

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", "pluna@mail.com", "13135566");
        
        //Paso 2. Inicia transacción
        tx.begin();
        
        //Paso 3. Ejecuta SQL
        em.persist(persona1);
        log.debug("Objeto persistido aun sin commit (por tanto sin idPersona): "+ persona1);
        
        //Paso 4. commit/rollback
        tx.commit();
        //Objeto en estado detached
        log.debug("Objeto persistido en estado detached: "+ persona1);
        
        //Cerramos EntityManager
        em.close();
        
    }
}
