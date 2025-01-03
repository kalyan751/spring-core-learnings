package in.pwskills.kalyan.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public interface Cricketer { // an inmemory proxy class will be created
	//Each call to cricketer.batting() creates a new instance 
	//of CricketBat because the @Lookup annotation dynamically resolves the dependency:
	@Lookup(value="bat") // Beauty of CGLIB it is responsible for generating in memory proxy classes
	CricketBat createCricketBat();
	
	default void fielding() {
		System.out.println("Cricketer is doing fielding");
	}
	
	default void bowling() {
		System.out.println("Cricketer is doing bowling");
	}
	
	default void wicketKeeping() {
		System.out.println("Cricketer is doing wicketKeeping");
	}
	
	default void batting() {
		System.out.println("Cricketer is doing batting");
		
		CricketBat bat  = createCricketBat();
		
		int runs = bat.scoreRuns();
		System.out.println("Cricketer is doing batting and his score is "+ runs);
	}
	
	
	
}
