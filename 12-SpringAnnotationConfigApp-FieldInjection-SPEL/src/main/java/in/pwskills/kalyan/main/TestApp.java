package in.pwskills.kalyan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.bean.Flipkart;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
		//working with the bean created by the IOC container
		String[] definitionNames = context.getBeanDefinitionNames();
		
		
		//iterating over definitionNames
		System.out.println("Printing the definition names");
		for(String data : definitionNames) {
			System.out.println(data);
		}
		
		//now getting the targetObject
		Flipkart flipkart = context.getBean("flipkart",Flipkart.class);
		System.out.println("flipkart obj : " +flipkart);
		
		//closing the container
		((AbstractApplicationContext)context).close();
		

	}

}
