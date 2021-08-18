package db;

import io.dropwizard.hibernate.AbstractDAO;
import models.InfoModel;
import org.hibernate.SessionFactory;

import java.util.List;

public class InfoDao extends AbstractDAO<InfoModel> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public InfoDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<InfoModel> findAll() {
        return list(namedTypedQuery("com.wordpress.nullpointerexception1.info.findAll"));
    }
}
