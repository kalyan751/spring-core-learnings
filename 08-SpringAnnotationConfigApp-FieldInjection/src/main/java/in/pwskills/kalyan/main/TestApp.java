package in.pwskills.kalyan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.Flipkart;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		System.out.println();
		/*
		//getting  the bean names
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
		*/
		
		
		Flipkart flipkart = context.getBean("flipkart",Flipkart.class);
		String status = flipkart.Shopping(new String[] {"fossil watch","lp belts","arrow shoes"}, new float[] {56700.5f,3500.5f,400.50f});
		System.out.println("Status : " + status);
		
		
		//closing the container
		((AbstractApplicationContext)context).close();
		

	}

}
