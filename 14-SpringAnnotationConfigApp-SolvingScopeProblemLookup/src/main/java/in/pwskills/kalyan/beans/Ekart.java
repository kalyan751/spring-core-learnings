package in.pwskills.kalyan.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ekart")
@Scope("prototype")
public class Ekart implements ICourier {
	
	static {
		System.out.println("Ekart.class file is loading");
	}
	public Ekart() {
		System.out.println("Ekart object is getting created");
	}
	@Override
	public String deliver(int oid) {
		return "Delivering " + oid + " order id products using FedEx";
	}

}
