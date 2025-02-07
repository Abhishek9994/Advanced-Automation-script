package advanced_selenium_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mongodb.connection.Stream;

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

		for (int i = 0; i < names.size(); i++) {

			String Alphabatically = names.get(i);
			if (Alphabatically.startsWith("A")) {
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
		long D = names.stream().filter(a -> a.startsWith("A")).count();
		System.out.println(D);

		// print the names who contains letter m
		names.stream().filter(a -> a.contains("m")).forEach(a -> System.out.println(a));
		// print the names whose length is more than 4
		names.stream().filter(a -> a.length() > 4).forEach((a -> System.out.println(a)));

	}

	@Test
	public void StreamMap() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhijeet");
		names.add("John");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Rama");

		names.stream().filter(a -> a.endsWith("a")).map(a -> a.toUpperCase()).forEach(a -> System.out.println(a));

		// array to arraylist and the sort

		List<String> names1 = Arrays.asList("Abhijeet", "John", "Don", "Alekhya", "Adam", "Rama");
		names1.stream().filter(a -> a.startsWith("A")).sorted().forEach(a -> System.out.println(a));

		// matching the string with array
		boolean flag = names1.stream().anyMatch(a -> a.equalsIgnoreCase("Don"));
		Assert.assertTrue(flag);
		System.out.println(flag);

	}

	@Test
	public void StreamColletor() {

		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		values.stream().distinct().forEach(a -> System.out.println(a));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));

		// Identify unique number and count
		long UniqueNumber = values.stream().sorted().distinct().count();
		System.out.println(UniqueNumber);
		
		

	}

}
