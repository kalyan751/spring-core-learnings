package in.pwskills.kalyan.beans;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "voter")
@PropertySource("Application.properties")
public class VoterVerifier {
	
	@Value("${info.voter.name}")
	private String name;
	
	@Value("${info.voter.age}")
	private float age;
	
	//We can set the value of name and age using the @Value but cant do the same with LocalDate
	//one way to do this is in conFig file where we write @Bean and then using autowired use it.
	//Another way is to use the Instantiation methods to set the values // we are using this here
	private LocalDate date;

	static {
		System.out.println("VoterVerifier.class file is loading");
	}

	public VoterVerifier() {
		System.out.println("VoterVerifier :: Object instansiated");
	}
	
	//Initialization method  //this method will be called automatically // I can use this methods to fill the values of the instance variables
	//so that when I call the method using the object the object will be redy with the data of instance variables 
	@PostConstruct // we have added java x annotation dependency in pom.xml
	public void myInit() {
		System.out.println("Initialization :: VoterVerifier.myInit()");
		
		date = LocalDate.now();
		//also check if the age is not a valid name and age no need to pass it to the Business logic method
		if(age< 0 || name == null) {
			throw new IllegalArgumentException("Invalid inputs for name and age are provided");
		}
	}

	// Business Logic method //this method will be called by programmer only when object is created
	//after completing instantialtion and destruction methods coming inside business logic methods
	public String checkVotingEligibility() {
		
		if(age > 18) {
			return "Mr/Mrs/Ms :: " + name + " you are eligible for voting, Dont wait on "+ date;
		}else {
			return "Mr/Mrs/Ms :: " + name + " you are not eligible for voting,Please wait for " + (18 - age) + " years";
		}
		
	}
	
	//Destruction method //this method will be called automatically // I can use this methods to fill the values of the instance variables
	//The destruction method should be used to nullify the instances
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Destruction :: VoterVerifier.myDestroy()");
		date = null;
		age = 0.0f;
		name = null;
		
	}

}
