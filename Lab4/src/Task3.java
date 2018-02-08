import java.util.*;import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3{
	
    public static void run(){    
    	
    	System.out.println("Task 3");
    	System.out.println("--------------------");
    	
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               .sorted(Comparator.comparing(Transaction::getValue))
                                               .collect(Collectors.toList());
        System.out.println("Query 1:");
        System.out.println(tr2011);
        
        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("Query 2:");
        System.out.println(cities);

        // Query 3: Find all traders from Cambridge and sort them by name.
        
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(Comparator.comparing(Trader::getName))
                        .collect(Collectors.toList());
        System.out.println("Query 3:");
        System.out.println(traders);
        
        
        // Query 4: Return a string of all traders� names sorted alphabetically.
        
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("Query 4:");
        System.out.println(traderStr);
        
        // Query 5: Are there any trader based in Milan?
        
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println("Query 5:");
        System.out.println(milanBased);
        
        
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println("Query 6:");
        System.out.println(transactions);
        
        
        // Query 7: What's the highest value in all the transactions?
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println("Query 7:");
        System.out.println(highestValue);   
        
        
        List<Trader> tradersList = Arrays.asList(raoul, mario, alan, brian);
        
        // Query 8 - Count number of lowercase letters in name of each trader
        List<Long> numberLowerCaseLettersPerTrader = tradersList.stream()
        		.map(t -> getLowercaseCharsCount(t.getName()))
        		.collect(Collectors.toList());
        
        System.out.println("Query 8:");
        System.out.println(numberLowerCaseLettersPerTrader);
        
        // Query 9 - Find city that has largest number of lowercase characters 
        String city = tradersList.stream().map(t -> t.getCity()).max((city1, city2) -> (int)(getLowercaseCharsCount(city1) - getLowercaseCharsCount(city2))).orElse("No city found");
        System.out.println("Query 9:");
        System.out.println(city);
        
    }
    
    private static long getLowercaseCharsCount(String inputString) {
		return inputString.chars().mapToObj(c -> (char)c).filter(c -> Character.isLowerCase(c)).count();
    }
    
    
    
}