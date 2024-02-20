
package test;


import domain.Persona;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author antonio
 */
public class PruebaRestWS {
    public static void main(String[] args) {
        
        //Para pasar autentificacion
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client cliente = ClientBuilder.newClient(clientConfig);
        
        //Llamada usando el cliente
        WebTarget webTarget = cliente.target("http://localhost:8080/sga-jee-web/webservice").path("/personas"); //Solo con este target llamaría al método listarPersonas, configurado en el path /personas
            //Proporcionamos un idPersona valido
        Persona persona = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Persona.class); //Al adjuntar un id al path del target nos devolverá la Persona con ese id
        System.out.println("Persona recuperada: = " + persona);
    }
}
