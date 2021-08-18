import config.DatabaseConfiguration;
import controller.InfoResource;
import db.InfoDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import models.InfoModel;

public class MyApplication extends Application<DatabaseConfiguration> {
    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    public void run(DatabaseConfiguration myConfiguration, Environment environment) throws Exception {
        System.out.println("Value from dev.yml is "+myConfiguration.getDataSourceFactory().getUser());
        InfoDao infoDao = new InfoDao(hibernate.getSessionFactory());
        final InfoResource resource = new InfoResource(infoDao);
        environment.jersey().register(resource);

    }

    private HibernateBundle<DatabaseConfiguration> hibernate = new HibernateBundle<DatabaseConfiguration>(InfoModel.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(DatabaseConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "dropwizard-hibernate";
    }

    @Override
    public void initialize(Bootstrap<DatabaseConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }
}
