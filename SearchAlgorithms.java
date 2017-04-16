package search;
import java.util.ArrayList;
import java.util.List;

public class SearchAlgorithms {
	
	public static int linearSearch(ArrayList<Integer> inputData, Integer key)
	{
		for(int i = 0; i < inputData.size(); i++)
		{
			if(inputData.get(i).compareTo(key) == 0)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(ArrayList<Integer> inputData, Integer key)
	{
		int startIndex = 0;
		int	midIndex;
		int endIndex = inputData.size() - 1;
		while(startIndex <= endIndex)
		{
			midIndex = (startIndex + endIndex) / 2;
			if(key.compareTo(inputData.get(midIndex)) == 0)
			{
				return midIndex;
			}
			else if(key.compareTo(inputData.get(midIndex)) == 1)
			{
				startIndex = midIndex + 1;
			}
			else if(key.compareTo(inputData.get(midIndex)) == -1)
			{
				endIndex = midIndex - 1;
			}
		}		
		return -1;
	}

	public static int binarySearchRecursive(List<Integer> list, Integer key)
	{
		return binarySearchRecursive(list, key, 0, list.size()-1);
	}
	
	private static int binarySearchRecursive(List<Integer> list, Integer key, int startIndex, int endIndex)
	{
		if(startIndex > endIndex)
		{
			return -1;
		}
		
		int midIndex = (startIndex + endIndex) / 2;
		if(key.compareTo(list.get(midIndex)) > 0)
		{
			return binarySearchRecursive(list, key, midIndex+1, endIndex);
		}
		else if(key.compareTo(list.get(midIndex)) < 0)
		{
			return binarySearchRecursive(list, key, startIndex, midIndex-1);
		}
		else
		{
			return midIndex;
		}
	}

	// We guess the target position using interpolation formula
	public static int interpolationSearch(ArrayList<Integer> inputData, Integer key)
	{
		int startIndex = 0;
		int	midIndex;
		int endIndex = inputData.size() - 1;
		while(startIndex <= endIndex)
		{
			int expression2 = (endIndex - startIndex);
			int expression3 = (key.intValue() - (inputData.get(startIndex).intValue()));
			int expression4 = (inputData.get(endIndex).intValue()) - (inputData.get(startIndex).intValue());
			midIndex = startIndex + expression2 * (expression3 / expression4);
			
			if(key.compareTo(inputData.get(midIndex)) == 0)
			{
				return midIndex;
			}
			else if(key.compareTo(inputData.get(midIndex)) == 1)
			{
				startIndex = midIndex + 1;
			}
			else if(key.compareTo(inputData.get(midIndex)) == -1)
			{
				endIndex = midIndex - 1;
			}
		}
		return -1;
	}
	
	public static int jumpSearch(ArrayList<Integer> inputData, Integer key)
	{
		int blockSize = (int) Math.floor((Math.sqrt(inputData.size())));
		int count = 0, start = 0, end = 0;
		while(end < inputData.size() - 1)
		{
			start = blockSize * count;
			end = start + blockSize - 1;
			if (end > inputData.size() - 1)
			{
				end = inputData.size() - 1;
			}
			
			if(key.compareTo(inputData.get(end)) == 0)
			{
				return (end);
			}
			else if(key.compareTo(inputData.get(end)) < 0)
			{
				for(int i = end - 1; i >= start; i--)
				{
					if(inputData.get(i).intValue() == key.intValue())
					{
						return i;
					}
				}
				return -1;
			}
			else if(key.compareTo(inputData.get(end)) > 0)
			{
				count++;
			}
		}
		return -1;
	}
}