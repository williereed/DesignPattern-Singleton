package MyBase;

//Lazy instantiation using double locking mechanism.
public class Singleton
{

    public static class instance {
        private static int getInstanceCalled;
        private static int doSomethingCalled;
        private static Singleton instance;

        private instance() {
            System.out.println("...Singleton() Constructor called...");
            getInstanceCalled = 0;
            doSomethingCalled = 0;
        }

        public static Singleton getInstance() {
            if (instance == null) {
                getInstanceCalled++;
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                        System.out.println("...getInstance() Instantiates... " + getInstanceCalled);
                    }
                }
            } else {
                System.out.println("...getInstance() Does nothing... " + getInstanceCalled);
            }

            return instance;
        }

        public static void doSomething() {
            System.out.println("...doSomething() Singleton does work... " + ++doSomethingCalled);
        }
    }
}
