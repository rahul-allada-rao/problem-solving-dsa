package java8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class AppleMain {

  public static void main(String[] args) {
    Apple redApple = new Apple("Red", 180);
    Apple redLightApple = new Apple("Red", 170);
    Apple greenApple = new Apple("Green", 120);
    Apple woodApple = new Apple("Brown", 180);

    List<Apple> inventory = Arrays.asList(redApple, greenApple, woodApple, redLightApple);

    // filter heavy apples
    System.out.println("Filter only those apples which weigh more than 150");
    List<Apple> heavyApples = filter(inventory, (Apple apple) -> apple.weight()>150);
    heavyApples.forEach(apple -> System.out.println(apple.color() + "\t" + apple.weight()));

    // filter red apples only
    System.out.println("Filter only Red colored apples");
    List<Apple> redApples = filter(inventory, (Apple apple) -> "Red".equals(apple.color()));
    redApples.forEach(apple -> System.out.println(apple.color() + "\t" + apple.weight()));



    inventory.sort((Apple a1, Apple a2) -> a1.weight().compareTo(a2.weight())); // explicit variable types
    inventory.sort((a1, a2) -> a1.weight().compareTo(a2.weight())); // using lambda type inference
    inventory.sort(Comparator.comparing(Apple::weight)); // using method reference

    // composing lamdas and chaining them to filter apples
    // 1. by weight
    // 2. in decreasing order
    // 3. and if two apples have same weight then compare them by color
    inventory.sort(Comparator.comparing(Apple::weight).reversed().thenComparing(Apple::color));


    // Demonstrating negate() , and(), or() operations on existing predicates
    Predicate<Apple> heavyApplePredicate = a -> a.weight() > 150;
    Predicate<Apple> redApplePredicate = a -> "Red".equals(a.color());
    Predicate<Apple> greenApplePredicate = a -> "Green".equals(a.color());

    // light apples (weight < 150) by re-using existing heavyApplePredicate
    Predicate<Apple> lightApplePredicate = heavyApplePredicate.negate();

    // red and heavy apple predicate by re-using heavyApplePredicate and redApplePredicate
    Predicate<Apple> redHeavyApplesPredicate = redApplePredicate.and(heavyApplePredicate);

    // redHeavyApples or simply Green apples
    Predicate<Apple> redHeavyOrGreenApplePredicate = redApplePredicate.and(heavyApplePredicate).or(greenApplePredicate);



  }

  private static <T> List<T> filter(List<T> list, Predicate<T> p){
    List<T> result = new ArrayList<>();
    for (T element : list){
        if (p.test(element)){
          result.add(element);
        }
    }
    return result;
  }
}
