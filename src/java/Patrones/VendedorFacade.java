package Patrones;

import Entidades.Vendedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> {
    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedorFacade() {
        super(Vendedor.class);
    }
    
}
