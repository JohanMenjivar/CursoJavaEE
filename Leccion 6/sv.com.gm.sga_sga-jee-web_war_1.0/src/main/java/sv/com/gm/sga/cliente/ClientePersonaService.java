package sv.com.gm.sga.cliente;

import java.util.List;
import javax.naming.*;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("iniciando llamada al EJB desde el cliente\n");
        try{
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService=(PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl");
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona:personas){
                System.out.println(persona.toString()+"\n");
            }
            System.out.println("fin ade llamana a ejb");
        }catch(NamingException ex){
            ex.printStackTrace(System.out);
        }
    }
   
}
 