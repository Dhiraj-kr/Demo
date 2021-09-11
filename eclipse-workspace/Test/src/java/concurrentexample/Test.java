package java.concurrentexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String arg[]) {
		Arrays.asList("a","b","c").stream()
			    .filter(s -> s.equals("b"))
			    .collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-----");
		
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
		            .flatMap(List::stream)
		            .map(integer -> integer + 1)
		            .collect(Collectors.toList());
		
		together.forEach(System.out::println);
		
		System.out.println("-----");
		
		List<Integer> together1 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
	            .flatMap(List::stream)
	            .collect(Collectors.toList());
	
		together1.forEach(System.out::println);
		
		System.out.println("-----");
		
		List<Stream<Integer>> together2 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
	            .map(List::stream)
	            .collect(Collectors.toList());
	
		together2.forEach(System.out::println);
		
		System.out.println("-----");
		
		Square s = x -> x*x;
		//Object o = x -> x*x;
		
		IntStream.range(1, 10).reduce((x, y) -> x + y).ifPresent(s1 -> System.out.println(s1));
		int k=IntStream.range(1, 10).reduce(1,(x, y) -> x + y);
		System.out.println("-----");
		System.out.println(k);
		//Last element not included in range

	}

}
