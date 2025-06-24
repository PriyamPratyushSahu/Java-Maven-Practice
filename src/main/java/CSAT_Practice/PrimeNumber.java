package CSAT_Practice;

import java.util.Scanner;

public class PrimeNumber {
    String checkPrimeNumber(int n) {
        String output = "";
        int fc = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                fc++;
        }
        if (fc == 2)
//                System.out.println(in + " is a prime number");
            output = n + " is a prime number";
        else
//                System.out.println(in + " is NOT a prime number");
            output = n + " is NOT a prime number";
        return output;
    }

    void primeNumberFrom1to1000() {

        for (int in = 1; in <= 1000; in++) {
            if (!checkPrimeNumber(in).contains("NOT"))
                System.out.println(in);
        }

    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();

        System.out.println("Press 1 to find the number is a prime number or not \nPress 2 to find prime number between 1 to 1000");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice: ");
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.println("Enter a number");
            int n = sc.nextInt();
            System.out.println(pn.checkPrimeNumber(n));
        } else if (ch == 2)
            pn.primeNumberFrom1to1000();
        else
            System.out.println("Wrong choice");
    }
}
