package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.PersonaDao;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

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
