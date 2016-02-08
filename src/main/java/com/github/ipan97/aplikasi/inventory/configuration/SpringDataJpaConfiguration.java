/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.aplikasi.inventory.configuration;

/**
 *
 * @author linux
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ifnu.b.fatkhan
 */
@Configuration
@EnableJpaRepositories(basePackages = {
        "com.github.ipan97.aplikasi.inventory"
})
@ComponentScan("com.github.ipan97.aplikasi.inventory")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class SpringDataJpaConfiguration {
    @Autowired private Environment environment;
    @Bean
    DataSource dataSource(){
        HikariConfig configDataSource = new HikariConfig();
        configDataSource.setDriverClassName(environment.getRequiredProperty("dataSourceClassName"));
        configDataSource.setJdbcUrl(environment.getRequiredProperty("dataSource.url"));
        configDataSource.setUsername(environment.getRequiredProperty("dataSource.user"));
        configDataSource.setPassword(environment.getRequiredProperty("dataSource.password"));
        configDataSource.addDataSourceProperty("cachePrepStmts", "true");
        configDataSource.addDataSourceProperty("prepStmtCacheSize", "250");
        configDataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource dataSource=new HikariDataSource(configDataSource);
        return dataSource;
    }
    
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.github.ipan97.aplikasi.inventory");
 
        Properties jpaProperties = new Properties();
     
        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
 
        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", "true");
 
        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql","true");
 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
    }
    
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}

