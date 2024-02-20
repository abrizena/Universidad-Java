
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author antonio
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao{
    @PersistenceContext(unitName="SgaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
       return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createNamedQuery("from Persona p where p.email =: email"); //No es SQL sino JPQL, recupera objetos completos y no columnas de la tabla Persona
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult(); //el campo email debe marcarse como UQ (unico) en la tabla de la base de datos, osea que no puede haber email duplicados
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
       em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        em.remove(em.merge(persona)); //Antes de removerlo, debemos sincronizar el estado con un merge
    }
    
}
