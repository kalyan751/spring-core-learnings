package in.pwskills.kalyan.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.Cricketer;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) throws IOException {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
		Cricketer cricketer = context.getBean(Cricketer.class);
		System.out.println("Implementation class object :: " + cricketer.getClass().getName());
		
		cricketer.fielding();
		cricketer.bowling();
		cricketer.wicketKeeping();
		cricketer.batting();

		
		
		
		//closing the container
		((AbstractApplicationContext)context).close();
		

	}

}
