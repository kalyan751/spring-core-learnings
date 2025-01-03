package in.pwskills.kalyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.kalyan.beans.CustomerBO;

@Component(value="dao")
public final class CustomerDaoImpl implements ICustomerDao{
	
	private static final String SQL_INSERT_QUERY = "insert into customer(`cname`,`caddr`,`pamt`,`rate`,`time`,`si`) values(?,?,?,?,?,?)";
	//injecting the datasource // refer the diagram
	/*// Enviroment object is readily available in IOC cache but  DataSource obj is not readily available because framework cant
	 *  decide which database user will use// thats why in configuration class (AppConfig we have to do @Bean and give username,password,url)
	 */
	@Autowired 
	private DataSource dataSource;
	@Override
	public int insert(CustomerBO bo) throws Exception {
		
		System.err.println("DataSource details : " + dataSource);
		
		int count = 0;
		try(Connection connection = dataSource.getConnection()){
			
			//performing insertion 
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			
			//set values to precompiled query
			preparedStatement.setString(1,bo.getCustName());
			preparedStatement.setString(2,bo.getCustAddr());
			preparedStatement.setFloat(3,bo.getPamt());
			preparedStatement.setFloat(4,bo.getRate());
			preparedStatement.setFloat(5,bo.getTime());
			preparedStatement.setFloat(6,bo.getInterestAmount());
			
			count = preparedStatement.executeUpdate();
			
			System.out.println("Count : " + count);
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
