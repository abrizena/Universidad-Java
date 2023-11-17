package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

/**
 *
 * @author antonio
 */
public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        //INSERTAR UN NUEVO OBJETO PERSONA
//        Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.insertar(personaNueva);

        //MODIFICAR REGISTRO PERSONA
//        Persona personaModificar=new Persona(4,"Juan Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.actualizar(personaModificar);
        
        //ELIMINAR REGISTRO PERSONA
        Persona personaEliminar=new Persona(4);
        personaDao.eliminar(personaEliminar);
        
        //LISTAR PERSONAS
        List<Persona> personas = personaDao.seleccionar();
        
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
//        for(Persona persona:personas){
//            System.out.println("persona = " + persona);
//        }

        
    }

}
