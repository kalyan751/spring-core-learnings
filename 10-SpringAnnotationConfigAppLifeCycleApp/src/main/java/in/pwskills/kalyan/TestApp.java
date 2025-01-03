package in.pwskills.kalyan;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.VoterVerifier;
import in.pwskills.kalyan.config.AppConfig;

public class TestApp {

	public static void main(String[] args) {
		
		System.out.println("******Starting the container*****");
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
		System.out.println("*****beans created and stored in IOC cache*****");
		String[] beanNames = context.getBeanDefinitionNames();
		
		//converting arrays to stream
		System.out.println("printing the names of the beans");
		Arrays.stream(beanNames).forEach(beanName -> System.out.println(beanName)); //from here we can see that the bean Date is not stored in IOC cache
		System.out.println("************************************************");
		
		//working with bean created by IOC container
		VoterVerifier bean = context.getBean("voter",VoterVerifier.class);
		
		String status = bean.checkVotingEligibility();
		System.out.println(status);
		
		//closing the container
		((AbstractApplicationContext)context).close();
		System.out.println("******closing the container*****");

	}

}
