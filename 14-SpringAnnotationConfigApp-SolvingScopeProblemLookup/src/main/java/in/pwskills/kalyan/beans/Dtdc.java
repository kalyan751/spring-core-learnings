package in.pwskills.kalyan.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Scope("prototype")
public class Dtdc implements ICourier {
	
	static {
		System.out.println("Dtdc.class file is loading");
	}
	
	public Dtdc() {
		System.out.println("Dtdc.class object is getting created");
	}
	
	@Override
	public String deliver(int oid) {
		return "Delivering " + oid + " order id products using Dtdc";
	}

	
	
	

}
