package fst;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("cat");
        myList.add("dog");
        myList.add("elephant");
        myList.add(3, "bunny");
        myList.add(1, "lion");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element: " + myList.get(2));
        System.out.println("Is dog is in list: " + myList.contains("dog"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("dog");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}