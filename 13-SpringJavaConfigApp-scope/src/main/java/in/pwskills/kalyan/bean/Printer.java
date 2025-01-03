package in.pwskills.kalyan.bean;

public class Printer {
	
	private static Printer INSTANCE = null;
	
	public static Printer getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Printer();
			
		}
		return INSTANCE;
	}
	
	private Printer() {
		
	}
}
