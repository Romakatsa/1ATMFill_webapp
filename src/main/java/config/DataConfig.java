package config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Roma on 25.03.2018.
 */
@Configuration
@EnableTransactionManagement
//@ComponentScan({ "config" })
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories(basePackages = {"repository"})
public class DataConfig {


    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("db.entitymanager.packages.to.scan"));
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));

        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("db.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("db.hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("db.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("db.hibernate.hbm2ddl.auto"));

        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
