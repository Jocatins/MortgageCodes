package com.sphinxcodes;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static double calculateMortgage(
            int loanAmount, int termInYears, double interestRate){
        //Convert interest rate into a decimal
        interestRate /= 100.0;

        // Monthly interest rate is the yearly interest rate divided by 12
        double monthlyRate = interestRate /= 12.0 ;

        // The length of the term in months is the number of years times 12
        int termInMonths = termInYears * 12;

        //Calculate the monthly payment
        double monthlyPayment = (loanAmount * monthlyRate)/
                (1 - Math.pow(1 + monthlyRate, -termInMonths));
        return monthlyPayment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Prompt user for the details of loan
        System.out.print("Enter the amount of loan : ");
        int loanAmount = scanner.nextInt();

        System.out.print("Enter the amount of loan years : ");
        int termInYears = scanner.nextInt();

        System.out.print("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        double monthlyPayment = calculateMortgage(loanAmount, termInYears, interestRate);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat interest = NumberFormat.getPercentInstance();

        System.out.println("loan Amount: " + currency.format(loanAmount));
        System.out.println("loan term in Years: " + termInYears + "years");
        System.out.println("Interest rate: " + interest.format(interestRate));
        System.out.println("Monthly Payment :" + currency.format(monthlyPayment));
    }
}
