package homeWork.homeWork7;


public class PluginImpl implements homeWork.homeWork7.Plugin {
    @Override
    public void doUsefull() {

        System.out.println("Метод из: " + this.getClass().getName());
        System.out.println(this.getClass().getClassLoader());
    }
}