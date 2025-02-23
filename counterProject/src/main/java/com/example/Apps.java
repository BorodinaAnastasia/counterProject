package main.java.com.example;

import java.io.IOException;
import java.util.Scanner;

public class Apps {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager("counter.txt");
        Counter counter = new Counter(fileManager);

        System.out.println("Счетчик загружен: " + counter.getCounter());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (inc/reset/stop)");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "inc":
                    int currentValue = counter.incrementCounter();
                    System.out.println("Текущее значение счетчика: " + currentValue);
                    break;
                case "stop":
                    System.out.println("Завершаю работу. Текущее значение счетчика: " + counter.getCounter());
                    return;
                case "reset":
                    counter.resetCounter();
                    System.out.println("Счетчик сброшен.");
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }
}