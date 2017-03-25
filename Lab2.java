import java.util.*;
public class Lab2 {
	private static int [] array;
	private static int Key;
	private static int max = 5001;
	private static boolean found = false;
	private static double LinearPerInstr, BinaryPerInstr;
	private static double LinearPredict, BinaryPredict;
	private static double Linear, Binary;
	
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
	
	public static int BinarySearch(int [] a, int key){
		int low = 0;
		int high = a.length - 1;
		while(found == false){
			int middle = (high + low) / 2;
			if(a[middle] == key){
				found = true;
				return middle;
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
		return found;
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
					array[i] =  r.nextInt(max) -5000;
				}
				
				//Sorting Array
				BubbleSort(array);
				
				array[array.length - 1] = 7000;
				
				Key = 7000;
				
				//Linear Search
				System.out.println("Linear Search: ");
				watch.start();
				System.out.println(LinearSearch(array, Key));
				watch.stop();
				Linear = (double) watch.getElapsedTime();
				System.out.println("Linear Search's worst case time in seconds is: " + Linear);
				watch.reset();
				
				//Binary Search
				System.out.println("Binary Search: ");
				watch.start();
				System.out.println(BinarySearch(array, Key));
				watch.stop();
				Binary = (double) watch.getElapsedTime();
				System.out.println("Binary Search's worst case time in seconds is: " + Binary);
				watch.reset();
				
				LinearPerInstr = Linear/5000;
				BinaryPerInstr = Binary/(Math.log(5000)/Math.log(2));
				
				System.out.println();
				System.out.println("The run time for each instruction in a Linear Search in nanoseconds is: " + LinearPerInstr);
				System.out.println("The run time for each instruction in a Binary Search in nanoseconds is: " + BinaryPerInstr);
				
				LinearPredict = 10000000 * LinearPerInstr;
				BinaryPredict = (Math.log(10000000)/Math.log(2)) * BinaryPerInstr;
				
				System.out.println();
				System.out.println("My prediction time in nanoseconds when input size is 10000000 in a Linear Search is: " +  LinearPredict);
				System.out.println("My prediction time in nanoseconds when input size is 10000000 in a Binary Search is: " +  BinaryPredict);

	}
	
}
