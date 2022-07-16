package SingletonPattern;

public class EagerInitialisation {
	//private static final EagerInitialisation instance = new EagerInitialisation();
	
	private EagerInitialisation(){
		
	}
	//static initialization
	
	private static EagerInitialisation instance;
	
	static{
		try{
			instance = new EagerInitialisation();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public static EagerInitialisation getInstance () {
		return instance;
	}
}
