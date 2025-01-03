package in.pwskills.kalyan.bean;

import org.springframework.stereotype.Component;

@Component(value = "dtdc")
public class DTDC implements ICourier {

	@Override
	public String deliverOrder() {
		
		return null;
	}

	@Override
	public String toString() {
		return "DTDC []";
	}

}
