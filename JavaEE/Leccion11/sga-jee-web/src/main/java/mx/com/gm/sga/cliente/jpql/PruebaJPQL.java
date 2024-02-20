package mx.com.gm.sga.cliente.jpql;

import java.util.*;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author antonio
 */
public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //1. Consulta de todos los objetos de tipo Persona
        log.debug("\n1. Consulta de todas las Personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //2. Consulta objeto de tipo Persona por Id
        log.debug("\n2. Consulta de la Persona con Id=2");
        jpql = "select p from Persona p where p.idPersona =2";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);

        //3. Consulta objeto de tipo Persona por nombre
        log.debug("\n3. Consulta de las Personas con nombre='karla'");
        jpql = "select p from Persona p where p.nombre ='karla'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //4. Consulta de datos individuales, se crea una tupla de tipo object  de 3 columnas
        log.debug("\n4. Consulta de datos individuales, se crea una tupla de tipo object  de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("nombre: "+nombre+", apellido: "+ apellido+", email: "+email);
        }

        //5. Obtiene el objeto de tipo Persona y su id, en un arreglo de tipo object deo object de 2 columnas
        log.debug("\n5. Consulta que obtiene el objeto de tipo Persona y su id, en un arreglo de tuplas, de tipo object, con un tipo Persona y su , de 2 columnas");
        jpql = "select p, p.idPersona as id from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.debug("Persona: " + persona+", id: "+ idPersona);
        }

        //6. Consulta de todas las personas, creando objetos Persona con únicamente idPersona
        log.debug("\n6. Consulta de todas las personas, creando objetos Persona con únicamente idPersona");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //7. Consulta que regresa el valor mínimo y máximo de IdPersona (scalar result) y cuantos hay, en una tupla de elementos
        log.debug("\n7. Consulta que regresa el valor mínimo y máximo de IdPersona (scalar result)");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            int idMin = (int) tupla[0];
            int idMax = (int) tupla[1];
            long count = (long) tupla[2];
            //log.debug("MinId: " + idMin+", MaxId: "+ idMax +", Count: "+count);
        }

        //8. Consulta que cuenta los nombres de las personas que son distintos
        log.debug("\n8. Consulta que cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        long contador = (long) em.createQuery(jpql).getSingleResult();
        //log.debug("Número de personas con nombre distinto: "+ contador);

        //9. Consulta que concatena y convierte a mayúsculas nombre y apellido
        log.debug("\n9. Consulta que concatena y convierte a mayúsculas nombre y apellido");
        jpql = "select CONCAT(p.nombre, ' ',p.apellido) as NombreCompleto from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombreCompleto : nombres) {
            //log.debug(nombreCompleto); 
        }

        //10. Consulta dinámica, que obtiene el objeto persona con id igual al parámetro proporcionado
        log.debug("\n10. Obtiene el objeto persona con id igual al parámetro proporcionado");
        int idPersona = 3;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.debug(persona);

        //11. Obtiene las personas que contengas 'a' en el nombre sin importar si es mayúscula o minúscula
        log.debug("\n11. Obtiene las personas que contenga 'a' en el nombre sin importar si es mayúscula o minúscula");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametroString = "%a%"; //expresión regular con caracter que utilizamos para el like
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametroString);
        personas = q.getResultList();
        //mostrarPersonas(personas);
        
        //12. Uso de between
        log.debug("\n12. Uso de between");
        jpql = "select p from Persona p where p.idPersona between 1 and 3";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13. Uso del ordenamiento
        log.debug("\n13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.idPersona > 1 order by p.nombre desc, p.apellido asc";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //14. Uso de subquery
        log.debug("\n14. Uso de subquery");
        //Alias diferente para la query principal (p) y la subquery (p1)
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)"; //Realmente devuelve solo un resultado (podiamos haber utilizado .getSingleResult());
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15. Uso de join con lazy loading (opción por default)
        log.debug("\n15. Uso de join con lazy loading");
        jpql = "select u from Usuario u join u.persona p"; //Carga retardada
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        //16. Uso de left join con eager loading 
        log.debug("\n16. Uso de left join con eager loading");
        jpql = "select u from Usuario u left join fetch u.persona p"; //Carga adelantada (al tener 'fetch')
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            log.debug(u);
        }
    }
}
