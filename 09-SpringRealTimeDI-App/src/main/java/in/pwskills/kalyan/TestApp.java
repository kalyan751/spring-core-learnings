package in.pwskills.kalyan;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.CustomerBO;
import in.pwskills.kalyan.beans.CustomerVo;
import in.pwskills.kalyan.config.AppConfig;
import in.pwskills.kalyan.controller.CustomerController;

public class TestApp {

	public static void main(String[] args) {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		System.out.println();
		
//		//getting  the bean names
//		String[] beanNames = context.getBeanDefinitionNames();
//		
//		for(String beanName : beanNames) {
//			System.out.println(beanName);
//		}
		
		
		//1. take the controller object from the IOC cache
		CustomerController controller = context.getBean("controller",CustomerController.class);
		
		Scanner scanner = new Scanner(System.in);
		//I need programmer to give details of Vo object
		System.out.println("Enter the customer name");
		String name = scanner.next();
		
		System.out.println("Enter the customer Address");
		String address = scanner.next();
		
		
		System.out.println("Enter the principle amount");
		String pamt = scanner.next();
		
		System.out.println("Enter the rate");
		String rate = scanner.next();
		
		System.out.println("Enter the time");
		String time = scanner.next();
		
		
		
		//2/ Using the controller process the customer and Give VO object
		try {
			CustomerVo vo = new CustomerVo();
			vo.setCustName(name);
			vo.setCustAddr(address);
			vo.setPamt(pamt);
			vo.setRate(rate);
			vo.setTime(time);
			
			
			String status = controller.processCustomer(vo);
			System.out.println("after giving vo params, status : " + status);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some internal error occured---> Try again" + e.getMessage());
		}
		
		
		//closing the container
		((AbstractApplicationContext)context).close();
		scanner.close();

	}

}
