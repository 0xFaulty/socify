package cloud.socify.config;

import cloud.socify.dao.DataResourceDao;
import cloud.socify.dao.DataResourceDaoImpl;
import cloud.socify.dao.PublicationDao;
import cloud.socify.dao.PublicationDaoImpl;
import cloud.socify.dao.SubscriptionDao;
import cloud.socify.dao.SubscriptionDaoImpl;
import cloud.socify.dao.UserDao;
import cloud.socify.dao.UserDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.clean();
        flyway.migrate();
        return flyway;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DSLContext dslContext(DataSource dataSource) {
        return DSL.using(dataSource, SQLDialect.POSTGRES_9_5);
    }

    @Bean
    public DataResourceDao dataResourceDao() {
        return new DataResourceDaoImpl();
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
    public UserDao userDao(ObjectMapper objectMapper, DSLContext dslContext) {
        return new UserDaoImpl(objectMapper, dslContext);
    }

}
