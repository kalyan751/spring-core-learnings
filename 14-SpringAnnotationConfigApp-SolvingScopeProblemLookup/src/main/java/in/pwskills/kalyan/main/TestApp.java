package in.pwskills.kalyan.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.Flipkart;
import in.pwskills.kalyan.beans.ICourier;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) throws IOException {
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
		
		
		Flipkart f1 = context.getBean("flipkart", Flipkart.class);
		ICourier courier1 = f1.getCourier();
		System.out.println("courier :: "+courier1);
		System.out.println(f1);

		System.in.read();

		Flipkart f2 = context.getBean("flipkart", Flipkart.class);
		ICourier courier2 = f2.getCourier();
		System.out.println("Courier :: "+courier2);
		System.out.println(f2);

		
		
		
		//closing the container
		((AbstractApplicationContext)context).close();
		

	}

}
