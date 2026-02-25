package com.tss.temp.TicTacToe.rules;

import com.tss.temp.TicTacToe.board.Board;
import com.tss.temp.TicTacToe.board.Symbols;
import com.tss.temp.TicTacToe.game.GameState;

public class BasicRules implements Rules {
    @Override
    public boolean isValidMove(Board board, int row, int col) {
        return board.isValidPosition(row,col) && board.getSymbol(row, col) == Symbols.EMPTY;
    }

    @Override
    public GameState checkState(Board board, int row, int col) {

        Symbols symbol = board.getSymbol(row, col);
        int size = board.getSize();


        boolean win = true;
        for (int j = 0; j < size; j++) {
            if (board.getSymbol(row, j) != symbol) {
                win = false;
                break;
            }
        }
        if (win) return GameState.WIN;


        win = true;
        for (int i = 0; i < size; i++) {
            if (board.getSymbol(i, col) != symbol) {
                win = false;
                break;
            }
        }
        if (win) return GameState.WIN;


        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (board.getSymbol(i, i) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return GameState.WIN;
        }


        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (board.getSymbol(i, size - i - 1) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return GameState.WIN;
        }

        if (board.isFull()) {
            return GameState.DRAW;
        }

        return GameState.IN_PROGRESS;
    }
}
