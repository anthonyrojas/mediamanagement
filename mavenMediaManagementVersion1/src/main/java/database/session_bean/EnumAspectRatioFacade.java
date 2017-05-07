
package database.session_bean;

import database.entity.EnumAspectRatio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnumAspectRatioFacade extends AbstractFacade<EnumAspectRatio> {

    @PersistenceContext(unitName = "com.mycompany_mavenMediaManagementVersion1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnumAspectRatioFacade() {
        super(EnumAspectRatio.class);
    }

}
