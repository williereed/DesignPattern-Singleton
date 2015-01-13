package MyBase;

public class Main {

    //Lazy instantiation using double locking mechanism.
    public static class Singleton
    {
        private static int getInstanceCalled;
        private static int doSomethingCalled;
        private static Singleton instance;

        private Singleton()
        {
            System.out.println("...Singleton() Constructor called...");
            getInstanceCalled = 0;
            doSomethingCalled = 0;
        }

        public static Singleton getInstance()
        {
            if (instance == null)
            {
                synchronized(Singleton.class)
                {
                    if (instance == null)
                    {
                        instance = new Singleton();
                        System.out.println("...getInstance() Instantiates... " + ++getInstanceCalled);
                    }
                }
            }
            else {
                System.out.println("...getInstance() Does nothing... " + ++getInstanceCalled);
            }

            return instance;
        }

        public void doSomething()
        {
            System.out.println("...doSomething() Singleton does work... " + ++doSomethingCalled);
        }
    }
    public static void main(String[] args) {
        System.out.println("first message coming from main");
        Singleton.getInstance();
        Singleton.instance.doSomething();

        System.out.println("second message coming from main");
        Singleton.getInstance();
        Singleton.instance.doSomething();
    }
}
