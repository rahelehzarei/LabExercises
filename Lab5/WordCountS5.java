package lambdasinaction.chap7;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCountS5 {

	public static Map<String, Integer> result;


	
	public static void wordCount() throws FileNotFoundException
	{
		File file = new File("D:\\Text.txt");
		result = new HashMap<String, Integer>();
		int wordcount = 0;
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String temp = input.next();
			if (temp.toCharArray()[temp.length() - 1] == '.') {
				temp = temp.substring(0, temp.length() - 1);
			}
			result.putIfAbsent(temp, wordcount);
			result.computeIfPresent(temp, (k, v) -> v + 1);
		}
		//result.forEach((a, b) -> System.out.println("<" + a + "," + b + ">"));
		// System.out.println(result);
		input.close();

	}

}
