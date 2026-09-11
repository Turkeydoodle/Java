package Java;

import java.util.Scanner;

public class Calculator {
    public static double divide(double a, double b) {
        return a / b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        System.out.println("Java Calculator");
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("What operation do you want? Type add, subtract, multiply, divide, sqrt, or break");
            String operator = input.nextLine();
            if (operator.equals("break")) {
                break;
            }
            System.out.println("What is the first number?");
            Double number1 = input.nextDouble();
            Double number2 = 0.0;
            String number2string = "";
            if (!operator.equals("sqrt")) {
                System.out.println("What is the second number?");
                number2 = input.nextDouble();
                number2string = String.valueOf(number2);
            }
            String number1string = String.valueOf(number1);
            if (operator.equals("add")) {
                Double sum = number1 + number2;
                System.out.println("The sum of " + number1string + " and " + number2string + " is " + sum);
            }
            if (operator.equals("subtract")) {
                Double difference = number1 - number2;
                System.out.println(
                        "The difference between " + number1string + " and " + number2string + " is " + difference);
            }
            if (operator.equals("multiply")) {
                Double product = multiply(number1, number2);
                System.out.println("The product of " + number1 + " and " + number2 + " is " + product);
            }
            if (operator.equals("divide")) {
                Double quotient = divide(number1, number2);
                System.out.println("The quotient of " + number1 + " and " + number2 + " is " + quotient);
            }
            if (operator.equals("sqrt")) {
                Double answer = sqrt(number1);
                System.out.println("The square root of " + number1 + " is " + answer);
            }
        }
    }
}