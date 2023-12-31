
package sv.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.domain.Usuario;

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        em.close();
        
        for(Persona persona : personas){
            log.debug("Persona: "+ persona);
            for (Usuario usuario : persona.getUsuarioList() ){
                log.debug("usuario: "+ usuario);
            }
        }
    }
}
