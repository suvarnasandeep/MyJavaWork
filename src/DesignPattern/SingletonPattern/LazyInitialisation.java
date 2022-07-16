package SingletonPattern;

public class LazyInitialisation {
	private static LazyInitialisation instance;

	private LazyInitialisation() {

	}
	
	/*public static LazyInitialisation getInsatnce() {
		if(instance == null){
			instance = new LazyInitialisation();
		}
		return instance;
	}	*/

	//thread safe
	/*synchronized public static LazyInitialisation getInstance(){
		if(instance == null){
			instance = new LazyInitialisation();
		}
		return  instance;
	}*/

	//double thread safe
	public static LazyInitialisation getInstance(){
		if(instance == null){
			synchronized (LazyInitialisation.class){
				if(instance==null){
					instance = new LazyInitialisation();
				}
			}
		}
		return instance;
	}
}
