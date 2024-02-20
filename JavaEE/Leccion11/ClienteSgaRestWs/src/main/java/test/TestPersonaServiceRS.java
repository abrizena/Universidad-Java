/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 *
 * @author antonio
 */
public class TestPersonaServiceRS {
    //Variables que vamos a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        //Leer una persona (metodo GET)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: "+ persona);
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas");
        imprimirPersonas(personas);
        
        //Agregar una Persona (método POST)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmiranda3@mail.com"); //El email debe ser único, pues en la base de datos tiene la propiedad UNIQUE
        nuevaPersona.setTelefono("99887700");
        
            //Hacemos petición o REQUEST
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        
            //Recuperamos la persona recién agregada para después modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: "+ personaRecuperada);
        
        //Modificar la persona (PUT) recién agregada
        Persona personaModificar = personaRecuperada;
        personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/"+personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println("response: " + response.getStatus());
        System.out.println("Persona modificada: "+response.readEntity(Persona.class));
        
        //Eliminar una Persona
        // en este caso la recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathIdEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathIdEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response"+response.getStatus());
        System.out.println("Persona Eliminada" + personaEliminar);
        
    }
    
    

    private static void imprimirPersonas(List<Persona> personas) {
        for(Persona p:personas){
            System.out.println("Persona: " + p);
    }
    }
    
    
    
}
