package Arrays;

public class ArraysMain {

	public static void main(String[] args) {

		//jaggeredArray();
		//rotatedArrayRotate();
		//searchInRotatedArray();
		//nonRepeatingElement();
		maxSUbArraySum();

		//getEqualStack();

		//getMissingNumber();
		
		//getNumberOfPairs();
		//getMultipleAndFactors();
		//getTwoSum();
		//getDuplicatesInArray();
		//getNumOfMaxVal();
		//getEqualDistribution();
		//getMinLoss();
	}

	private static void getMinLoss() {
		int[] input = {16,15,8,2,11};
		printInputArray(input);
		MinimumLoss o = new MinimumLoss();
		System.out.println("Min Loss BF : "+ o.getMinLossBF(input));
		System.out.println("Min Loss : "+ o.getMinLoss(input));
	}

	private static void getEqualDistribution() {
		int[] input = {11,6,8,7};
		printInputArray(input);
		EqualDistribute obj = new EqualDistribute();
		System.out.println("Equal Distribution : "+ obj.getEqualDistribution(input));
	}

	private static void getNumOfMaxVal() {
		int[] input = {3,4,1,5,1,5,4};
		printInputArray(input);

		NumberOfMaxValue m = new NumberOfMaxValue();
		System.out.println("Number of max val : " + m.getNumberOfMAxValue(input));
	}

	private static void getDuplicatesInArray() {
		int[] input = {4,3,2,8,2,3,1,7};
		//int[] input = {2,7,11,15};
		int target = 19;

		printInputArray(input);
		DuplicatesInArray obj = new DuplicatesInArray();
		System.out.println("Duplicate vale : "+ obj.getDuplicates(input));
		System.out.println("Duplicate vale : "+ obj.getDuplicates1(input));
	}

	private static void getTwoSum() {
		int[] input = {16,8,23,4,15};
		//int[] input = {2,7,11,15};
		int target = 19;

		printInputArray(input);
		TwoSum obj = new TwoSum();
		System.out.println(obj.getTwoSum(input, target));
		System.out.println(obj.getTwoSumHash(input, target));
	}

	private static void getMultipleAndFactors() {

		int[] a = {2,6};
		int[] b = {24,36};

		FindMultipleAndFactors obj = new FindMultipleAndFactors();
		printInputArray(a,b);
		System.out.println("Brute Force : "+obj.getMultipleAndFactorsBF(a,b));

		System.out.println("Efficient Sol :" +obj.getMultipleAndFactors(a,b));
	}

	private static void getNumberOfPairs() {

		int[] arr = {1,5,3,4,2};
		NumberOfPairs n = new NumberOfPairs();
		int target = 1;
		System.out.println("Number of pairs : " + n.getNumberOfPairs(arr, target));
		System.out.println("Number of pairs : " + n.getNumberOfPairsBF(arr, target));
	}

	private static void getMissingNumber() {
		int[] arr1 = {7,2,5,4,6,3,5,3};
		int[] arr2 = {7,2,5,3,5,3};

		MissingNumber obj = new MissingNumber();
		System.out.println("Missing number : "+obj.getMissingNumbers(arr1,arr2));

		int[] arr11 = {7,2,5,4,6,3,5,3,1,1};
		int[] arr21 = {7,2,5,3,5,3,1};
		System.out.println("Missing number : "+obj.getMissingNumbers(arr11,arr21));

	}

	private static void getEqualStack() {

		int[] arr1 = {3,2,1,1,2};
		int[] arr2 = {4,3, 3};
		int[] arr3 = {1,1,4,2};

		EqualStack s = new EqualStack();
		System.out.println("Equal stack : " + s.getEqualStack(arr1,arr2,arr3));
	}

	private static void maxSUbArraySum() {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		//int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		//int arr[] = {5,4,-1,7,8};
		MaxSubArraySum obj = new MaxSubArraySum();
		System.out.println(obj.getMaxSubArraySum(arr));
	}

	private static void nonRepeatingElement() {

		int [] input = {1,2,4,2,7,4,1,9};
		NonRepeatingElement obj = new NonRepeatingElement();

		System.out.println(obj.getNonRepeatingElement(input));
		//System.out.println(obj.getNonRepeatingElement1(input));
	}

	private static void searchInRotatedArray() {
		setSeparator("Search an element in a sorted and rotated array");
		RotatedArraySearch rArr = new RotatedArraySearch();
		int[]arr = {3,4,5,6,1,2};
		int length = arr.length;
		rArr.pivotedBinarySearch(arr, length, 5);
		System.out.println("Modified Binary serach : " + rArr.modifiedBinarySearch(arr,5,0, arr.length-1));
	}

	private static void rotatedArrayRotate() {
		setSeparator("Array Rotation by N");
		int[]arr = {1,2,3,4,5,6};
		RotatedArray arrObj = new RotatedArray();
		//method 1
		//arrObj.rotateMethod1(arr,arr.length, 2);
		//arrObj.rotateByN(arr, arr.length, 2);
		System.out.println("------------------------");

		//method 2
		arrObj.rotateByN_One(arr, arr.length, 2);

	}

	private static void jaggeredArray() {
		setSeparator("Jagged Array");
		JaggedArray jArr = new JaggedArray();
		jArr.constructJaggedArray();

	}

	public static void setSeparator(String msg) {
		System.out.println("************" + msg +"*****************");
	}

	private static void printInputArray(int[] arr1, int[] arr2) {
		System.out.print("[ ");
		for(int i : arr1)
			System.out.print(i + " ");

		System.out.println("]");
		System.out.print("[ ");
		for(int i : arr2)
			System.out.print(i + " ");

		System.out.println("]");

		System.out.println("------------------------");
	}

	private static void printInputArray(int[] arr) {
		System.out.print("[ ");
		for(int i : arr)
			System.out.print(i + " ");

		System.out.println("]");
		System.out.println("------------------------");
	}

}
