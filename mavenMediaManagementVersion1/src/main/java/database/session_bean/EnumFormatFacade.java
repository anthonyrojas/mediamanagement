
package database.session_bean;

import database.entity.EnumFormat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnumFormatFacade extends AbstractFacade<EnumFormat> {

    @PersistenceContext(unitName = "com.mycompany_mavenMediaManagementVersion1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnumFormatFacade() {
        super(EnumFormat.class);
    }

}
