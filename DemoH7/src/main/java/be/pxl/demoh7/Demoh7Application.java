package be.pxl.demoh7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class Demoh7Application {

    public static void main(String[] args) {

        StringConverter upperCaseConverter = (original) -> original.toUpperCase();
        StringConverter reverseConverter = (original) -> {
            StringBuilder temporary = new StringBuilder(original);
            return temporary.reverse().toString();
        };
        System.out.println(upperCaseConverter.convert("LuchtHavenPerSOneeL"));
        System.out.println(reverseConverter.convert("LuchtHavenPerSOneeL"));

        Calculator secondPower = (original) -> original * original;
        Calculator thirdPower = (original) -> original * original * original;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****************");

        System.out.println(secondPower.calculate(4)); //16
        System.out.println(thirdPower.calculate(4)); //64

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("****************");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Anna");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWithe = name -> name.endsWith("e");
        Predicate<String> startsWithAAndEndsWithe = startsWithA.and(endsWithe);
        System.out.println(startsWithA.test("Alice"));
        System.out.println(startsWithAAndEndsWithe.test("Alice"));
        printElements(names, startsWithA);
    }

    public static void printElements(List<String> list, Predicate<String> predicate) {
        for (String item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
    }
}
