package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource
			dataSource) {
		LocalSessionFactoryBean sessionFactory = new
				LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		//FIXME: ścieżka do klas oznaczonych @Entity
		sessionFactory.setPackagesToScan("src/main/java");
		
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", 
				"org.hibernate.dialect.MySQL8Dialect");
		
	}
}
