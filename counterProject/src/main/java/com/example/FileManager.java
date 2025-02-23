package main.java.com.example;

import java.io.*;


public class FileManager {
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public int loadCounter() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (int) ois.readObject();
        } catch (FileNotFoundException e) {
            return 0;
        } catch (ClassNotFoundException | EOFException e) {
            throw new IOException(e);
        }
    }

    public void saveCounter(int value) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(value);
        }
    }
}
