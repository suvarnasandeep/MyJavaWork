package LamdaExceptionHandling;

import java.util.function.BiConsumer;

public class LambdaExceptionExample {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4};
		int key = 0;

		process(arr, key, wrapperLamda((v , k)-> System.out.println(v / k)));

	}

	public static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {

		for(int i : arr){
			consumer.accept(i, key);
		}
	}

	public static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> consumer) {

		return (v , k)->{
			try{
				consumer.accept(v, k);
			} catch(ArithmeticException e){
				System.out.println("exception occurred inside wrapper lamda");
			}
		};
	}

}
