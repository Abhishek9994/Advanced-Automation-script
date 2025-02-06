package advanced_selenium_practice;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Java_Streams {

	@Test
	public void regular_expression() {
		
		ArrayList<String> names = new ArrayList<String>();
		
		
		names.add("Abhijeet");
		names.add("John");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;
		
		for(int i=0; i<names.size();i++) {
			
			String Alphabatically = names.get(i);
			if(Alphabatically.startsWith("A")) {
				count++;
			}
			
		}
		System.out.println(count);
	
		
	}
	
	
	
	@Test
	public void using_streams() {
		
ArrayList<String> names = new ArrayList<String>();
		
		
		names.add("Abhijeet");
		names.add("John");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		// Print the number of names who starts with A
	    long D = names.stream().filter(a->a.startsWith("A")).count();
	    System.out.println(D);
		
	    // print the names who contains letter m
	  names.stream().filter(a->a.contains("m")).forEach(a->System.out.println(a));
	  // print the names whose length is more than 4 
	  names.stream().filter(a->a.length()<4).forEach((a->System.out.println(a)));
		
	  
	}
	
	

	
	
}
