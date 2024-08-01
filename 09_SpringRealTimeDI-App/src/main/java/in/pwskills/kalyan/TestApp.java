package in.pwskills.kalyan;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.pwskills.kalyan.beans.CustomerVO;
import in.pwskills.kalyan.config.AppConfig;
import in.pwskills.kalyan.controller.CustomerController;

public class TestApp {

	public static void main(String[] args) {
		//creating the object for AnnotationConfigApplicationContext(AppConfig.class)
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // where our configuration file is present ? Ans : AppConfig.class
		
		//taking input for the VO
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the customer name  :: ");
		String name = scanner.next();
		
		System.out.println("Enter the customer address :: ");
		String address = scanner.next();
		
		System.out.println("Enter the principle amount :: ");
		String pamt  = scanner.next();
		
		System.out.println("Enter the rate of interest :: ");
		String rate  = scanner.next();
		
		
		System.out.println("Enter the time period ");
		String time = scanner.next();
		
		
		
		//getting the names of the Beans
		String[] names = context.getBeanDefinitionNames();
		
		//using forEach loop to print the names
		for(String beanName : names ) {
			System.out.println(beanName);
		}
		
		//asking the IOC Container get the object of controller that we created using the @bean
		try {
			
			//creating the CustomerVo Obj and setting the values through the setters
			CustomerVO vo = new CustomerVO();
			
			vo.setCustAddr(address);
			vo.setCustName(name);
			vo.setPamt(pamt);
			vo.setRate(rate);
			vo.setTime(time);
			
			
			CustomerController controller = context.getBean("controller",CustomerController.class);
//			System.out.println("Printing controller object :: " + controller);
			
			//calling the method of the Controller which takes VO object
			String status = controller.processCustomer(vo);
			System.out.println("status :: "+ status);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Some internal problem occured ---> Try Again " + e.getMessage());
		}
		
		//closing the container
		((AbstractApplicationContext)context).close();
		scanner.close();
		

	}

}