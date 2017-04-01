import java.util.*;
import ohtu.Multiplier;

public class Main {
    static final int THREE = 3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Multiplier threeMultiplier = new Multiplier(THREE);
        System.out.println("Anna luku!");
        System.out.print("> ");
        System.out.println("bla bla bla -> " + threeMultiplier.multipliedBy(scan.nextInt()));
    }
}
