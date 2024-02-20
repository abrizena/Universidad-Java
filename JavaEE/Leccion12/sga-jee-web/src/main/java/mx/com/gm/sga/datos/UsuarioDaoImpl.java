/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author antonio
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
    @PersistenceContext(unitName="SgaPU")
    EntityManager em;
    
    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        Query query = em.createNamedQuery("from Usuario p where p.username =: username"); //No es SQL sino JPQL, recupera objetos completos y no columnas de la tabla Usuario
        query.setParameter("username", usuario.getUsername());
        return (Usuario) query.getSingleResult(); //el campo email debe marcarse como UQ (unico) en la tabla de la base de datos, osea que no puede haber email duplicados
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario)); //Antes de removerlo, debemos sincronizar el estado con un merge
    }
    
}
