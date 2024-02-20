package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author antonio
 * RESTFULL WEB SERVICE CON JAXRS
 * SERVICIO WEB REST: PERSONAS
 * Para ver el WADL: Localhost:8080/sga-jee-web/webservice/application.wadl?detail=true"
 * Para ver el XSD: http://localhost:8080/sga-jee-web/webservice/application.wadl/xsd0.xsd
 * Para obtener un listado de todas las personas: http://localhost:8080/sga-jee-web/webservice/personas/
 * Para obtener persona con id=1:   http://localhost:8080/sga-jee-web/webservice/personas/1
 */

@Path("/personas") //uri inicial del servicio web
@Stateless
public class PersonaServiceRS {

    @Inject //Inyectamos el servicio (inyección de dependencia)
    private PersonaService personaService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Persona encontrarPersonaPorId(@PathParam("id") int id) {
        return personaService.encontrarPersonaPorId(new Persona(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //Tipo myme que produce
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //Tipo myme que puede aceptar
    public Response agregarPersona(Persona persona) {
        try {
            personaService.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        try {
            Persona persona = personaService.encontrarPersonaPorId(new Persona(id));
            if (persona != null) {
                personaService.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }

    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
            personaService.eliminarPersona(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
        
    }
}
