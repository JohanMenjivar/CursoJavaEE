package sv.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.*;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import sv.com.gm.sga.domain.Persona;
import sv.com.gm.sga.datos.PersonaDao;

@Stateless
@WebService(endpointInterface = "sv.com.gm.sga.servicio.PersonaServiceWS")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWS {

    @Inject
    private PersonaDao personaDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try {
            personaDao.updatePersona(persona);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
}
