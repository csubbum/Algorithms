package BubbleSort;

import java.util.Arrays;

//A parking garage charges a $2.00 minimum fee to park for up to three hours.
//The garage charges an additional $0.50 per hour for each hour or part thereof in excess of three hours.
//The maximum charge for any given 24 hour period is $10.00.
//Assume that no car parks for longer than 24 hours at a time.
//
//Write a Java program that calculates and displays the parking charges for each customer who parked in the garage yesterday.
//Input the number of hours parked for each customer. The number of customers can be fixed using a final constant.
//
//The program should display the charge for the current customer and should calculate and display the running total of the day's receipts.
//Use a method called calculateCharges to determine the charge for each customer.
public class ParkingTicket {
	public static void main(String args[]) {
		System.out.println(solution("ABAA"));
	}
	
	
	 
	 public static String solution(String S) {
		 
		int begin=0; int end=2;
		
		while(S.length()<2 || end > S.length()) {
			
	
			
			String value = S.substring(begin,end);
			String subValue = substitudeValue(value);
			
			if(value.equalsIgnoreCase(subValue)) {
				end += 1;
				begin += 1;
			} else {
				S = S.substring(0, begin) + subValue + S.substring(end);
			}
			
			
		}
		 return S;
	    }
	 
	 private static String substitudeValue(String value) {
		 switch (value) {
		 	case("AA") : return "A"; 
		 	case("CC") : return "C"; 
		 	case("AB") : return "A"; 
		 	case("BA") : return "A"; 
		 	case("CB") : return "C"; 
		 	case("BC") : return "C"; 
		 	default:  return value;
		 }
	}



	public static int solution(String E, String L) {
		 // write your code in Java SE 8
	        int output = 5;
	        try {
	         int hourDif = Integer.parseInt(L.substring(0, 2)) - Integer.parseInt(E.substring(0, 2));
			 int minDif = Integer.parseInt(L.substring(3)) - Integer.parseInt(E.substring(3));
			 if(minDif > 0)
				 ++hourDif;
			 
			 output = output + (hourDif-1)*4;
			 
	        } catch(Exception e) {
	            // any exception happens return just the entrance fee + 1 hour
	            // throw if needed
	        }
			 return output;
	    }

	public static double calculateCharges (double hours) {
		if(hours==0)
			return 0;

		double amount =  2;
		
		if(hours>3) 
			 amount += ((int) (hours - 3)*.50) ;

		if (hours>=19.5)
			amount = 10;
		
		
		return amount;
	}
}
