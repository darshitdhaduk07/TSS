package com.tss.temp.TicTacToe.rules;

import com.tss.temp.TicTacToe.board.Board;
import com.tss.temp.TicTacToe.game.GameState;

public interface Rules {
    boolean isValidMove(Board board, int row, int col);
    GameState checkState(Board board, int lastMoveRow, int lastMoveCol);
}
