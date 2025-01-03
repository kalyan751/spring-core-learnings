package in.pwskills.kalyan.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Flipkart {
	@Autowired
	@Qualifier("fedEx")
	private ICourier courier;
	
	static {
		System.out.println("Flipkart.class file is loading...");
	}
	
	public Flipkart() {
		System.out.println("Flipkart object is getting created...");
	}
	
	public String Shopping(String[] items, float[] prices) {
		System.out.println("Flipkart.shopping() ");
		System.out.println("Calculate the total amount to be billed");
		
		float billedAmount = 0.0f;
		for(float cost : prices) {
			billedAmount+=cost;
		}
		// using the random id for creating the order id
		String msg = courier.deliver(new Random().nextInt(1000));
		
		return Arrays.toString(items) + " with prices "+ Arrays.toString(prices) + " having billed amount :: " + billedAmount +"For Order id : " +msg ;
		
	}
}
