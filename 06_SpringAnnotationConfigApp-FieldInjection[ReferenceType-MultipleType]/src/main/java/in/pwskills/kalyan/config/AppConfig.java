
//part where we are dealing with the IOC container.

//for constructor injection first the dependent object should be created then the target object should be created
package in.pwskills.kalyan.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackages = "in.pwskills.kalyan")
public class AppConfig { 
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig :  object is created...");
	}
	
	
	

	

		
	}
	
	
