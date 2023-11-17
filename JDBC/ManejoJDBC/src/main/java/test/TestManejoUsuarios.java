
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author antonio
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();

        //INSERTAR UN NUEVO OBJETO USUARIO
//        Usuario usuarioNuevo = new Usuario("pepe.lopez", "123");
//        usuarioDao.insertar(usuarioNuevo);

        //MODIFICAR REGISTRO USUARIO
//        Usuario usuarioModificar=new Usuario(3,"juan.lopez", "123");
//        usuarioDao.actualizar(usuarioModificar);
        
//        //ELIMINAR REGISTRO USUARIO
//        Usuario usuarioEliminar=new Usuario(3);
//        usuarioDao.eliminar(usuarioEliminar);
        
        //LISTAR USUARIOS
        List<Usuario> usuarios = usuarioDao.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        
    }
    

}
