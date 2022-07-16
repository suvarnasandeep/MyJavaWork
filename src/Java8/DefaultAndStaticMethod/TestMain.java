package DefaultAndStaticMethod;

public class TestMain implements Mydata{

	public boolean isNull(String data){
		System.out.println("imp null check");
		return data == null ? true : false;
	}
	public static void main(String[] args) {
		TestMain obj = new TestMain();
		obj.print("");
		obj.isNull("abc");

	}

}
