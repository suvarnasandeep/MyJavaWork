package CustomStack;

public class StackMain {

	public static void main(String[] args) {
		StackImplement obj = new StackImplement();
		
		obj.push(1);
		//System.out.print(obj.getSize());
		obj.push(2);
		//System.out.print(obj.getSize());
		obj.push(3);
		//System.out.print(obj.getSize());
		obj.printStack();
		
		obj.pop();
		//System.out.print(obj.getSize());
		obj.pop();
		//System.out.print(obj.getSize());
		
		obj.printStack();
		

	}

}
