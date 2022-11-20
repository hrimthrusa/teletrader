package com.example.teletrader.repositories;

import org.hibernate.SessionFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration()
public class SessionFactoryConfig {
//    @Bean("dataSource")
//    public DataSource getDataSource() {
//        DataSourceBuilder b = DataSourceBuilder.create();
//        b.url("jdbc:postgresql://localhost:5432/teletrader");
//        b.driverClassName("org.postgresql.Driver");
//        b.username("postgres");
//        b.password("postgres");
//        return b.build();
//    }
//
//
//    //sessionfactory bean
//    @Bean(name="session")
////    @Bean
//    public SessionFactory getSessionFactory(DataSource dataSource) {
//
//        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
//
//        builder.addProperties(getHibernateProperties());
//        builder.scanPackages("ORM.Model");
//
//        return builder.buildSessionFactory();
//    }
//
//    //Hibernate properties:
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.format_sql", "true");
//        properties.put("hibernate.hbm2ddl.auto", "none");
//
//        return properties;
//    }
//
//    //transaction manager bean
//    @Bean
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//        return transactionManager;
//    }
}
