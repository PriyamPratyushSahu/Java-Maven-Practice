package CSAT_Practice;

import java.util.Scanner;

public class NumberOfFactors {
    void findNumberOfFactors(int n) {
        System.out.print("Factors of " + n + " : " + n);
        for (int i = n - 1; i >= 1; i--) {
            if (n % i == 0)
                System.out.print(", " + i);
        }
        System.out.println();
    }

    void factorsFrom100To1() {

        for (int in = 100; in >= 1; in--) {
            System.out.print("Factors of " + in + " : " + in);
            for (int i = in - 1; i >= 1; i--) {
                if (in % i == 0)
                    System.out.print(", " + i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NumberOfFactors nf = new NumberOfFactors();

        System.out.println("Press 1 to find factor of a number\nPress 2 to find factor of 100 to 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice: ");
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.println("Enter a number");
            int n = sc.nextInt();
            nf.findNumberOfFactors(n);
        } else if (ch == 2) {
            nf.factorsFrom100To1();
        } else
            System.out.println("Wrong choice");
    }
}
