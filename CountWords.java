import java.util.Scanner;

public class CountWords{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для подсчёта");
        String input = scanner.nextLine();

        String[] words = input.split(" ");
        System.out.println(words.length);
    }
}


