package java_example.streamexample;

import java.util.function.Function;

public class StreamExample {
	
	public static void main(String arg[]) {
		Function3<Long, Long, Long, Long> sum = (a, b, c) -> a + b + c;
		long result = sum.apply(1L, 2L, 3L); // 6
		System.out.println("Result: "+result);

		Function<Long, Function<Long, Function<Long, Long>>> curriedSum = sum.curry();
		result = curriedSum.apply(1L).apply(2L).apply(3L); // 6
		System.out.println("Result: "+result);

		Function<Long, Function<Long, Long>> incr = sum.bindFirst(1L);
		result = incr.apply(7L).apply(3L); // 11
		System.out.println("Result: "+result);
		result = incr.apply(6L).apply(7L); // 14
		System.out.println("Result: "+result);

	}

}

@FunctionalInterface
interface Function3<A, B, C, D> {

    D apply(A a, B b, C c);

    default Function<A, Function<B, Function<C, D>>> curry() {
        return a -> b -> c -> this.apply(a, b, c);
    }

    default Function<B, Function<C, D>> bindFirst(A a) {
        return b -> c -> this.apply(a, b, c);
    }
}
