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
public class EncontrarObjetoJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Inicia transacción
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 2);
                
        //Paso 3. termina la transacción commit/rollback
        tx.commit();
        //Objeto en estado detached
        log.debug("Objeto recuperado: "+ persona1);
        
        //Cerramos EntityManager
        em.close();
    }
    
}
