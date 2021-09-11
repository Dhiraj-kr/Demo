package java.streamexample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
		
		Stream<Date> dateStream = Stream.generate(() -> { return new Date(); }).limit(10);
		dateStream.forEach(System.out::println);
		
		List<Employee> employees = Stream.generate(Employee::create)
                .limit(5)
                .collect(Collectors.toList());
		
		employees.forEach(System.out::println);
		
		System.out.println("--");
		employees=new ArrayList<>();

		List<Employee> wsListCopy = Optional.ofNullable(employees)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .skip(1)
                .collect(Collectors.toList());
		
		wsListCopy.forEach(System.out::println);

		
		Stream<Employee> resultingStream = employees.stream()
                .filter(distinctByKey(Employee::getName));
	}

		//resultingStream.forEach(System.out::println);
	//T is employee
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
        //putIfAbsent will return null only if key is not present in map already
    }


}
