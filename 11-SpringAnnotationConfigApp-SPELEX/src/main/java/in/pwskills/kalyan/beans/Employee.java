package in.pwskills.kalyan.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("application.properties")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//primitive variable
	
	//injecting the values from the applciation.properties file
	//@Value("${info.emp.eid}")
	@Value("#{new java.util.Random().nextInt(1000)}") // this will give any random value, binding using SPEL
	private Integer eid;
	
	@Value("${info.emp.ename}")
	private String ename;
	
	@Value("${info.emp.eage}")
	private Float eage;
	
	//@Value("${info.emp.friends}")
	@Value("#{'${info.emp.friends}'.split(',')}")
	private List<String> friends;
	
	@Value("${info.emp.number}")
	private Set<String> phoneNumber;
	
	@Value("#{${info.emp.accountNumber}}")
	private Map<String,String> accountNumber;
	
	@Value("#{T(java.time.LocalDate).of(1993,1,3)}")
	private LocalDate dob;
	
	
	static {
		System.out.println("Employee.class file is loading");
	}

	public Employee() {
		System.out.println("Employee obj is created");
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", friends=" + friends
				+ ", phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + ", dob=" + dob + "]";
	}

	

	
	
	
	
	

	
	
}
