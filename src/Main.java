import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название файла для сохранения словаря:");
        String fileName = scanner.next();


        System.out.println("Тип словаря( 1 или 2)");
        DictionaryManager dictionaryManager = null;
        switch (scanner.nextInt()){
            case 1:
                dictionaryManager = new DictionaryManagerForFistLg( fileName);
                break;
            case 2:
                dictionaryManager = new DictionaryManagerForSecondLg(fileName);
                break;
            default:
                System.out.println("Такого словаря нет. Выберите повторно");
                break;
        }
        if (dictionaryManager != null) {
            while (true) {
                System.out.println(
                        "1) Просмотр содержимого словаря\n" +
                                "2) Просмотр элемента по ключу\n" +
                                "3) Добавление элемента\n" +
                                "4) Удаление элемента\n"
                );
                switch (scanner.nextInt()) {
                    case 1: {
                        System.out.println("1) Содержимое:");
                        System.out.println(dictionaryManager.getAllWords());
                        break;
                    }
                    case 2: {
                        System.out.println("2) Элемент:");
                        try{
                            System.out.println(dictionaryManager.findWord(scanner.next()));
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("3) Введите слово:");
                        String key = scanner.next();
                        System.out.println("Введите перевод:");
                        String value = scanner.next();
                        try{
                            dictionaryManager.addWord(key, value);
                            System.out.println("Успешно!")  ;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("4) Введите слово:");
                        try{
                            dictionaryManager.deleteWord(scanner.next());
                            System.out.println("Успешно!");
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                    default:{
                        System.out.println("Неверная команда.");
                    }
                }
                System.out.println();
            }
        }
    }
}