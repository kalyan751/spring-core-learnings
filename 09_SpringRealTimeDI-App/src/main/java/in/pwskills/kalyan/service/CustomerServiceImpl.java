package in.pwskills.kalyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.kalyan.beans.CustomerBO;
import in.pwskills.kalyan.beans.CustomerDTO;
import in.pwskills.kalyan.dao.ICustomerDao;

@Component("service")
public final class CustomerServiceImpl implements ICustomerService {
	
	//Service Layer needs to communicate with the Dao object (need to perform field injection by using @AutoWired)
	

	@Autowired
	private ICustomerDao dao; 

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {
		
		//calculating the SI for the given DTO object
		float si = (dto.getPamt() * dto.getRate() * dto.getTime())/100;
		
		System.out.println("Calculated Simple Interest in Service Layer :: " + si);
		
		//create a BO form DTO and send the BO to dao
		CustomerBO bo = new CustomerBO();
		
		bo.setCustAddr(dto.getCustAddr());
		bo.setCustName(dto.getCustName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		
		//Injecting the simple - interest amout for
		bo.setInterestAmount(si);
		
		int count = dao.insert(bo);
		System.out.println("Count == " + count );
		
		return count == 1 ? "Customer registered successfully with the interest amount " + si : "Customer registration failed";
	}

}
