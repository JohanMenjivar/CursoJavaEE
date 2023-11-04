
package sv.com.gm.sga.cliente.asociaciones;
import javax.persistence.*;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;
public class PersistenciaCascadaJPA {
    static Logger log=LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com", "55778822");
        
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);
        
        em.persist(usuario1);
        
        tx.commit();
        
        log.debug("objeto persistido persona:" + persona1);
        log.debug("objeto persistido usuario:" + usuario1);
        
        em.close();
    }
}
