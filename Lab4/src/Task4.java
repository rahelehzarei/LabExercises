import java.util.stream.Stream;

public class Task4 {

	public static void run() {
		
		System.out.println("Task 4");
		System.out.println("--------------------");
		
		// UnaryOperator<T> -> Takes a T as argument and returns a T
		Stream.iterate(new int[]{0, 1}, fibElements -> {
			int temp = fibElements[0];
			fibElements[0] = fibElements[1];
			fibElements[1] = fibElements[1] + temp;
			return fibElements;
		})
	      .limit(20)
	      .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	}
	
}
