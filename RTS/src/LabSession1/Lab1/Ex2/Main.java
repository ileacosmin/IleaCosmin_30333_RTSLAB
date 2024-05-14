package LabSession1.Lab1.Ex2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the matrix1: ");
        int[][] matrix1 = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = in.nextInt();
            }
        System.out.println("Enter the matrix2: ");
        int[][] matrix2 = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = in.nextInt();
            }

        int operation;

        System.out.println("Please select a operation: 1.addition 2.product 0.exit");
        System.out.println("Option: ");
        operation = in.nextInt();
        while (operation != 0) {
            switch (operation) {
                case 1:
                    // adition
                    calculator c = new calculator(matrix1, matrix2);
                    c.add();

                    break;
                case 2:
                    // product
                    calculator d = new calculator(matrix1, matrix2);
                    d.product();


                    break;
            }
            System.out.println("Option: ");
            operation = in.nextInt();
        }
    }

}
