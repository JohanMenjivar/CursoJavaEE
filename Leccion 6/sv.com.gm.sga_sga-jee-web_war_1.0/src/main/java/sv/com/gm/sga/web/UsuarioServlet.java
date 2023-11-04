
package sv.com.gm.sga.web;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.com.gm.sga.domain.Usuario;

import sv.com.gm.sga.servicio.UsuarioService;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet{
        @Inject
        UsuarioService usuarioService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Usuario> usuario = usuarioService.listarUsuarios();
        System.out.println("usuarios:" + usuario);
        request.setAttribute("usuarios", usuario);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
    
}
