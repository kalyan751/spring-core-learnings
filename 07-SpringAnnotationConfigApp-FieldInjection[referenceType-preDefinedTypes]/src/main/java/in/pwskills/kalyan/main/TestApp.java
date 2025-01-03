package in.pwskills.kalyan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
 
		//closing the container
		((AbstractApplicationContext)context).close();
		

	}

}
