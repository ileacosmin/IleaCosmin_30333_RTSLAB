package LabSession1.Lab1.Ex3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] intArray =new int[10];

        for (int i = 0; i < 10; i++) {
            intArray[i] = rand.nextInt(25);
        }

        Arrays.sort(intArray);

        for (int i = 0; i < 10; i++) {
            System.out.print(intArray[i]+ " ");
        }
    }
}
