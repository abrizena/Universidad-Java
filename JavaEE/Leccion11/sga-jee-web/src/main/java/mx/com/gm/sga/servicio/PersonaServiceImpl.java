package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.PersonaDao;
import mx.com.gm.sga.domain.Persona;


/**
 *
 * @author antonio
 * 
 * SERVICIO WEB SOAP: PERSONAS (AXWS-RI/2.3.0 JAXWS-API/2.3.0 JAXB-RI/2.3.0 JAXB-API/2.3.0)
 * Para ver el WSDL: http://localhost:8080/PersonaServiceImplService/PersonaServiceImpl?WSDL
 * Para ver el http://localhost:8080/PersonaServiceImplService/PersonaServiceImpl?xsd=1
 * Para obtener un listado de todas las personas: http://localhost:8080/sga-jee-web/webservice/personas/
 * Para obtener persona con id=1:   http://localhost:8080/sga-jee-web/webservice/personas/1
 */

@Stateless
@WebService(endpointInterface="mx.com.gm.sga.servicio.PersonaServiceWs")
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWs {

    //No va a acceder directamente a la implementación, sino que va a utilizar la capa de datos PersonaDao, por lo que debemos utilizar inyección de dependencias (con CDI al estar en entorno empresarial)
    @Inject
    private PersonaDao personaDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
//        personas.add(new Persona(1,"Juan","Perez","jperez@mail.com","55139900"));
//        personas.add(new Persona(2,"Martha","Suarez","msuarez@mail.com","55899910"));
//        return personas

        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try {
            personaDao.updatePersona(persona);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }

    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }

}
