import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        /*
        // Strings, for the weak
        
        ArrayList<String> funStuff = new ArrayList<>();
        funStuff.add("foo");
        funStuff.add("bar");
        funStuff.add("FOO");
        funStuff.add("BAR");
        funStuff.add("this");
        funStuff.add("that");
        funStuff.add("who");
        funStuff.add("what");
        funStuff.add("where");
        funStuff.add("why");
        
        System.out.println("\n---Printing before sort---");
        for(String aString : funStuff) {
            System.out.println(aString);
        }

        System.out.println("\n---Printing after sort by natural ordering---");
        Collections.sort(funStuff);
        for(String aString : funStuff) {
            System.out.println(aString);
        }

        System.out.println("\n---Printing after sort by my ordering---");
        Collections.sort(funStuff, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.toLowerCase()).compareTo(s2.toLowerCase());
            }
        });
        for(String aString : funStuff) {
            System.out.println(aString);
        }

        System.out.println("\n---How to do lambdas---");
        Collections.sort(funStuff,
                (s1, s2) -> (s1.toLowerCase()).compareTo(s2.toLowerCase()));
        for(String aString : funStuff) {
            System.out.println(aString);
        }
        */

        ArrayList<Food> funStuff = new ArrayList<>();
        funStuff.add(new Food("Pizza", 2, 5));
        funStuff.add(new Food("Pizza", 3, 5));
        funStuff.add(new Food("Pepperoni Pizza", 1, 3));
        funStuff.add(new Food("Cheese Pizza", 1, 5));
        funStuff.add(new Food("Sausage Pizza", 1, 4));
        funStuff.add(new Food("Garden Pizza", 3, 4));
        funStuff.add(new Food("Apple", 3, 4));
        funStuff.add(new Food("Banana", 4, 3));
        funStuff.add(new Food("Snickers", 1, 5));
        funStuff.add(new Food("Broccoli", 5, 2));
        funStuff.add(new Food("Asparagus", 5, 1));
        
        System.out.println("\n---Printing before sort---");
        for(Food foo : funStuff) {
            // since this is a list, this should be ordered by insertion order
            System.out.println(foo);
        }

        System.out.println("\n---Printing after sort by natural ordering---");
        Collections.sort(funStuff);
        for(Food foo : funStuff) {
            // sort by name, then health rate, then taste rate
            System.out.println(foo);
        }

        System.out.println("\n---Printing after sort by my ordering---");
        Collections.sort(funStuff, new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                // sort by health rate (descending), then name
                if(f1.getHealthRate() != f2.getHealthRate()) {
                    return f2.getHealthRate() - f1.getHealthRate();
                }
                if(!f1.getName().equals(f2.getName())) {
                    return f1.getName().compareTo(f2.getName());
                }
                return 0;
            }
        });
        for(Food foo : funStuff) {
            System.out.println(foo);
        }

        System.out.println("\n---Printing after shuffling---");
        // shuffling in case people don't believe me
        Collections.shuffle(funStuff);
        for(Food foo : funStuff) {
            System.out.println(foo);
        }

        System.out.println("\n---Printing after sort using lambdas---");
        // does exact same thing as my ordering, but with lambdas :D
        Collections.sort(funStuff, (f1, f2)
                -> (f1.getHealthRate() != f2.getHealthRate()
                        ? f2.getHealthRate() - f1.getHealthRate()
                        : f1.getName().compareTo(f2.getName())));
        for(Food foo : funStuff) {
            System.out.println(foo);
        }

        System.out.println("\n---Printing after sort by pizza obsession---");
        // a little bit confusing with the ternary conditions
        // don't show them unless they can handle it
        Collections.sort(funStuff, (f1, f2)
                -> (f1.getName().toLowerCase().contains("pizza")
                        && !f2.getName().toLowerCase().contains("pizza")
                    ? -1
                    : (f2.getName().toLowerCase().contains("pizza")
                            && !f1.getName().toLowerCase().contains("pizza")
                        ? 1 : f1.compareTo(f2))
                )
        );
        for(Food foo : funStuff) {
            System.out.println(foo);
        }
        
        System.out.println("\n---Experimenting with filter---");
        // filtering - lots of fun stuff in the API
        List<Food> pizzas = funStuff.stream()
                .filter(f -> f.getName().toLowerCase().contains("pizza"))
                .collect(Collectors.toList());
        for(Food foo : pizzas) {
            System.out.println(foo);
        }
    }
}