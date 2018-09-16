package com.bmo.alerts.bs.config;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
  
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.bmo"})
public class HibernateTestConfiguration {
 
    @Autowired
    private Environment environment;
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.bmo.alerts.bs.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
 
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
   /* @Bean(name = "dataSource")
    public DataSource dataSource() {
      return new EmbeddedDatabaseBuilder()
        .generateUniqueName(false)
        .setName("testdb")
        .setType(EmbeddedDatabaseType.H2)
        .addDefaultScripts()
        .setScriptEncoding("UTF-8")
        .ignoreFailedDrops(true)
        .build();
    }
 */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }
   /* @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource mainDataSource) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(mainDataSource);
        return transactionManager;
    }*/
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}
