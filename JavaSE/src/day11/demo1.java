package day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class demo1 {
    public static void main(String[] args) {
        int x = -5;
        int y = -12;
        System.out.println(y % x);

        int i = 5;
        int j = 10;
        String s =  "7";
        System.out.println(s+i+j);
        System.out.println(i+s+j);
        System.out.println(i+j+s);
        System.out.println(i+~j);
        List list=new ArrayList();
        list.add("a");
        list.add("b");
        list.add("a");
        Set set=new HashSet();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(list.size()+","+set.size());
    }
}
