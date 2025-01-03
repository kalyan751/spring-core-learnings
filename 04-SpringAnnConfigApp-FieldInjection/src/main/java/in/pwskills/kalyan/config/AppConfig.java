package in.pwskills.kalyan.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.pwskills.kalyan.bean.Employee;





//telling the IOC container that this is a configuration file denoting with annotation @Configuration
//this is the configuration details that the IOC container will execute, creates a bean, keep it in IOC cache and then give it to you
@Configuration
@ComponentScan(basePackages ="in.pwskills.kalyan" ) //using this for component mapping : means telling please scan for annotation marked with @Component in this package 
public class AppConfig {
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig object is created...");
	}
	
	
	/*
	//telling the IOC container that this is a bean please execute the bean by using @Bean
	//giving some name for the bean and using that na0me instead for the method name
	@Bean(name = "emp")
	public Object empObj() { // this bean should create and return a Employee  obj
		
		System.out.println("AppConfig.empObj() : object is getting created" );
		
		
		return null;
	}
	*/
	
}
