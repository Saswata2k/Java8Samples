public class DemoRun {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Java 8 !");
        runThreads();
    }

    private static void runThreads() throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside run 1");
        runnable.run();
        for (int i = 0; i < 5; i++)
            synchronized (DemoRun.class) {
                Thread.sleep(330);
                System.out.println("Value of i is" + i);
            }
    }
}
