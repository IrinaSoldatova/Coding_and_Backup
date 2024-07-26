package tasks.encAndDec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncAndDec {
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 3, 2, 1, 0, 1, 2, 3};
        encodedToFile("file1.txt", array);
        decodedFromFile("file1.txt");
    }

    public static void encodedToFile(String path, int[] arr) {
        if (arr.length % 3 != 0) {
            System.out.println("Array length must be a multiple of 3.");
            return;
        }
        try (FileOutputStream file = new FileOutputStream(path)) {
            for (int i = 0; i < arr.length - 2; i += 3) {
                int num = (arr[i] << 6) | (arr[i + 1] << 4) | (arr[i + 2] << 2);
                file.write(num);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void decodedFromFile(String path) {
        try (FileInputStream file = new FileInputStream(path)) {
            int data;
            while ((data = file.read()) != -1) {
                int num1 = (data >> 6) & 0b11;
                int num2 = (data >> 4) & 0b11;
                int num3 = (data >> 2) & 0b11;
                System.out.print(num1 + " " + num2 + " " + num3 + " ");
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file: " + e.getMessage());
        }
    }
}