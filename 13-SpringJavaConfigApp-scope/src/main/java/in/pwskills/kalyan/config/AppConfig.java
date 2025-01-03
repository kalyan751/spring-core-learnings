package in.pwskills.kalyan.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import in.pwskills.kalyan.bean.Printer;
import in.pwskills.kalyan.bean.WishMessageGenerator;



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
	@Bean(name = "wmg1")
	@Scope("prototype")// different object wont be created by IOC container this time
	public WishMessageGenerator wmgObj() { // this bean should create and return a WishMessageGenerator obj
		
		System.out.println("AppConfig.wmgObj1() :: creating the object");
		
		//how should the object be created
		//1.  create the targe object
		WishMessageGenerator generator = new WishMessageGenerator();
		
		//Creating the dependent object
		LocalDateTime ldt = LocalDateTime.now();
		
		//linking the object using the setter style
		generator.setLdt(ldt);
		
		return generator;
	}
	@Bean(name = "wmg2")
	@Scope("prototype") // different object wont be created by IOC container this time
	public WishMessageGenerator wmgObj2() { // this bean should create and return a WishMessageGenerator obj
		
		System.out.println("AppConfig.wmgObj2() :: creating the object");
		
		//how should the object be created
		//1.  create the targe object
		WishMessageGenerator generator = new WishMessageGenerator();
		
		//Creating the dependent object
		LocalDateTime ldt = LocalDateTime.now();
		
		//linking the object using the setter style
		generator.setLdt(ldt);
		
		return generator;
	}
	
	@Bean(name = "p1")
	public Printer getPrinterObj1() {
		return Printer.getInstance();
	}
	@Bean(name = "p2")
	public Printer getPrinterObj2() {
		return Printer.getInstance();
	}
	
}
