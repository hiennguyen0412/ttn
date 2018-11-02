package test3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class V {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String,Integer> tm = new TreeMap<>();
        while (sc.hasNext()) {
            String s = sc.next();         
            int count = tm.containsKey(s) ? tm.get(s) : 0;
            tm.put(s, count + 1);  
        }
        System.out.println(tm.size());
        for (Map.Entry m : tm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        sc.close();
    }
}