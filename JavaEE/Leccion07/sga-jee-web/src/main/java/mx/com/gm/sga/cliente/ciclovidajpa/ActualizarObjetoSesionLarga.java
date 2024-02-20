
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
public class ActualizarObjetoSesionLarga {
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
                
        //Objeto en estado detached
        log.debug("Objeto encontrado: "+ persona1);
        
        //Paso 3. setValue (nuevoValor)
        persona1.setEmail("jjuarez@mail.com");
        persona1.setEmail("j.juarez@mail.com"); //Podemos hacer varias modificaciones al objeto detached
        
        //No es necesario hacer merge, por estar en la misma transacción
        
        //Paso 4. Termina transacción 2
        tx.commit();
        //Objeto en estado detached ya modificado
        log.debug("Objeto modificado: "+ persona1);
        
        //Cerramos EntityManager
        em.close();
    }
}
