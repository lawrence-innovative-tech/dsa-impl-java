package com.data.structure.example.recursion;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class EasyQuestion {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = sc.nextInt();
        int numbers = printNto1WithOutLoop(number);
        System.out.println("The number is : " + numbers);
        System.out.print("Enter a string : ");
        String string = sc.next();
        System.out.println("Palindrome : " + printPalindrome(string));
    }

    private static int printNto1WithOutLoop(int number){

        if (number == 0){
            return 0;
        }
        return number + printNto1WithOutLoop(number - 1);
//        return numbers;
    }

    private static boolean printPalindrome(String number){

        if (number.length() <= 1 ){
            return true;
        }

        if (number.charAt(0) == number.charAt(number.length()-1)){
                return printPalindrome(number.substring(1, number.length()-1));
        }else {
            return false;
        }
    }

//    Recursively remove all adjacent duplicates
//    private static String adjacentDuplicates(String string){
//
//        if (string.length() == 1){
//            return string;
//        }
//
//
//    }
}
