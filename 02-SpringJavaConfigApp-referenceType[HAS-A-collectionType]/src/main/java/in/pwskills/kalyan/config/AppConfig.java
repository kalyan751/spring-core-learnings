package in.pwskills.kalyan.config;



import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.pwskills.kalyan.bean.Employee;





//telling the IOC container that this is a configuration file denoting with annotation @Configuration
//this is the configuration details that the IOC container will execute, creates a bean, keep it in IOC cache and then give it to you
@Configuration
public class AppConfig {
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig object is created...");
	}
	
	//telling the IOC container that this is a bean please execute the bean by using @Bean
	//giving some name for the bean and using that name instead for the method name
	@Bean(name = "emp")
	public Object empObj() { // this bean should create and return a Employee  obj
		
		System.out.println("AppConfig.empObj() : object is getting created" );
		
		//1. creating the dependent object
		List<String> friends = List.of("saurav", "sachin", "Dravid");
		Set<String> numbers = Set.of("9191919919","8283746578", "0987651674");
		Map<String, String> accountNumbers = Map.of("Canara","1221", "SBI", "322");
 		
		
		//2. creating the target object
		Employee employee = new Employee(10,23456.5f,friends,numbers,accountNumbers);
		
		return employee;
	}
	
}
