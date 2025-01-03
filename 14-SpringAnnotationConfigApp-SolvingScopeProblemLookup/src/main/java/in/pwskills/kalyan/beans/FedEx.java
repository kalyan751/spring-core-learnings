package in.pwskills.kalyan.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fexEx")
@Scope("prototype")
public class FedEx implements ICourier {
	
	static {
		System.out.println("FedEx.class file is loading");
	}
	
	public FedEx() {
		System.out.println("FedEx object is getting created");
	}
	
	@Override
	public String deliver(int oid) {
		// TODO Auto-generated method stub
		return "Delivering " + oid + " order id products using FedEx";
	}

}
