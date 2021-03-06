import java.util.*;
public class Lab1 {
	
	private static int [] array;
	private static int Key;
	private static boolean found = false;
	private static int max = 2001;
	private static int [] BinaryTable = new int[30];
	private static int [] LinearTable = new int[30];
	private static int BinarySum = 0;
	private static int LinearSum = 0;
	
	/**
	 * Receives a random array created by main method to be sorted using Bubble Sort Algorithm
	 * @param a		Random array
	 */
	public static void BubbleSort (int [] a){
		int counter = 0;
		for(int j = 0; j < array.length - 1; j++){
			if(array[j] > array[j+1]){
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
				counter++;
			}
		}
		if(counter != 0){
			BubbleSort(array);
		}
	}
	
	/**
	 * Receive a sorted array and uses Binary Search Algorithm to return the position of key value
	 * @param a				Sorted Array
	 * @param key			value to be searched for in sorted array
	 * @return position		position(index) of key value in sorted array
	 */
	public static int BinarySearch(int [] a, int key){
		int low = 0;
		int high = a.length - 1;
		while(found == false){
			int middle = (high + low) / 2;
			if(a[middle] == key){
				found = true;
				return middle + 1;
			}
			else if(a[middle] < key){
				low = middle + 1;
			}
			else if(a[middle] > key){
				high = middle - 1;
			}
		}
		return 1;
	}
	
	/**
	 * Receive a sorted array and uses Linear Search Algorithm to return the position of key value
	 * @param a				Sorted Array
	 * @param key			value to be searched for in sorted array
	 * @return position		position(index) of key value in sorted array
	 */
	public static int LinearSearch(int []a, int key){
		boolean flag = false;
		int counter = 0;
		int found = 0;;
		while(flag == false){
			if(a[counter] == key){
				found = counter;
				flag = true;
			}
			counter++;
		}
		return found + 1;
	}
	
public static void main(String[]args){
		
		//Ask user for the number of elements
		System.out.println("Enter in the number of elements in your array: ");
		Scanner input = new Scanner(System.in);
		StopWatch watch = new StopWatch();
		int userKey = input.nextInt();
		
		//Create Array
		array = new int[userKey];
		Random r = new Random();
		for(int i = 0; i < userKey; i++){
			array[i] =  r.nextInt(max) -1000;
		}
		
		System.out.println("Generate Random array....");
		
		//Sorting Array
		BubbleSort(array);
		
		//Random Selected Key
		int element = r.nextInt(array.length);
		
		Key = array[element];
		
		//Display Array and Key
		System.out.println("Array: ");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("Key is: " + Key);
		
		
		//Calls Linear Search
		System.out.println("Index of key in Linear Search: ");
		
		System.out.println(LinearSearch(array, Key));
		
		//Calls Binary Search
		System.out.println("Index of key in Binary Search: ");
		
		System.out.println(BinarySearch(array, Key));
		
		
		
		//Repetition of 30 times with array size of 5000
		userKey = 5000;
		
		//Sorting Array
		BubbleSort(array);
		
		for (int q = 0; q < 30; q++){
			array = new int[userKey];
			for(int i = 0; i < userKey; i++){
				array[i] =  r.nextInt(max) - 1000;
			}
			int element1 = r.nextInt(array.length);
			Key = array[element1];
			
			watch.start();
			LinearSearch(array, Key);
			watch.stop();
			LinearTable[q] = (int) watch.getElapsedTime();
			watch.reset();
			
			array = new int[userKey];
			for(int i = 0; i < userKey; i++){
				array[i] =  r.nextInt(max) - 1000;
			}
			watch.start();
			BinarySearch(array, Key);
			watch.stop();
			BinaryTable[q] = (int) watch.getElapsedTime();
			watch.reset();
		}
		
		//Finding the sum of the table
		for(int w = 0; w < 30; w++){
			BinarySum += BinaryTable[w];
			LinearSum += LinearTable[w];
		}
		
		//Display Average
		System.out.println();
		System.out.println("Finding the average run time when array size is 5000.");
		System.out.println("Binary Search average time in nanoseconds is: " + (BinarySum/30));
		System.out.println("Linear Search average time in nanoseconds is: " + (LinearSum/30));
		
		
	}

}
