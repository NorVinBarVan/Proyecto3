package Patrones;

import Entidades.SolicitudDeCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Stateless
public class SolicitudDeCompraFacade extends AbstractFacade<SolicitudDeCompra> {
    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudDeCompraFacade() {
        super(SolicitudDeCompra.class);
    }
    
}
