package in.pwskills.kalyan.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component(value = "bat")
public class CricketBat {
	
	static {
		System.out.println("CricketBat.class file is loading");
	}
	public CricketBat() {
		System.out.println("Cricket bat object is created");
	}
	
	//Business logic
	public int scoreRuns() {
		System.out.println("CricketBat.scoreRuns()");
		
		return new Random().nextInt(200);
	}
}
