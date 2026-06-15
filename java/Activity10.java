package fst;

import java.util.HashSet;
public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<>();

        hs.add("Apple");
        hs.add("Banana");
        hs.add("Orange");
        hs.add("Mango");
        hs.add("Grapes");
        hs.add("Pineapple");

        System.out.println("Size of HashSet: " + hs.size());

        hs.remove("Mango");
        System.out.println("Mango removed.");

        boolean removed = hs.remove("Watermelon");
        System.out.println("Watermelon removed? " + removed);

        System.out.println("Contains Apple? " + hs.contains("Apple"));
        System.out.println("Contains Mango? " + hs.contains("Mango"));

        System.out.println("Updated HashSet: " + hs);

	}

}
