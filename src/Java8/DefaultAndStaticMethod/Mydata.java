package DefaultAndStaticMethod;

public interface Mydata {

	default void print(String data){
		if(isNull(data)){
			System.out.println("data is null");
		} else {
			System.out.println(data);
		}
	}
	
	static boolean isNull(String data){
		System.out.println("interface null check");
		
		return data == null ?true:"".equals(data)? true:false;
	}
}
