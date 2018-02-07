import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
	
    public static void run(){
    	System.out.println("Task 1");
    	System.out.println("--------------------");
    	
    	// 1.1 Migrating collections to streams
    	migrateCollectionsToStreams();

    	// 1.2 Limitation of streams 
    	StreamVsCollection.run();
    	
    	// 1.4 Filter out first 2 meat dishes
    	List<Dish> firstTwoMeatDishes = Dish.menu.stream()
    			.filter(d -> d.getType() == Dish.Type.MEAT)
    			.limit(2).collect(Collectors.toList());
    	
    	firstTwoMeatDishes.forEach(System.out::println);
    	
    }

    public static void migrateCollectionsToStreams() {
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }
    
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
	
}
