
package sv.com.gm.sga.cliente;
import org.apache.logging.log4j.*;
import javax.naming.*;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.servicio.PersonaServiceRemote;

public class PruebaManejoTransacciones {
    static Logger  log = LogManager.getRootLogger();
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaservice = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-leccion3/PersonaServiceImpl!sv.com.gm.sga.servicio.PersonaServiceRemote");
            log.debug("iniciando prueba Manejo transaccional persona service");
            //Buscar un objeto persona
            Persona persona1 = personaservice.encontrarPersonaPorId(new Persona(1));
            log.debug("persona recuperada: " + persona1);
            
            //Cambiar el apellido de ersona
            //persona1.setApellido("cambio***********************************************************************************************************************");
           persona1.setApellido("perez");
            personaservice.modificarPersona(persona1);
            log.debug("persona modificada: " + persona1);
            log.debug("fin prueba EJB transaccional");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
