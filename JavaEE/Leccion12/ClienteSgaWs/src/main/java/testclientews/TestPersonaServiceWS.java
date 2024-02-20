
package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author antonio
 */

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        //Para autentificacion, proporcionamos usuario y password
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        //Fin configuración autentificacion
        
        
        System.out.println("Ejecutando servicio listar personas ws");
        List<Persona> personas = personaService.listarPersonas();
        
        for(Persona persona:personas){
            System.out.println("Persona: "+ persona.getIdPersona() 
                    +", nombre: "+persona.getNombre()
                    +", apellido: "+ persona.getApellido()
                    +", email: "+persona.getEmail()
                    +", telefono: "+persona.getTelefono());
        }
        System.out.println("Fin servicio listar personas ws");
    }
    
}
