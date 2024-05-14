package LabSession1.Lab1.Ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int Re1, Re2, Im1, Im2, operation, Re = 0, Im = 0;

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println("Please select a operation: 1.addition 2.subtraction 3.multiplication 0.exit");
        System.out.println("Option: ");
        operation = in.nextInt();
        while (operation!=0) {


            System.out.println("Re1");
            Re1 = in.nextInt();
            System.out.println("Im1");
            Im1 = in.nextInt();
            System.out.println("Re2");
            Re2 = in.nextInt();
            System.out.println("Im2");
            Im2 = in.nextInt();
            switch (operation) {
                case 1:
                    // adition
                    Re = Re1 + Re2;
                    Im = Im1 + Im2;

                    break;
                case 2:
                    Re = Re1 - Re2;
                    Im = Im1 - Im2;

                    break;
                case 3:
                    Re = Re1 * Re2 - Im1 * Im2;
                    Im = Re1 * Im2 + Re2 * Im1;

                    break;
            }
            System.out.println(Re + "+" + Im + "i");
            System.out.println("press any key to continue");
            operation=in.nextInt();

            System.out.println("Please select a operation: 1.addition 2.subtraction 3.multiplication 0.exit");
            System.out.println("Option: ");
            operation = in.nextInt();
        }
        

    }
}
