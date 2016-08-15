package streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lielran on 8/15/16.
 */

/**
 * output:
 *
 * 1 (streams)
 * 2 (parallel Stream)
 *
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Trade> trades = new ArrayList<>();
        trades.add(new Trade(){});
        trades.add(new Trade() {
            @Override
            public int getTotalAmount() {
                return -2000;
            }

            @Override
            public String getStatus() {
                return "Closed";
            }
        });

        trades.add(new Trade() {
            @Override
            public int getTotalAmount() {
                return +2000;
            }

            @Override
            public String getStatus() {
                return "Closed";
            }
        });

        long closedAndPositive = trades.stream()
                .filter(t -> !t.getStatus().equals("Closed"))
                .filter(t -> t.getTotalAmount() >0)
                .count();

        System.out.println(closedAndPositive);

        long positive =  trades.parallelStream()
                .filter(t -> t.getTotalAmount() >0)
                .count();

        System.out.println(positive);

    }

}


interface Trade {

    default public int getTotalAmount(){
        return 20000;
    }

    default public String getStatus(){
        return "Open";
    }
}