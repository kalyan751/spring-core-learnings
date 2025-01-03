package in.pwskills.kalyan.bean;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//User defined type
@Component(value = "wmg")
public class WishMessageGenerator {
	
	static {
		System.out.println("WisMessageGenerator.class file is loading");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is created using zero param constructor");
	}
	//HAS-A[Inbuilt type] // will do field level injection
	@Autowired(required = false)
	private LocalDateTime date; // this is a predefined type so if we want its object we cannot use @Compnent in LocalDateTime class. because we have access to only .class file not the .java file
	
	
	
	public LocalDateTime getLdt() {
		return date;
	}


	



	public String wishMessage(String user) {
		int hour = date.getHour();
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


	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}
	
	
}
