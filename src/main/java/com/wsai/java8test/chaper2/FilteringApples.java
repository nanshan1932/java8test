package com.wsai.java8test.chaper2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangsai
 * @data 2019/2/18
 */
public class FilteringApples {
    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
        inventory.stream().anyMatch(apple -> apple.getWeight() >100);
        inventory.sort((apple1,apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }



    public interface ApplePredicate{
        boolean test(Apple apple);
    }

    static class AppleWeightPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
    }
    static class AppleColorPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "green".equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
