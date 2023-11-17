package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                conexion.setAutoCommit(false);
            }
            
            PersonaDAO personaDao = new PersonaDAO(conexion); //Le pasamos la conexión transaccional
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellido("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setTelefono("7713445678");
            personaDao.actualizar(cambioPersona);
            
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellido("Ramirez");
            personaDao.insertar(nuevaPersona);
            
            //Hacemos COMMIT
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion = ");
            
            //INSERTAR UN NUEVO OBJETO PERSONA
//        Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.insertar(personaNueva);

        //MODIFICAR REGISTRO PERSONA
//        Persona personaModificar=new Persona(4,"Juan Carlos", "Esparza", "cesparza@mail.com", "554456533");
//        personaDao.actualizar(personaModificar);
        
        //ELIMINAR REGISTRO PERSONA
//        Persona personaEliminar=new Persona(4);
//        personaDao.eliminar(personaEliminar);
        
        //LISTAR PERSONAS
        List<Persona> personas = personaDao.seleccionar();
        
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
//        for(Persona persona:personas){
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
