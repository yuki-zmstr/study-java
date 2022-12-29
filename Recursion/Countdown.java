import java.util.*;

class CountDown {
    public static void count_down(int n) {
        if (n <= 0) // don’t use ==, why?
            System.out.println("BLAST OFF!!!!");
        else {
            System.out.println("Count down at time " + n);
            count_down(n - 1);
        }
    }

    public static void main(String[] args) {
        count_down(10);
    }
}