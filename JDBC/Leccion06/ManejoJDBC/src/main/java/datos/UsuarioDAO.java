
package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author antonio
 */
public interface UsuarioDAO {
    public List<UsuarioDTO> select();
    public int insert(UsuarioDTO usuario) throws SQLException;
    public int update(UsuarioDTO usuario) throws SQLException;
    public int delete(UsuarioDTO usuario) throws SQLException;
}
