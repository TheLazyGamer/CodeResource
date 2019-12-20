import java.util.ArrayList;

import java.util.Arrays;

public class ArraysSample {
	public static void main(String[] argv) {
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("Cupcake");
		stringList.add("Toast");
		stringList.add("Bacon");

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(0);
		intList.add(3456);
		intList.add(-1);

		//Convert Integer arraylist to int array
		int[] intArr = new int[intList.size()];
		for (int i =0; i < intList.size(); i++) { 
			intArr[i] = intList.get(i);
		}

		//Convert String arraylist to String array (doesn't work for int arraylists)
		String[] stringArr = new String[stringList.size()]; 
		stringArr = stringList.toArray(stringArr); 


		double[] myArr = {1.9, 2.9, 3.4, 3.5};

		// Print all the array elements
		for (int i = 0; i < myArr.length; i++) {
			System.out.println(myArr[i] + " ");
		}

		// Summing all elements
		double total = 0;
		for (int i = 0; i < myArr.length; i++) {
			total += myArr[i];
		}
		System.out.println("Total is " + total);

		// Finding the largest element
		double max = myArr[0];
		for (int i = 1; i < myArr.length; i++) {
			if (myArr[i] > max) max = myArr[i];
		}
		System.out.println("Max is " + max);  



		printArray(new int[]{3, 1, 2, 6, 4, 2});
		printArray(intArr);


		int[] source = new int[10];
		int[] dest = new int[10];

		for(int i=0; i < source.length; i++) {
			source[i] = i;
		}

		for(int i=0; i < source.length; i++) {
			dest[i] = source[i];
		}
		
		
		int[] intArray;
		intArray = new int[10];
		
		System.out.println("Printing Array with no values:");
		printArray(intArray);
		
		//Check if two arrays are equal
		boolean ints1EqualsInts2 = Arrays.equals(intArr, intArray);
		System.out.println(ints1EqualsInts2);
		
		
		
		//Copy one array into another #1
		int[] source2 = new int[10];
		int[] dest2   = new int[10];

		for(int i=0; i < source2.length; i++) {
		    source2[i] = i;
		}

		for(int i=0; i < source2.length; i++) {
		    dest2[i] = source2[i];
		}
		
		
		//Copy one array into another #2
		int[] source3 = new int[10];

		for(int i=0; i < source3.length; i++) {
		    source3[i] = i;
		}

		int[] dest3 = Arrays.copyOf(source3, source3.length);
		printArray(dest3);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
