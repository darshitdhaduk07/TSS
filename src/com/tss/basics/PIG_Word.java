package com.tss.basics;

import java.util.Random;
import java.util.Scanner;

public class PIG_Word {
    private static int score = 0;
    private static String takeInput()
    {

        Scanner takeInput = new Scanner(System.in);
        String choice ;
        while(true)
        {

            choice = takeInput.next();
            if(choice.equals("r") || choice.equals("h"))
                break;
            else
                System.out.println("You only Enter (r or h):");
        }
        return choice;
    }
    private static int play(int turn)
    {


        while(true)
        {
            System.out.println("--- TURN "+turn+"---");
            System.out.println("Roll or Hold?(r/h)");
            String choice = takeInput();

            if(choice.equals("h"))
                return score;
            Random random = new Random();
            int dice = random.nextInt(6) + 1;


            if(dice == 1)
            {
                return score;
            }
            else{
                score += dice;
                System.out.println("Dice :"+dice);
                System.out.println("Your Score: "+score+"\n");

                if(score >= 20)
                    return score;
            }

        }
    }
    public static void main(String[] args) {
        while (true)
        {
            System.out.println("----- Let's Play PIG! -----");

            int turn = 0;
            System.out.println("Your Score :"+score);
            while (score < 20 && turn <= 4)
            {
                score = play(++turn);
                System.out.println("Your Score:"+score);

            }
            if(score >= 20)
            System.out.println("Winn! You Take only TURN "+turn);
            else
                System.out.println("You Loose!");

            System.out.println("If you play again ?(true / false)");
            Scanner takeInput = new Scanner(System.in);


            while(!takeInput.hasNextBoolean())
            {
                System.out.println("You only Enter (true/false) for play or pause:");
                takeInput.next();
            }
            boolean choice = takeInput.nextBoolean();

            if(choice == false)
                break;
        }
    }
}
