import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {
            System.out.println("Task started...");
            Thread.sleep(3000);
            System.out.println("Task finished!");
            return 42;
        };


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(task);

        System.out.println("Before calling get()...");


            Integer result = future.get();
            System.out.println("Result: " + result);



        executor.shutdown();
    }
}
