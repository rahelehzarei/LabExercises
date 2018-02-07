import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

	public static void run() {
		
		System.out.println("Task 2");
		System.out.println("--------------------");
		
		// 2.1 - Print square of numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> square =  numbers.stream().map(num -> num ^ 2).collect(Collectors.toList());
		
		System.out.println("Task 2.1:");
		System.out.println(square.stream().map(n -> n.toString()).collect(Collectors.joining(" ")));
		
		
		// 2.2 - All pairs
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<List<Integer>> pairs = numbers1.stream()
				.flatMap(num1 -> numbers2.stream()
						.map(num2 -> Arrays.asList(num1, num2))).collect(Collectors.toList());
		
		// 2.3 - All pairs where only divisible by 3
		List<List<Integer>> pairsDivBy3 = numbers1.stream()
				.flatMap(num1 -> numbers2.stream()
						.map(num2 -> Arrays.asList(num1, num2)))
				.filter(pair -> pair.stream().reduce(0, Integer::sum) % 3 == 0 )
				.collect(Collectors.toList());
		
	}
	
}

