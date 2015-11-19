package Patrones;

import Entidades.Agencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Stateless
public class AgenciaFacade extends AbstractFacade<Agencia> {
    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenciaFacade() {
        super(Agencia.class);
    }
    
}
