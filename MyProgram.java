package Java;

import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        String name = "Kevin";
        Integer age = 123;
        String ageString = String.valueOf(age);
        System.out.println("Hello, this is a string, and my name is " + name);
        System.out.println("The length of your name is " + name.length() + " characters long!");
        System.out.println("The first letter in your name is " + name.charAt(0) + ".");
        System.out.println("My age is " + ageString + " years old!");
        Integer number1 = 6;
        Integer number2 = 8;
        System.out.println(number1 + number2);
        Integer number3 = number1 + number2;
        number3 += 1;
        System.out.println(number3);
        System.out.println(number3 > number1);
        System.out.println(number1 > number2);
        Double newnumber = Math.sqrt(-2);
        System.out.println(newnumber);
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String nameinput = input.nextLine();
        System.out.println("Hello there, " + nameinput + "! It is nice to meet you!");

    }
}