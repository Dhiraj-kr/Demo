package stream;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		IntStream stream = "12345_abcdefg".chars();
		stream.forEach(p -> System.out.println(p));
		
		Stream<String> strm = Stream.of("A$B$C".split("\\$"));
		strm.forEach(p -> System.out.println(p));
		
		Map<String, String> names = Map.ofEntries(
                Map.entry("1", "Lokesh"),
                Map.entry("2", "Amit"),
                Map.entry("3", "Brian"));
		System.out.println(names);
	}

}
