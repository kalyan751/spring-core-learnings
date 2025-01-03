package in.pwskills.kalyan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Flipkart { // In this case flipkart is the Target object
	//HAS-A 
	@Autowired(required = false)
	@Qualifier("fedEx")
	private ICourier courier;

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + "]";
	}
	
	
}
