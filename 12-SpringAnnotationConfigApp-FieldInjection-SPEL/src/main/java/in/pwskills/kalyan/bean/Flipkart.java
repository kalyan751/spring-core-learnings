package in.pwskills.kalyan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Flipkart { // In this case flipkart is the Target object
	//HAS-A 
	
	//Here I am trying to inject DTDC object
	@Value("#{dtdc}")
	private ICourier courier;

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + "]";
	}
	
	
}
