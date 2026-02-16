package com.tss.temp.TicTacToe.test;

import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.game.GameState;
import com.tss.temp.TicTacToe.game.TicTacToe;
import com.tss.temp.TicTacToe.player.Player;
import com.tss.temp.TicTacToe.rules.BasicRules;
import com.tss.temp.TicTacToe.rules.Rules;
import com.tss.validate.InputValidator;

public class TicTacToeFasad {

    public void play()
    {
        Rules rules = new BasicRules();

        int boardsize = InputValidator.readInt("Enter Board Size: ");
        TicTacToe ticTacToe = new TicTacToe.TicTacToeBuilder(boardsize)
                .addPlayer(Symbols.O)
                .addPlayer(Symbols.X)
                .addRules(rules)
                .createBoard()
                .build();
        ticTacToe.getBoard().showBoard();

        while (ticTacToe.getBoard().getFilledCells() != boardsize*boardsize)
        {
            Player player = ticTacToe.getPlayers().pollFirst();
            System.out.println("\nFor Player: "+player.getName()+"\n");
            int row = InputValidator.readInt("Enter Row Position: ");
            int col = InputValidator.readInt("Enter Column Position: ");

            while(!ticTacToe.getRules().isValidMove(ticTacToe.getBoard(), row, col))
            {
                System.out.println("\nInvalid Move! ReEnter\n");
                row = InputValidator.readInt("Enter Row Position: ");
                col = InputValidator.readInt("Enter Column Position: ");
            }
            ticTacToe.getBoard().setSymbols(player.getSymbol(),row,col);
            ticTacToe.getPlayers().offerLast(player);

            GameState gameState = ticTacToe.getRules().checkState(ticTacToe.getBoard(), row, col);

            if(gameState == GameState.WIN)
            {
                player.setGameState(GameState.WIN);
                for(Player p : ticTacToe.getPlayers())
                {
                    if(p != player)
                    {
                        p.setGameState(GameState.LOOSE);
                    }
                }
                System.out.println("You win!");
                System.out.println(player);
                break;
            }
            if(gameState == GameState.DRAW)
            {
                System.out.println("Draw!");
                break;
            }
            ticTacToe.getBoard().showBoard();

        }
        System.out.println("Thanks for playing!");
    }
}
