package in.pwskills.kalyan.bean;

import java.io.Serializable;
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
	@Value("${info.emp.eid}")
	private int eid;
	
	@Value("${info.emp.ename}")
	private String ename;
	
	@Value("${info.emp.eage}")
	private float eage;
	
	
	
	static {
		System.out.println("Employee.class file is loading");
	}

	public Employee() {
		System.out.println("Employee obj is created");
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + "]";
	}
	
	
	
	

	
	
}
