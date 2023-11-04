
package sv.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import sv.com.gm.sga.domain.Usuario;

@Local
public interface UsuarioService {
public List<Usuario> listarUsuarios();

public Usuario encontrarUsuarioPorId(Usuario usuario);

public Usuario encontrarUsuarioPorUsername(Usuario usuario);

public void registrarUsuario(Usuario usuario);

public void modificarUsuario(Usuario usuario);

public void eliminarUsuario(Usuario usuario);
    
}