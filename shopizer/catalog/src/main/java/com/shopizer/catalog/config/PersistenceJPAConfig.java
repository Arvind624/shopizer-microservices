package com.shopizer.catalog.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class PersistenceJPAConfig {

	// H2, need to test MySQL and PostGres
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();

		/**
		 * BasicDataSource dataSource = new BasicDataSource();
		 * dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		 * dataSource.setUrl(env.getProperty("jdbc.url"));
		 * dataSource.setUsername(env.getProperty("jdbc.user"));
		 * dataSource.setPassword(env.getProperty("jdbc.pass")); return dataSource;
		 **/

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.shopizer.model","com.shopizer.db");
		//factory.setHibernateProperties(hibernateProperties());
		factory.setDataSource(dataSource());
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	/*
	 * Properties hibernateProperties() { return new Properties() { {
	 * setProperty("hibernate.hbm2ddl.auto",
	 * env.getProperty("hibernate.hbm2ddl.auto")); setProperty("hibernate.dialect",
	 * env.getProperty("hibernate.dialect")); } }; }
	 */

}
