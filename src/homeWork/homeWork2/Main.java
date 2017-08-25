package homeWork.homeWork2;



public class Main {

    public static void main(String[] args) {
        Person client1 = new Person("Ivan", "Ivanovich", "Ivanov");
        client1.getFullName();
        client1.setId(1000000000000000001L);
        client1.setAge(33);
        client1.setResident(true);
        System.out.println(client1.getFullName());
        //System.out.println(client1.getId());
        client1.Print();
//123123
    }
}
