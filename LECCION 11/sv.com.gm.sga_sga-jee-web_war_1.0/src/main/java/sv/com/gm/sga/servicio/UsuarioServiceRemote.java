package sv.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import sv.com.gm.sga.domain.Usuario;

@Remote
public interface UsuarioServiceRemote {
    
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
}
