package in.pwskills.kalyan.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Flipkart {
	
	
	@Autowired
	@Qualifier("dtdc")
	private ICourier courier;
	
	static {
		System.out.println("Flipkart.class file is loading...");
	}
	
	public Flipkart() {
		System.out.println("Flipkart object is getting created...");
	}
	
	
	public ICourier getCourier() {
		courier = getCourierObj();
		return courier;
	}

	
	
	//creating getters and setters
	@Lookup(value="dtdc") // at runtime container will give body
	public ICourier getCourierObj() {
		return null;
	}
	
	

	
	@Override
	public String toString() {
		return "Flipkart "+this.hashCode()+"[courier=" + courier.hashCode() + "]";
	}	
}
