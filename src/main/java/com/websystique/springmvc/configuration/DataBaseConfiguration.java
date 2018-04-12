package com.websystique.springmvc.configuration;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

import static org.apache.log4j.MDC.put;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:jdbc.properties")
public class DataBaseConfiguration {
    @Value("${MySQL.connection.driver_class}")

    private String driverClassName;

    @Value("${MySQL.connection.url}")

    private String url;

    @Value("${MySQL.connection.username}")

    private String username;

    @Value("${MySQL.connection.password}")

    private String password;

    @Value("${MySQL.minPoolSize}")

    private int maxIdle;

    @Value("${MySQL.maxPoolSize}")

    private int maxActive;

    @Value("${MySQL.dialect}")

    private String dialect;

    @Value("${MySQL.show_sql}")

    private boolean showSql;

    @Value("${MySQL.generateDdl}")

    private boolean generateDdl;

    @Bean

    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {

        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();

        ppc.setLocation(new ClassPathResource("jdbc.properties"));

        ppc.setIgnoreUnresolvablePlaceholders(true);

        return ppc;

    }

    @Bean

    public javax.sql.DataSource dataSource() {

        org.apache.commons.dbcp.BasicDataSource mysqlDs = new org.apache.commons.dbcp.BasicDataSource();

        try {

            mysqlDs.setDriverClassName(driverClassName);

            mysqlDs.setUsername(username);

            mysqlDs.setPassword(password);

            mysqlDs.setUrl(url);

            mysqlDs.setMaxIdle(maxIdle);

            mysqlDs.setMaxActive(maxActive);

            mysqlDs.close();

        } catch (java.sql.SQLException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        return mysqlDs;

    }

    /*@Bean

    public LocalContainerEntityManagerFactoryBean sessionFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource());

        factoryBean.setPersistenceUnitName("MySQL");

        factoryBean.setPackagesToScan("com.websystique.springmvc.domain");

        org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter jpaVendorAdapter = new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter();

        jpaVendorAdapter.setShowSql(showSql);

        jpaVendorAdapter.setGenerateDdl(generateDdl);

        jpaVendorAdapter.setDatabasePlatform(dialect);

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        factoryBean.setJpaPropertyMap(	new java.util.HashMap<String, String>()	{{

            put("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");

            put("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");

            put("hibernate.connection.release_mode", "on_close");

        }});

        return factoryBean;

    }*/

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

    }*/
}
