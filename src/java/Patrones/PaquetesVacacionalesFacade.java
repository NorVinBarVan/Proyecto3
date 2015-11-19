package Patrones;

import Entidades.PaquetesVacacionales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Stateless
public class PaquetesVacacionalesFacade extends AbstractFacade<PaquetesVacacionales> {
    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaquetesVacacionalesFacade() {
        super(PaquetesVacacionales.class);
    }
    
}
