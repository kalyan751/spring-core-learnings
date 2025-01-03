 package in.pwskills.kalyan.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component(value = "courier")
@Component
public class FedEx implements ICourier {

	@Override
	public String deliverOrder() {
		
		return null;
	}

	@Override
	public String toString() {
		return "FedEx []";
	}
	
	

}
