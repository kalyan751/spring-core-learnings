package in.pwskills.kalyan.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;


/*
 * // this methods need to be called hence it is a instance method. 
 * so if instance method needs to be called Instance of this class ie, object  must be created by IOC container.
 */
@Component("interestReplacer") 
public class BankCalculateSimpleInterest implements MethodReplacer{
	/*
	 * //here container is telling on what object I should call which particular method so that I should execute this body 
	 * and while executing the body if I need any arguments we will use the object[] args parameter present in the method
	 * and if any exception comes I will throw the exception
	 * 
	 * But when will we call this method. Ans : programmer need not worry container will do that. You just need to use annotation
	 */
	@Override 
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("BankCalculateSimpleInterest.reimplement()");
		
		//pamt , rate , time are the arguments hence we will keep those in the args array
		double pamt = (double)args[0];
		double rate = (double)args[1];
		double time = (double)args[2];
		
		return (pamt * rate * time)/100;
	}

}
