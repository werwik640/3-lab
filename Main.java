import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        System.out.println("Введите шаг: ");
        int step = scanner.nextInt();

        System.out.println("1 - зашифровать, 2 - расшифровать");
        int encrypt = scanner.nextInt();
        if (encrypt == 2){
            step = -step;
        }

        char[] engLower = new char[26]; // Английские нижнего регистра
        char[] engUpper = new char[26]; // Английские верхнего регистра
        for (char i = 'a'; i <= 'z'; i++ ){ // Наполняем engLower
            engLower[i - 'a'] = i;
        }
        for (char i = 'A'; i <= 'Z'; i++){ // Наполняем engUpper
            engUpper[i -'A'] = i;
        }
        char[] rusUpper = new char[33]; // Создаём массив под русские буквы верхнего регистра
        int buffer = 0;
        // Наполняем массив rusUpper русскими буквами с учётом "Ё"
        for (char i = 'А'; i <= 'Я'; i++ ){
            rusUpper[i - 'А' + buffer] = i;
            if (i == 'Ж'){
                rusUpper[i - 'А'] = 'Ё';
                rusUpper[i - 'А' + 1] = 'Ж';
                buffer++;
            }
        }
        char[] rusLower = new char[33]; // Создаём массив под русские буквы нижнего регистра
        buffer = 0;
        // Наполняем массив rusLower русскими буквами с учётом "ё"
        for (char i = 'а'; i <= 'я'; i++){
            rusLower[i - 'а' + buffer] = i;
            if (i == 'ж'){
                rusLower[i - 'а'] = 'ё';
                rusLower[i - 'а' + 1] = 'ж';
                buffer++;
            }
        }

        String result = ""; // Строка для конечного результата
        for (char symbol : input.toCharArray()){
            // Проверяем есть ли символ в rusLower
            if (getCharIndex(symbol, rusLower) != -1){
                result += rusLower[(getCharIndex(symbol, rusLower) + step)%33];
            }
            // Проверяем есть ли символ в rusUpper
            else if (getCharIndex(symbol, rusUpper) != -1){
                result += rusUpper[(getCharIndex(symbol, rusUpper) + step)%33];
            }
            // Проверяем есть ли символ в engLower
            else if (getCharIndex(symbol, engLower) != -1){
                result += engLower[(getCharIndex(symbol, engLower) + step)%26];
            }
            // Проверяем есть ли символ в engUpper
            else if (getCharIndex(symbol, engUpper) != -1){
                result += engUpper[(getCharIndex(symbol, engUpper) + step)%26];
            }
            else {
                // Если нет, то это не буква, оставляем нетронутым символ
                result += symbol;
            }
        }
        // Выводим результат
        System.out.println(result);
    }
    // Находим индекс элемента в массиве
    static int getCharIndex(char symbol, char[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == symbol) return i;
        }
        // Если не находим, то возвращаем -1
        return -1;
    }
}