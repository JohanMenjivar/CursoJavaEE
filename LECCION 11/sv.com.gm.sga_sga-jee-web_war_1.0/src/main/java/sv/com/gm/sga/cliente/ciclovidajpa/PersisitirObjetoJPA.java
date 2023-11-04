
package sv.com.gm.sga.cliente.ciclovidajpa;

import org.apache.logging.log4j.*;
import javax.persistence.*;
import sv.com.gm.sga.domain.Persona;

public class PersisitirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Persona persona1= new Persona("Pedro","Luna","pedro@gmail.com","13132153");
        tx.begin();
        em.persist(persona1);
        log.debug("Objeto persistido - sin commit: "+persona1);
        tx.commit();
        log.debug("Objeto persiste - estado detached:"+persona1);
        em.close();


    }
}
