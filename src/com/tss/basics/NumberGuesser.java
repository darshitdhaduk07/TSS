package com.tss.basics;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
//        max attempt 5

        while(true)
        {
            int random = (int)(Math.random() * 100 );

            int attempts = 0;
            Scanner inputTaker = new Scanner(System.in);
            while(true)
            {
                attempts++;

                if(attempts>5)
                {
                    System.out.println("You Loose ! remaining attempts: 0");
                    break;
                }
                int leftAttempts = 5-attempts;
                System.out.println("Enter a number :");
                int number = inputTaker.nextInt();

                if(number <= 0 || number >= 100)
                {
                    System.out.println("Please Enter a number between 1 to 100: \n");
                }

                if(number == random)
                {
                    System.out.println("You Won ! You take "+ attempts+"attempts");
                }
                else if(number > random)
                {
                    System.out.println("number is bigger "+ leftAttempts+" Attempts Left");
                }
                else
                {
                    System.out.println("number is smaller "+ leftAttempts+" Attempts Left");
                }

            }

            boolean playagain = true;
            System.out.println("If you want to play again Enter True otherwise Enter False:");
            playagain = inputTaker.nextBoolean();

            if(playagain == false)
                break;

        }
    }
}
