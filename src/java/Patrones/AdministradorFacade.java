package Patrones;

import Entidades.Administrador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> {
    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }
    
}
