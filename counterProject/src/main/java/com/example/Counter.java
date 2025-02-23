package main.java.com.example;

import java.io.IOException;

public class Counter {
    private final FileManager fileManager;
    private int counter;

    public Counter(FileManager fileManager) throws IOException {
        this.fileManager = fileManager;
        this.counter = fileManager.loadCounter();
    }

    public int getCounter() {
        return counter;
    }

    public int incrementCounter() throws IOException {
        counter++;
        fileManager.saveCounter(counter);
        return counter;
    }

    public void resetCounter() throws IOException {
        counter = 0;
        fileManager.saveCounter(counter);
    }
}

