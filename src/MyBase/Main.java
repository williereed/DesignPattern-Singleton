package MyBase;

public class Main {

    public static void main(String[] args) {
        System.out.println("first message coming from main");
        Singleton.instance.getInstance();
        Singleton.instance.doSomething();

        System.out.println("second message coming from main");
        Singleton.instance.getInstance();
        Singleton.instance.doSomething();
    }
}
