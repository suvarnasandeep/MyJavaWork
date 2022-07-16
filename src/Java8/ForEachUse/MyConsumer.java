package ForEachUse;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer>{

	public void accept(Integer i){
		System.out.println("concrete class " + i  );
	}
}
