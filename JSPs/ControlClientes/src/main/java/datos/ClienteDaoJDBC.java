/*
 * 
 * Podiamos haber creado una interface para esta clase
 */
package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;


/**
 *
 * @author antonio
 */
public class ClienteDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo"
            + " FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo"
            + " FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo)"
            + " VALUES(?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE cliente"
            + " SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";
    
    
    // LISTAR CLIENTES
    public List<Cliente> listar(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Cliente cliente=null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {            
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            //Iteramos el resultSet devuelto y vamos añadiendo a la lista los objetos cliente
            while(rs.next()){
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return clientes;
    }
    
    
    // BUSCAR CLIENTE
    public Cliente encontrar(Cliente cliente){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try {            
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1); //Nos posicionamos en el primer registro devuelto
            
            //Pasamos los datos del resultSet a nuestro objeto cliente 
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");
                
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return cliente;
    }
    
    // INSERTAR CLIENTE
    public int insertar(Cliente cliente){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows =0; //Para indicar cuantos registros se han modificado
        
        try {            
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);

            //Definimos los parámetros del SQL_INSERT
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    // ACTUALIZAR CLIENTE
    public int actualizar(Cliente cliente){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows =0; //Para indicar cuantos registros se han modificado
        
        try {            
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_UPDATE);

            //Definimos los parámetros del SQL_UPDATE
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente()); //Para el WHERE de la consulta SQL_UPDATE, filtra por id_cliente
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    // ELIINAR CLIENTE
    public int eliminar(Cliente cliente){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows =0; //Para indicar cuantos registros se han eliminado
        
        try {            
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);

            //Definimos los parámetros del SQL_DELETE
            stmt.setInt(1, cliente.getIdCliente()); //Para el WHERE de la consulta SQL_DELETE, filtra por id_cliente
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
}
