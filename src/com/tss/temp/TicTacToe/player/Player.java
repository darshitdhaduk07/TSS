package com.tss.temp.TicTacToe.player;

import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.game.GameState;

import java.security.PublicKey;

public class Player {
    private String name;
    private int id;
    private static int counter = 0;
    private Symbols symbol;
    private int score;

    public Player(String name, Symbols symbol) {
        this.name = name;
        this.id = counter++;
        this.symbol = symbol;
    }



    public String getName() {
        return name;
    }


    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void increaseScore() {
        score++;
    }
    private void getDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Symbol: " + symbol);
        System.out.println("Score: " + score);
    }
    public String toString()
    {
        return "Name: " + name + ", ID: " + id + ", Symbol: " + symbol;
    }
}
