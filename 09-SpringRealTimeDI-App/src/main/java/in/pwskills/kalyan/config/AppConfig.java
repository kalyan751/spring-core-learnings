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
@PropertySource("application.properties") // we cannot use application.properties file because heer we cannot tell that take details form the properties file 
public class AppConfig {
	
	//binding the database detals with user defined objects
	@Autowired
	private Environment environment; // this will be binded automatically because when you start the IOC container the object of Environment is already present in the IOC cache thats w
	
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig object is created...");
	}
	
	
	@Bean(name = "datasource")
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(environment.getProperty("db.mysql.url"));
		dataSource.setUsername(environment.getProperty("db.mysql.username"));
		dataSource.setPassword(environment.getProperty("db.mysql.password"));
		
		return dataSource;
	}
	
	
	
}
