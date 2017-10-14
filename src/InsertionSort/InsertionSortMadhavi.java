package InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InsertionSortMadhavi {
	public static void main(String args[]) {
		// create array
		
		
//		
//		List <Integer> input = Arrays.asList( 7, -5, 2, 16, 4 );
//		
//		List < Integer> insertArray = new ArrayList<>();
		
		//Store the first element into the imaginary array
		//insertArray.add( input.get(0) );
		
//		
//		for( int i = 0; i< input.size(); i++ ) 
//		{
//			for( int j = i; j < input.size(); j++ )
//			{
//				System.out.println( "input.get(j) " + input.get(j));
//				System.out.println( "input.get(i) " + input.get(i));
//				if( input.get(j) < input.get(i) )
//				{
//					insertArray.add( input.get(j) );
//				}
//				else
//				{
//					continue;
//				}
//			}
//			
//		}
		
		String input = "sudhaa";
		boolean unique = true;
		int counter = 0;
		
		for ( int i = 0; i< input.length(); i++ )
		{
			for ( int j = i + 1; j<input.length() ; j++ )
			{
				if ( input.charAt(i) == input.charAt(j) )
				{
					unique = false;
				}
				
			}
		}
		
		
		System.out.println(" input = " + input);
		System.out.println(" output = " + removeD(input) );
		
	}
	
	public static String removeD( String input )
	{
		String s=input;
		Set<Character> set=new LinkedHashSet<Character>();
		for(char c:s.toCharArray())
		{
		    set.add(Character.valueOf(c));
		}
		return set.toString();
	}
	
	public static String removeDuplicates( String input )
	{
		StringBuilder result = new StringBuilder(); 
		result.append(input.charAt(0));
		
		for ( int i = 0; i< input.length(); i++ )
		{
			for ( int j = i+1; j<input.length() ; j++ )
			{
				if ( input.charAt(i) != input.charAt(j) )
				{
					result.append(input.charAt(j));
				}
//				else
//				{
//					result.append(input.charAt(j));
//				}
				
			}
			
		}
		
		return result.toString();
	}
	
}
