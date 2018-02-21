package lambdasinaction.chap7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;
//import static java.util.stream.Collectors.toMap;

public class WordCountS5P2 {

	static Stream<String>  fileStream;
	/*
	public static void main(String... args) throws IOException {
		
		/*
		 * System.out.println(fileStream.parallel().map(line->line.split(" "))
		 * .flatMap(Arrays::stream).collect(toMap(s->s, s->1,Integer::sum)));
		 */
		/*
		 * second solution by using reduce function. it is not complete yet. I will
		 * compelete in later fileStream.parallel().map(line->line.split(" "))
		 * .flatMap(Arrays::stream).map(m->m).map(m->1) .reduce(new
		 * HashMap<String,Integer>() ,-> {l.put(m, Integer::sum);return l; }
		 * ,(HashMap<String,Integer> l1, HashMap<String,Integer> l2) ->
		 * {l1.putAll(l2);return l1; } ); //(m,s)->new HashMap<>(m,Integer::sum));
		 */
		//System.out.println(wordCount());}

	


	public static Map<String,Integer> wordCount() throws IOException
	{
		fileStream = Files.lines(Paths.get("D:\\Text.txt"));
		Map<String,Integer> result=fileStream.parallel().map(line->line.split(" "))
			.flatMap(Arrays::stream).collect(toMap(s->s, s->1,Integer::sum));
		return result;
		
	}

}
