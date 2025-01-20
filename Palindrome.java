import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String input = scanner.nextLine();

        String[] inputArray = input.split("");
        String reversedInput = "";

        for (int i = inputArray.length - 1; i >= 0; i--){
            reversedInput += inputArray[i];
        }

        if (input.compareTo(reversedInput) == 0){
            System.out.println("Палиндром!");
        } else {
            System.out.println("Не палиндром...");
        }

    }
}
