package hackerRank.DataStructures.stacks;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class MaximumElementStacks {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        int top=-1;
        int item=0;
        List<Integer>a=new ArrayList<>();
        for(String c:operations){
            switch (c) {
                case "1" -> a.add(item, ++top);
                case "2" -> {
                    a.remove(top);
                    top--;
                }
                case "3" -> System.out.println("" + Collections.max(a));
            }
        }
        return a;
    }

}

