package com.tss.temp.TicTacToe.test;

import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.game.GameState;
import com.tss.temp.TicTacToe.game.TicTacToe;
import com.tss.temp.TicTacToe.player.Player;
import com.tss.temp.TicTacToe.rules.BasicRules;
import com.tss.validate.InputValidator;

import java.util.Scanner;


public class TicTacToeFacade {

    public void play() {


        System.out.print("Board size: ");
        int size = InputValidator.readInt("");

        TicTacToe game = new TicTacToe.Builder(size)
                .addPlayer(new Player("Darshit", Symbols.X))
                .addPlayer(new Player("Rahul", Symbols.O))
                .setRules(new BasicRules())
                .createBoard()
                .build();

        while (game.getGameState() == GameState.IN_PROGRESS) {

            game.getBoard().showBoard();
            System.out.println("Turn: " + game.getCurrentPlayer());

            int r = InputValidator.readInt("");
            int c = InputValidator.readInt("");

            try {
                game.makeMove(r, c);
            } catch (Exception e) {
                System.out.println("Invalid move!");
            }
        }

        game.getBoard().showBoard();

        if (game.getGameState() == GameState.WIN)
            System.out.println("Winner: " + game.getWinner());
        else
            System.out.println("Game Draw!");
    }
}

