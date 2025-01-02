package javaConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPIConcept {

	public static void main(String[] args) {
		// Find names starting with A from a List
		
		String names[] = {"Atanu", "Arnab", "Akash","Shayak","Bat","Aman", "Aheli", "Ranvijay"};
		List<String> namesList = Arrays.asList(names);
		
		Stream<String> x = namesList.stream().filter(i->i.startsWith("A"));
		System.out.println(x.count());
		
		Stream<String> x2 = namesList.stream().filter(i->i.startsWith("A"));
				x2.forEach(i->System.out.println(i));
		System.out.println("----------------------------------------");		
		Stream.of("Atanu", "Arnab", "Akash","Shayak","Bat","Aman", "Aheli", "Ranvijay")
		.filter(a->(a.length())>4).forEach(a->System.out.println(a));
		
		System.out.println("----------------------------------------");		
		Stream.of("Atanu", "Arnab", "Akash","Shayak","Bat","Aman", "Aheli", "Ranvijay").
		map(a->a.concat(" each stream result manupulated" )).forEach(a->System.out.println(a));;
		
		System.out.println("----------------------------------------");		
		Stream.of("Atanu", "Arnab", "Akash","Shayak","Bat","Aman", "Aheli", "Ranvijay").limit(2).forEach(a->System.out.println(a));;
		
		System.out.println("----------------------------------------");		
		Stream.of("Atanu", "arnab", "Akash","Shayak","Bat","Aman", "aheli", "Ranvijay").
		filter(a->a.startsWith("A")).sorted().map(a->a.toUpperCase()).forEach(a->System.out.println(a));;
		
		System.out.println("----------------------------------------");		
		Stream<String> a = Stream.of("Atanu", "arnab", "Akash","Shayak","Bat","Aman", "aheli", "Ranvijay");
		Stream<String> merged = Stream.concat(a, namesList.stream());
		merged.sorted().forEach(i->System.out.println(i));;
		
		System.out.println("----------------------------------------");		
		List<String> li = Stream.of("Atanu", "arnab", "Akash","Shayak","Bat","Aman", "aheli", "Ranvijay").
		filter(i->i.startsWith("A")).collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
		System.out.println("---------Print Unique numbers in sorted order from an Array-------------------------------");		
	    Integer[] nums = {1,3,2,4,2,1,3,9,7,3,2,8,5,986,92,3,4,};
	     List<Integer> numsList = Arrays.asList(nums);
	    numsList.stream().distinct().sorted().forEach(i->System.out.println(i));
	}

}
