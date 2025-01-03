package in.pwskills.kalyan.bean;

import org.springframework.stereotype.Component;

@Component
public class Ekart implements ICourier {

	@Override
	public String deliverOrder() {
		
		return null;
	}

	@Override
	public String toString() {
		return "Ekart []";
	}
	
	

}
