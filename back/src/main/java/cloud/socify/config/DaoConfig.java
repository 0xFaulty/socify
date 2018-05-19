package cloud.socify.config;

import cloud.socify.dao.DataSourceDao;
import cloud.socify.dao.DataSourceDaoImpl;
import cloud.socify.dao.PublicationDao;
import cloud.socify.dao.PublicationDaoImpl;
import cloud.socify.dao.SubscriptionDao;
import cloud.socify.dao.SubscriptionDaoImpl;
import cloud.socify.dao.UserDao;
import cloud.socify.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public DataSourceDao dataSourceDao() {
        return new DataSourceDaoImpl();
    }

    @Bean
    public PublicationDao publicationDao() {
        return new PublicationDaoImpl();
    }

    @Bean
    public SubscriptionDao subscriptionDao() {
        return new SubscriptionDaoImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

}
