package com.tss.temp.TicTacToe.test;

import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.game.GameState;
import com.tss.temp.TicTacToe.game.TicTacToe;
import com.tss.temp.TicTacToe.player.Player;
import com.tss.temp.TicTacToe.rules.BasicRules;
import com.tss.temp.TicTacToe.rules.Rules;
import com.tss.validate.InputValidator;

import java.util.Deque;
import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {

        TicTacToeFasad fasad = new TicTacToeFasad();
        fasad.play();

    }
}
