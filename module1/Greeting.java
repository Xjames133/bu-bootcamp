import java.util.Scanner;
public class Greeting {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("What do you do for work? ");
        String job = scanner.nextLine();
        System.out.println("Hello, " + name + "! As a " + job + ", you'll enjoy it here.");
        scanner.close();
    }
}