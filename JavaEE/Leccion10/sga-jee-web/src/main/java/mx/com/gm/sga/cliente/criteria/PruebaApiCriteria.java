package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */
public class PruebaApiCriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //1-a. Query utilizando el API de Criteria
        //1. Consulta de todas las personas
        //Paso 1. El objeto EntityManager crea instancia CriteriaBuilder
        log.debug("\n1-a Consulta de de todas las personas");
        cb = em.getCriteriaBuilder();

        //Paso 2. Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);

        //Paso 3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);

        //Paso 4. seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);

        //Paso 5. Creamos el query typeSafe
        query = em.createQuery(criteriaQuery);

        //Paso 6. Ejecutamos la consulta
        personas = query.getResultList();

        mostrarPersonas(personas);

        //2-a. Query utilizando el API de Criteria
        //1. Consulta de la persona con id=1
        //jpql = "select p from Persona p where p.idPersona=1"
        //La ventaja de Criteria es que podemos agregar dinámicamente más filtros
        log.debug("\n2-a Consulta de la Persona con id=1");
        cb = em.getCriteriaBuilder(); //Es necesario reinicializarlo para que no haya problemas con consultas anteriores
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        //2-b. Consulta de la persona con id=1 de otra forma
        log.debug("\n2-b Consulta de la Persona con id=1 de otra forma");
        cb = em.getCriteriaBuilder(); //Es necesario reinicializarlo para que no haya problemas con consultas anteriores
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //La clave Predicate permite agregar varios criterios dinámicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        //Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter)); //Agregamos criterio......se supone que dinámicamente se agregarian más criterios así
        
        //Agregamos los criterios
        if (criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size()==1){
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //Se ejecuta el query
        persona = query.getSingleResult();
        log.debug(persona);
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
