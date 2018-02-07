import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task5 {

	public static void run() {
    	System.out.println("Task 5");
    	System.out.println("--------------------");

    	getPythagoreanTriplets(100).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); 
	}
	
	public static List<int[]> getPythagoreanTriplets(int upperBound) {
    	// Pythagorean triplets are those where the hypotenuse is a perfect square (no decimal remainder)
    	// Loops through upper triangular portion of number matrix
    	// Uses flatmap to eliminate nested list of lists of arrays
        Stream<int[]> pythagoreanTriples =
               IntStream.rangeClosed(1, upperBound).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, upperBound)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));       

        
        return pythagoreanTriples.collect(Collectors.toList());
	}
	
}
