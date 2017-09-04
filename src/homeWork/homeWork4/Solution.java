package homeWork.homeWork4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 11; i++) list.add(i + "");
        System.out.println(list);
        list.add(6, "Q");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(6));
        System.out.println(list.get(list.size() - 1));
        list.add(0, "11");
        System.out.println(list);
        list.add(list.size() - 1, "22");
        System.out.println(list);
        System.out.println("----------------------");
        list.remove(list.size());
        System.out.println("Size: " + list.size());
        System.out.println(list);
/*        for (int i = 0; i < list.size(); i=0) {
            list.remove(0);
            System.out.println(list);
            System.out.println("Size: " + list.size());
        }*/
/*        for (int i = 0; i < list.size(); i=0) {
            list.remove(list.size());
            System.out.println(list);
            System.out.println("Size: " + list.size());
        }*/


        System.out.println("------------------");
        for (String str : list) {
            System.out.print(str + " ");
            //list.add("QWERTY");
            //list.remove(0);
        }


        }
    }
