package DataStructureAlgorithm.Arrays;

public class JaggedArray {

	public static void constructJaggedArray() {
		
	/*
	A jagged array is an array of arrays such that member arrays can be of different sizes.
	Syntax: 	data_type array_name[][] = new data_type[n][];  //n: no. of rows
		 	array_name[] = new data_type[n1] //n1= no. of colmuns in row-1
			array_name[] = new data_type[n2] //n2= no. of colmuns in row-2
			array_name[] = new data_type[n3] //n3= no. of colmuns in row-3
			
			int[][] arr_name = {
                          new int[] {10, 20, 30 ,40},
                          new int[] {50, 60, 70, 80, 90, 100},
                          new int[] {110, 120}
                              };
	*/
		
		int[][] myArr = new int[2][];
		
		myArr[0] = new int[3];
		myArr[1] = new int[2];
		
		int count = 0;
		
		for(int i=0; i<myArr.length; i++) {
			for(int j=0; j<myArr[i].length; j++) {
				myArr[i][j] = count++;
			}
		}
		
		for(int i=0; i<myArr.length; i++) {
			for(int j=0; j<myArr[i].length; j++) {
				System.out.print(myArr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Utils.setSeparator("Jagged Array");
		JaggedArray.constructJaggedArray();
	}

}
