package in.pwskills.kalyan.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;





//telling the IOC container that this is a configuration file denoting with annotation @Configuration
//this is the configuration details that the IOC container will execute, creates a bean, keep it in IOC cache and then give it to you
@Configuration
@ComponentScan(basePackages = "in.pwskills.kalyan")
//@PropertySource("application.properties") // we cannot use application.properties file because heer we cannot tell that take details form the properties file 
public class AppConfig {
	
	//since we cannot use properties file we need to do field injectino for Environment type
	@Autowired
	private Environment environment;
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig object is created...");
	}
	
	@Bean(value = "ds")
	public DataSource getDbDetails() {
		
		System.out.println("Implementation class is : " + environment.getClass().getName());
		 
		DriverManagerDataSource datasource =  new  DriverManagerDataSource();
		datasource.setUrl(environment.getProperty("db.mysql.url"))	;
		datasource.setUsername(environment.getProperty("db.mysql.username"));
		datasource.setPassword(environment.getProperty("db.mysql.password"));
		return datasource;
		
	}
	
	
}
