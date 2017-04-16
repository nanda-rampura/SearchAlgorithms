package search;
import java.util.ArrayList;
import java.util.Collections;

public class TestSearch
{
	private static int length = 10;
	private static int randomNumberRange = 10*length;
	private static int key;
	private static int notFoundKey = 10*length + 11;
	private static int keyIndex = (int) ((0.75)*(length));
	private static ArrayList<Integer> searchData = new ArrayList<Integer>();
	
	private static void generateRandomData()
	{
		for(int i = 0; i < length; i++)
		{
			searchData.add((int) (Math.random() * randomNumberRange));
		}
		key = searchData.get(keyIndex);		
	}
	
	private static void printData()
	{
		for(int elem: searchData)
		{
			System.out.print(elem + " ");
		}
		System.out.println("");
	}
	
	private static void printResult(int searchKey, int indexLocation)
	{
		if(indexLocation != -1)
		{
			System.out.println("key " + searchKey + " is found at index " + indexLocation);
		}
		else
		{
			System.out.println("key " + searchKey + " is not found");
			System.out.println("");
		}
	}
	
	public static void main(String[] args)
	{
		generateRandomData();
		printData();
		System.out.println("Search for " + key + " and " + notFoundKey + "\n");
		
		//Linear Search
		System.out.println("Linear Search");
		printResult(key, SearchAlgorithms.linearSearch(searchData, key));
		printResult(notFoundKey, SearchAlgorithms.linearSearch(searchData, notFoundKey));
		
		System.out.println("Sorting data..");
		Collections.sort(searchData);
		printData();
		System.out.println();
		
		//Binary Search Iterative
		System.out.println("Binary Search (Iterative)");
		printResult(key, SearchAlgorithms.binarySearch(searchData, key));
		printResult(notFoundKey, SearchAlgorithms.binarySearch(searchData, notFoundKey));
				
		//Binary Search Recursive
		System.out.println("Binary Search (Recursive)");
		printResult(key, SearchAlgorithms.binarySearchRecursive(searchData, key));
		printResult(notFoundKey, SearchAlgorithms.binarySearchRecursive(searchData, notFoundKey));

		//Interpolation Search
		System.out.println("Interpolation Search");
		printResult(key, SearchAlgorithms.interpolationSearch(searchData, key));
		printResult(notFoundKey, SearchAlgorithms.interpolationSearch(searchData, notFoundKey));

		//Jump Search
		System.out.println("Jump Search");
		printResult(key, SearchAlgorithms.jumpSearch(searchData, key));
		printResult(notFoundKey, SearchAlgorithms.jumpSearch(searchData, notFoundKey));
	}
}