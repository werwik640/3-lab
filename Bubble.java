public class Bubble {
    public static void main (String[] args){
        // Исходные строки
        String[] sentences = {
                "hello world, welcome to the jungle",
                "the quick brown fox jumps over the lazy dog",
                "the world is a beautiful place",
                "programming in python is fun and challenging"
        };

        // Объединяем все строки в одну
        String line = "";
        for(int i = 0; i < sentences.length; i++){
            line += sentences[i] + " ";
        }
        // Убираем запятые и разбиваем на слова
        line = line.replace(",","");
        String[] words = line.split(" ");

        // Массив для уникальных слов
        String[] uniqueWords = new String[words.length];

        // Счётчик уникальных слов
        int uniqueCount = 0;

        // Цикл который выделяет уникальные слова из массива "words"
        for(String word : words){                 // Пробегаем по словам
            boolean isUnique = true;                  // По умолчанию слово уникально
            for(int i = 0; i < uniqueCount; i++){     // Цикл проверки уникальности
                if(uniqueWords[i].compareTo(word) == 0){
                    isUnique = false;
                }

            }
            // Добавление уникального слова в массив и увеличение счётчика "uniqueCount" на 1
            if (isUnique){
                uniqueWords[uniqueCount] = word;
                uniqueCount++;
            }
        }
        // Создаём массив без пустых элементов
        String[] finalUniqueWords = new String[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalUniqueWords[i] = uniqueWords[i];
        }

        // Вывод уникальных слов
        System.out.println("Уникальные слова:");
        for (String word : finalUniqueWords) {
            System.out.println(word);
        }

        // Сортировка методом "Пузырька"
        for(int i = 0; i < finalUniqueWords.length; i++){
            for (int j = 0; j < finalUniqueWords.length - i - 1; j++){
                if (finalUniqueWords[j + 1].length() < finalUniqueWords[j].length()){
                    String a = finalUniqueWords[j + 1];
                    finalUniqueWords[j + 1] = finalUniqueWords[j];
                    finalUniqueWords[j] = a;
                }
            }
        }

        System.out.println("Отсортированные уникальные слова:");
        for (String word : finalUniqueWords) {
            System.out.println(word);
        }

    }



}


