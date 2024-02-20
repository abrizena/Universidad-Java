
package mx.com.gm.sga.cliente.ciclovidajpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static mx.com.gm.sga.cliente.ciclovidajpa.PersistirObjetoJPA.log;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author antonio
 */
public class ActualizarObjetoJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Inicia transacción 1
        tx.begin();
        
        //Paso 2. Ejecutcutar SQL de tipo select
        //El Id debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 1);
                
        //Paso 3. termina la transacción commit/rollback
        tx.commit();
        //Objeto en estado detached
        log.debug("Objeto recuperado: "+ persona1);
        
        //Paso 4. setValue (nuevoValor)
        persona1.setApellido("Juarez");
        
        //Paso 5. Inicia transacción 2
        EntityTransaction tx2 = em.getTransaction();
        tx.begin();
        
        //Paso 6. Modificamos el objeto
        em.merge(persona1);
        
        //Paso 7. Termina transacción 2
        tx2.commit();
        //Objeto en estado detached ya modificado
        log.debug("Objeto recuperado: "+ persona1);
        
        //Cerramos EntityManager
        em.close();
    }
    
}
