
package mx.com.gm.sga.servicio;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author antonio
 */

//Misma interface que la del lado del servidor, la podemos copiar excepto la anotación @Remote, que sólo se indica en el servidor
public interface PersonaServiceRemote {
    
    public List<Persona> listarPersonas();

    public Persona encontrarPersonaPorId(Persona persona);

    public Persona encontrarPersonaPorEmail(Persona persona);

    public void registrarPersona(Persona persona);

    public void modificarPersona(Persona persona);

    public void eliminarPersona(Persona persona);
}

