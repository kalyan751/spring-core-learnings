package in.pwskills.kalyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.kalyan.beans.CustomerBO;
import in.pwskills.kalyan.beans.CustomerDTO;
import in.pwskills.kalyan.dao.ICustomerDao;

@Component(value="service")
public final class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;
	
	//In service layer you will receive your dto 
	// write up business logic 
	// calculate your logic 
	// create a BO and send Bo to dao
	
	@Override
	public String caculateSimpleInterest(CustomerDTO dto) throws Exception {
		System.err.println("printing dao : " + dao);
		
		//calculate the simpleInterest for the given dto object
		float si = (dto.getPamt()*dto.getRate()*dto.getTime()) / 100;
		
		//creating a BO from DTO
		CustomerBO bo = new CustomerBO();
		bo.setCustAddr(dto.getCustAddr());
		bo.setCustName(dto.getCustName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setInterestAmount(si);
		int count =  dao.insert(bo);
		
		return count > 0 ? "Customer registered successfully with interest amt : " + si : "customer registration failed";
	}

	

}
