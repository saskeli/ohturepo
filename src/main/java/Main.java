import java.util.*;
import ohtu.Multiplier;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Multiplier three = new Multiplier(3);
		System.out.println("Anna luku!");
		System.out.print("> ");
		System.out.println("bla bla bla -> " + three.multipliedBy(scan.nextInt()));
	}
}
