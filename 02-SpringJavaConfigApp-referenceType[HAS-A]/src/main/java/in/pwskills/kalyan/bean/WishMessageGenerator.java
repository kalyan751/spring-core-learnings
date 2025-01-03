package in.pwskills.kalyan.bean;

import java.time.LocalDateTime;

//User defined type
public class WishMessageGenerator {
	
	static {
		System.out.println("WisMessageGenerator.class file is loading");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is created using zero param constructor");
	}
	//HAS-A[Inbuilt type]
	private LocalDateTime ldt;
	
	
	
	public LocalDateTime getLdt() {
		return ldt;
	}


	//setter injection
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}



	public String wishMessage(String user) {
		int hour = ldt.getHour();
		String msg = "";
		if(hour <12 ) {
			msg += "Good Morning, " + user;
		}else if(hour < 16) {
			msg+= "Good Afternoon, " + user;
		}else {
			msg += "Good night, " +user;
		}
		return msg;
	}
	
	
}
