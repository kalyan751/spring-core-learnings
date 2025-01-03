package in.pwskills.kalyan;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.Employee;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		
		System.out.println("******Starting the container*****");
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
		Employee employee = context.getBean("employee",Employee.class);
		
		System.out.println(employee);

		
		//closing the container
		((AbstractApplicationContext)context).close();
		System.out.println("******closing the container*****");

	}

}
