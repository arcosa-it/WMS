package com.websystique.springmvc.configuration;



import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.websystique.springmvc")
public class DataBaseConfiguration {
    @Value("${jdbc.driverClassName}")

    private String driverClassName;

    @Value("${jdbc.url}")

    private String url;

    @Value("${jdbc.username}")

    private String username;

    @Value("${jdbc.password}")

    private String password;

/*    @Value("${MySQL.minPoolSize}")

    private int maxIdle;

    @Value("${MySQL.maxPoolSize}")

    private int maxActive;
*/

    @Value("${hibernate.dialect}")

    private String dialect;

    @Value("${jpa.showSql}")

    private String showSql;

    @Value("${jpa.generateDdl}")

    private String generateDdl;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        try {
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }


    /*@Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setPersistenceUnitName("MYSQL");
        entityManagerFactory.setJpaPropertyMap(new java.util.HashMap<String, String>() {{


            put("hibernate.archive.autodetection", "class,hbm");

            put("hibernate.connection.release_mode", "on_close");

            put("hibernate.hbm2ddl.auto","create");
        }});
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setJpaDialect(jpaDialect());
        return entityManagerFactory;
    }*/

    @Bean(name = "MySQL")
    public EntityManagerFactory entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
        lcemfb.setPersistenceUnitName("MySQL");
        lcemfb.setDataSource(getDataSource());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lcemfb.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.generate_statistics", false);
        jpaProperties.put("hibernate.show_sql", true);
        lcemfb.setJpaProperties(jpaProperties);
        lcemfb.setPackagesToScan("com.websystique.springmvc.domain");
        lcemfb.afterPropertiesSet();
        return lcemfb.getObject();
    }

    @Bean(name = "jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        return vendorAdapter;
    }

    @Bean(name = "jpaDialect")
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }


    @Bean(name = "persistenceExceptionTranslation")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }



   /* @Bean

    public LocalContainerEntityManagerFactoryBean sessionFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        try {
            factoryBean.setDataSource(getDataSource());

            //factoryBean.setPersistenceUnitName("MySQL");

            //factoryBean.setPackagesToScan("com.websystique.springmvc.domain");

            factoryBean.setPackagesToScan(getClass().getPackage().getName());

            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

            jpaVendorAdapter.setShowSql(Boolean.valueOf(showSql));

            jpaVendorAdapter.setGenerateDdl(Boolean.valueOf(generateDdl));

            jpaVendorAdapter.setDatabasePlatform(dialect);

            factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

            factoryBean.setJpaPropertyMap(new java.util.HashMap<String, String>() {{

                put("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");

                put("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");

                put("hibernate.connection.release_mode", "on_close");

            }});
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return factoryBean;

    }


    /*@SuppressWarnings("static-access")

    @Bean

    public JtaTransactionManager jtaTransactionManager() throws javax.transaction.SystemException {

        JtaTransactionManager transactionManager = new JtaTransactionManager();

        com.atomikos.icatch.jta.UserTransactionManager atomikosTransactionManager = new com.atomikos.icatch.jta.UserTransactionManager();

        atomikosTransactionManager.init();

        atomikosTransactionManager.setForceShutdown(true);

        atomikosTransactionManager.setStartupTransactionService(true);

        atomikosTransactionManager.setTransactionTimeout(60);

        atomikosTransactionManager.close();

        com.atomikos.icatch.jta.UserTransactionImp atomikosUserTransaction = new com.atomikos.icatch.jta.UserTransactionImp();

        transactionManager.setTransactionManager(atomikosTransactionManager);

        transactionManager.setUserTransaction(atomikosUserTransaction);

        transactionManager.setTransactionSynchronization(transactionManager.SYNCHRONIZATION_ON_ACTUAL_TRANSACTION);

        return transactionManager;

    }
    */
}
