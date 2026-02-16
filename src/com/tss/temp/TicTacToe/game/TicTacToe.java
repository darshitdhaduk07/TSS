package com.tss.temp.TicTacToe.game;

import com.tss.temp.TicTacToe.board.Board;
import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.player.Player;
import com.tss.temp.TicTacToe.rules.Rules;
import com.tss.validate.InputValidator;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TicTacToe {

    private Board board;
    private Deque<Player> players;
    private Rules rules;

    private TicTacToe(TicTacToeBuilder ticTacToeBuilder) {
        this.board = ticTacToeBuilder.board;
        this.players = ticTacToeBuilder.players;
        this.rules = ticTacToeBuilder.rules;
    }
    public Board getBoard() {
        return board;
    }

    public Deque<Player> getPlayers() {
        return players;
    }
    public Rules getRules() {
        return rules;
    }
    public static class TicTacToeBuilder {
        private int boardSize;
        Board board;
        Deque<Player> players;
        Rules rules;

        public TicTacToeBuilder(int boardSize) {
            this.boardSize = boardSize;
            this.players = new ArrayDeque<>();
            this.rules = null;
        }

        public TicTacToeBuilder addPlayer(Symbols symbols) {
            String name = InputValidator.readString("Enter Player Name: ");

            Player player = new Player(name,symbols);
            players.add(player);
            return this;
        }
        public TicTacToeBuilder addRules(Rules rules) {
            this.rules = rules;
            return this;
        }
        public void setSymbol(Symbols symbol) {

        }
        public TicTacToeBuilder createBoard() {
            board = new Board(boardSize);
            return this;
        }
        public TicTacToe build() {
            return new TicTacToe(this);
        }

    }

}
