package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author antonio
 */
public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;
        
        //EJEMPLO TRANSACCIÓN
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false); //PARA QUE SEA TRANSACCIONAL HAY QUE PONER A false EL AUTOCOMMIT
            }
            
            PersonaDAO personaDao = new PersonaDaoJDBC(conexion); //Le pasamos la conexión transaccional
            
            //LISTAR PERSONAS
            List<PersonaDTO> personas = personaDao.select();
            
            for (PersonaDTO persona:personas){
                System.out.println("Persona DTO:" + persona);
            }
            
//            PersonaDTO cambioPersona = new PersonaDTO();
//            cambioPersona.setIdPersona(2);
//            cambioPersona.setNombre("Karla Ivonne");
//            cambioPersona.setApellido("Gomez");
//            cambioPersona.setEmail("kgomez@mail.com");
//            cambioPersona.setTelefono("7713445678");
//            personaDao.update(cambioPersona);
//            
//            PersonaDTO nuevaPersona = new PersonaDTO();
//            nuevaPersona.setNombre("Carlos");
//            nuevaPersona.setApellido("Ramirez");
//            personaDao.insert(nuevaPersona);
            
            //Hacemos COMMIT
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion = ");
            
            //INSERTAR UN NUEVO OBJETO PERSONA
//        PersonaDTO personaNueva = new PersonaDTO("Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.insert(personaNueva);

        //MODIFICAR REGISTRO PERSONA
//        PersonaDTO personaModificar=new PersonaDTO(4,"Juan Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.update(personaModificar);
        
        //ELIMINAR REGISTRO PERSONA
//        PersonaDTO personaEliminar=new PersonaDTO(4);
//        personaDao.eliminar(personaEliminar);
        
        //LISTAR PERSONAS

        
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
//        for(PersonaDTO persona:personas){
//            System.out.println("persona = " + persona);
//        }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1){
                ex1.printStackTrace(System.out);
            }
            
        }

        
    }

}
