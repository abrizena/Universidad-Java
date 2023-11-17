
package test;

import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.util.List;

/**
 *
 * @author antonio
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        UsuarioDaoJDBC usuarioDao = new UsuarioDaoJDBC();

        //INSERTAR UN NUEVO OBJETO USUARIO
        UsuarioDTO usuarioNuevo = new UsuarioDTO("pepe.lopez", "123");
        usuarioDao.insert(usuarioNuevo);

        //MODIFICAR REGISTRO USUARIO
//        UsuarioDTO usuarioModificar=new UsuarioDTO(3,"juan.lopez", "123");
//        usuarioDao.actualizar(usuarioModificar);
        
//        //ELIMINAR REGISTRO USUARIO
//        UsuarioDTO usuarioEliminar=new UsuarioDTO(3);
//        usuarioDao.eliminar(usuarioEliminar);
        
        //LISTAR USUARIOS
        List<UsuarioDTO> usuarios = usuarioDao.select();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        
    }
    

}
