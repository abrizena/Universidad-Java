
package mx.com.gm.sga.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author antonio
 */

@Named("personaBean")
@RequestScoped
public class PersonaBean {
    
    Logger log = LogManager.getRootLogger();
    
    //Inyectamos el servicio de persona de nuestro EJB
    @Inject
    private PersonaService personaService;
    
    private Persona personaSeleccionada;
    
    private List<Persona> personas;
    
    public PersonaBean(){
        log.debug("Iniciando el objeto PersonaBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Iniciamos las variables
        this.personas = personaService.listarPersonas();
        log.debug("personas recuperadas en ManagedBean: "+ this.personas);
        this.personaSeleccionada = new Persona();
        
    }
    
    public void editListener(RowEditEvent event){
        Persona persona = (Persona)event.getObject();
        personaService.modificarPersona(persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void agregarPersona(){
        this.personaService.registrarPersona(personaSeleccionada);//Modifica base de datos
        this.personas.add(personaSeleccionada);//Modifica lista de personas de la vista
        this.personaSeleccionada=null;
    }
    
    public void eliminarPersona(){
        this.personaService.eliminarPersona(personaSeleccionada);//Modifica base de datos
        this.personas.remove(this.personaSeleccionada);//Modifica lista de personas de la vista
        this.personaSeleccionada=null;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada= new Persona();
    }
}
