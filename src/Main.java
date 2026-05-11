import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static String mainFile = "numbers.txt";
    static String primesFile = "primes.txt";

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Створити файл");
            System.out.println("2. Додати числа");
            System.out.println("3. Переглянути numbers.txt");
            System.out.println("4. Редагувати файл");
            System.out.println("5. Створити файл з простими числами");
            System.out.println("6. Переглянути primes.txt");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createFile();
                    break;
                case 2:
                    addNumbers();
                    break;
                case 3:
                    viewFile(mainFile);
                    break;
                case 4:
                    editFile();
                    break;
                case 5:
                    createPrimesFile();
                    break;
                case 6:
                    viewFile(primesFile);
                    break;
                case 0:
                    System.out.println("Програма завершена");
                    break;
                default:
                    System.out.println("Невірний вибір");
            }
        } while (choice != 0);
    }
    // Створення файлу
    static void createFile() {
        try {
            FileWriter fw = new FileWriter(mainFile);
            System.out.print("Скільки чисел записати? ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("Введіть число: ");
                int num = sc.nextInt();
                fw.write(num + "\n");
            }
            fw.close();
            System.out.println("Файл створено!");
        } catch (Exception e) {
            System.out.println("Помилка");
        }
    }
    // Додавання чисел
    static void addNumbers() {
        try {
            FileWriter fw = new FileWriter(mainFile, true);
            System.out.print("Скільки чисел додати? ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("Введіть число: ");
                int num = sc.nextInt();
                fw.write(num + "\n");
            }
            fw.close();
            System.out.println("Числа додано!");
        } catch (Exception e) {
            System.out.println("Помилка");
        }
    }
    // Перегляд файлу
    static void viewFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            System.out.println("\n--- Вміст файлу ---");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Файл не знайдено");
        }
    }
    // Редагування файлу
    static void editFile() {
        System.out.println("Редагування файлу");
        createFile();
    }
    // Створення файлу з простими числами
    static void createPrimesFile() {
        try {
            File file = new File(mainFile);
            Scanner reader = new Scanner(file);
            FileWriter fw = new FileWriter(primesFile);
            while (reader.hasNextLine()) {
                int num = Integer.parseInt(reader.nextLine());
                if (isPrime(num)) {
                    fw.write(num + "\n");
                }
            }
            reader.close();
            fw.close();
            System.out.println("Файл primes.txt створено!");
        } catch (Exception e) {
            System.out.println("Помилка");
        }
    }
    // Перевірка простого числа
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}