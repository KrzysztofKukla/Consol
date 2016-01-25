package pl.kukla.krzys.consol.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for Hibernate
 * @author Krzysztof
 *
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	@Bean
	public DataSource dataSource(){
		// In real application dataSource should be implemented as pool of connections on the server 
		// but in development mode it could be implement as it is 
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(org.postgresql.Driver.class);
		dataSource.setUrl("jdbc:postgresql://localhost:5432/consol");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("pl.kukla.krzys.consol.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new HibernateTransactionManager(sessionFactory().getObject());
	}
	
	private Properties hibernateProperties(){
		Properties prop = new Properties();
		prop.put("hibernate.dialect", org.hibernate.dialect.PostgreSQL94Dialect.class.getName());
		prop.put("hibernate.show_sql", true);
		
		// in production mode application this should be removed
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}

}
