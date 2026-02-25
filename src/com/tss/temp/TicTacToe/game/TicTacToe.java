package com.tss.temp.TicTacToe.game;

import com.tss.temp.TicTacToe.board.Board;
import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.player.Player;
import com.tss.temp.TicTacToe.rules.Rules;
import com.tss.temp.builder.model.User;
import com.tss.validate.InputValidator;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TicTacToe {

    private final Board board;
    private final Deque<Player> players;
    private final Rules rules;

    private GameState gameState = GameState.IN_PROGRESS;
    private Player winner;

    private TicTacToe(Builder ticTacToeBuilder) {
        this.board = ticTacToeBuilder.board;
        this.players = ticTacToeBuilder.players;
        this.rules = ticTacToeBuilder.rules;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return players.peekFirst();
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameState makeMove(int row, int col) {

        Player current = players.peekFirst();

        if (!rules.isValidMove(board, row, col)) {
            throw new IllegalArgumentException("Invalid Move");
        }

        board.placeSymbol(current.getSymbol(), row, col);

        gameState = rules.checkState(board, row, col);

        if (gameState == GameState.WIN) {
            winner = current;
            return gameState;
        }

        if (board.isFull()) {
            gameState = GameState.DRAW;
            return gameState;
        }

        players.offerLast(players.pollFirst());
        return GameState.IN_PROGRESS;
    }

    public static class Builder {
        private int boardSize;
        Board board;
        Deque<Player> players;
        Rules rules;

        public Builder(int boardSize) {
            if (boardSize < 3)
                throw new IllegalArgumentException(
                        "Board size must be at least 3"
                );

            this.boardSize = boardSize;

        }

        public Builder addPlayer(Player player) {
            players.add(player);
            return this;
        }

        public Builder setRules(Rules rules) {
            this.rules = rules;
            return this;
        }

        public Builder createBoard() {
            board = new Board(boardSize);
            return this;
        }

        public TicTacToe build() {
            if (board == null || rules == null || players.size() < 2)
                throw new IllegalStateException("Invalid Game Setup! Please Restart");
            return new TicTacToe(this);
        }

    }

}
