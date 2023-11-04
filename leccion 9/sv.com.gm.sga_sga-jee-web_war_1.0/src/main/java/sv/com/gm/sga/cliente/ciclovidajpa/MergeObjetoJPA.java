
package sv.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sv.com.gm.sga.domain.Persona;

public class MergeObjetoJPA {
        static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Persona persona1= new Persona();
        tx.begin();
        persona1=em.find(Persona.class, 5);
        
        persona1.setApellido("cocolito");
        tx.commit();
        log.debug("Objeto recuperado: "+persona1);

        em.close();


    }
}
