package in.pwskills.kalyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.kalyan.beans.CustomerDTO;
import in.pwskills.kalyan.beans.CustomerVo;
import in.pwskills.kalyan.service.ICustomerService;

@Component(value="controller")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	public String processCustomer(CustomerVo vo) throws Exception {
		
		System.err.println("Printing service : " + service);
		
		//writing logic to convert the vo to dto
		CustomerDTO dto = new CustomerDTO();
		dto.setCustName(vo.getCustName());
		dto.setCustAddr(vo.getCustAddr());
		
		//converting String data to float data
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		return service.caculateSimpleInterest(dto);
		
	}
}
