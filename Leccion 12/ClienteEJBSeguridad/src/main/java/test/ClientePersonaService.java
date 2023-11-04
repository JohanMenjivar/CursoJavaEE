package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.*;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        
        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        programmaticLogin.login("admin", "admin".toCharArray());
        
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-leccion12/PersonaServiceImpl!sv.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona p : personas){
                System.out.println("persona:" + p);
            }
            System.out.println("\nFin llamada al EJB desde el cliente");
            
            
        } catch (NamingException ex) {
           ex.printStackTrace(System.out);
        }
        
    }
}
