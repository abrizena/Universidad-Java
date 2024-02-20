/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class EliminarObjetoJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Inicia transacción 1
        tx.begin();
        
        //Paso 2. Ejecutcutar SQL de tipo select
        //El Id debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 6);
        
        //Paso 3. Termina transacción 1
        tx.commit();
                
        //Objeto en estado detached
        log.debug("Objeto encontrado: "+ persona1);
        
        //Paso 4. Inicia transacción 2
        EntityTransaction tx2 = em.getTransaction();
        tx.begin();
        
        // Paso 5. Ejecutcutar SQL de tipo delete
        em.remove(em.merge(persona1)); // Al no ser la misma transacción, antes de hacer remove hay que sincronizar el objeto con la base de datos con merge.Si hacemos todo en 1 sola trasacción no sería necesario el merge, pero esto no será lo habitual
        
        //Paso 6. Termina transacción 2
        tx2.commit();
        //Objeto en estado detached ya eliminado en BD. El objeto sólo está en memoria
        log.debug("Objeto eliminado: "+ persona1);
        
        //Cerramos EntityManager
        em.close();
    }
}
