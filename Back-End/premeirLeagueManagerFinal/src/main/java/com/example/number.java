package com.example;

public class number {
    public static void main(String[] args) {
        System.out.println(loopNumber());
    }


    public static  String loopNumber() {
        int add = 0;
        for (int i = 1; i <= 1000; i++)
            add += numberToString(i).length();
        return Integer.toString(add);
    }
    private static String[] ones = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    private static String[] tens = {
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static String[] ties = {
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static String numberToString(int n) {
        if (n < 0 || n > 1000)
            throw new IllegalArgumentException();

        if (n < 100)
            return secondDigit(n);
        else {
            String big = "";
            if (n / 100 % 10 != 0)
                big += ones[n / 100 % 10] + "hundred";
            return big + (n % 100 != 0 ? "and" + secondDigit(n % 100) : "");
        }
    }

    private static String secondDigit(int n) {

        if (n < 10)
            return ones[n];
        else if (n < 20)
            return tens[n - 10];
        else
            return ties[n / 10 - 2] + (n % 10 != 0 ? ones[n % 10] : "");
    }
}
