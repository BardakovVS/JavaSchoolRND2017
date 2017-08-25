package homeWork.homeWork2;

public class Person extends ClientImpl{
    public static final boolean RESIDENT = true;
    public static final boolean NOT_RESIDENT = false;

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private boolean isResident;

    /*public Person() {
    }*/

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        if (middleName != null) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    @Override
    public void Print() {
        System.out.println("ID = " + id);
        System.out.println("firstName = " + firstName);
        System.out.println("middleName = " + middleName);
        System.out.println("lastName = " + lastName);
        System.out.println("age = " + age);
        System.out.println("isResident = " + isResident);
        //return ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        if (resident) {
            this.isResident = RESIDENT;
        } else {
            this.isResident = NOT_RESIDENT;
        }
    }

    //public int person_type PERSON_TYPE

}
