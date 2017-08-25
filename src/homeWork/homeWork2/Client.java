package homeWork.homeWork2;

/**
 * Created by bardakov_vs on 23.08.2017.
 */
public class Client extends Person implements IClient {
    private int cashBag = 1000;

    public Client(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void payMoney(int sum) {
        cashBag--;
    }
}
