
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("111");
        listStr.add("222");
        listStr.add("333");
        listStr.add("444");
        listStr.add("555");
        MyIterator<String> list = new MyIterator<>(listStr);
/*        for (String str: listStr) {
            System.out.println(str);
        }*/

/*        System.out.println(listStr.get(0));*/
        System.out.println(listStr.size());

       while (list.hasNext()) {
            //System.out.println(listStr.iterator().next());
            //System.out.println(list.next());
           list.remove();
           System.out.println(listStr.size());
        }

        list.remove();

/*       list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();
        System.out.println(list.hasNext());
        System.out.println(list.next());
        list.remove();
        System.out.println(list.next());
        list.remove();
        System.out.println(list.next());
        System.out.println(list.next());*/


    }
}
