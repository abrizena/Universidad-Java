/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author antonio
 */
public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="antonio";
    private static final String JDBC_PASSWORD="alicanteSQL";
    
    //PARA UTILIZAR POOL DE CONEXIONES CON APACHE COMMONS
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //Definimos el tamaño del pool de conexiones
        ds.setInitialSize(5); //No comenzar con un tamaño muy grande
        return ds;
    }
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection(); //Obtiene conexión del pool de conexiones
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
