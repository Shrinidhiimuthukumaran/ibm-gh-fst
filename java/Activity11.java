package fst;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {

       
        Map<Integer, String> colours = new HashMap<>();

        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Black");

        System.out.println("Colours: " + colours);

        
        colours.remove(4);

  
        System.out.println("Green exists? " + colours.containsValue("Green"));

        System.out.println("Size of Map: " + colours.size());
    }
}