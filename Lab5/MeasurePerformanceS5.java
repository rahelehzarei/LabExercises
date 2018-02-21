package lambdasinaction.chap7;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class MeasurePerformanceS5 {

	public static void main(String[] args) throws IOException {
		
		long start=System.nanoTime();
		WordCountS5.wordCount();
		long duration=(System.nanoTime()-start) / 1_000_000;
		System.out.println("the performance is of second solution for word count is :"+duration +"msce");
		
		 start=System.nanoTime();
		WordCountS5P2.wordCount();
		 duration=(System.nanoTime()-start) / 1_000_000;
		System.out.println("the performance is of second solution for word count is :"+duration +"msce");
		
	}
	

    }
