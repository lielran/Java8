package lambda;

/**
 * Created by lielran on 8/15/16.
 */

/**
 * output:
 * Main(thread:Main)
 * Send email(thread:Thread-0)
 * I'm anonymous(thread:Thread-0)
 * Send email(thread:Thread-1)
 * Send email(thread:Thread-2)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main(thread:"+Thread.currentThread().getName()+")");

        //Anonymous class
        testRunnable(new Runnable() {
            @Override
            public void run() {
                sendEmail();
                //maybe do other things
                System.out.println("I'm anonymous(thread:"+Thread.currentThread().getName()+")");
            }
        });

        //Lambda
        testRunnable(() -> sendEmail());


        //Method reference
        testRunnable(Main::sendEmail);

    }

    static void sendEmail(){
        System.out.println("Send email(thread:"+Thread.currentThread().getName()+")");
        //Do something
    }

    private static void testRunnable(Runnable runnable){
        new Thread(runnable).start();
    }


}
