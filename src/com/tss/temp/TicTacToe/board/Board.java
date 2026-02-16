package com.tss.temp.TicTacToe.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Symbols>> board;
    private int filledCells = 0;
    private int size;
    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Symbols> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(Symbols.EMPTY);
            }
            board.add(row);
        }
    }
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size &&
                col >= 0 && col < size;
    }
    public int getSize() {
        return size;
    }
    public boolean isCellEmpty(int row, int col) {
        return board.get(row).get(col) == Symbols.EMPTY;
    }
    public void placeSymbol(Symbols symbol, int row, int col) {
        board.get(row).set(col, symbol);
        filledCells++;
    }
    public Symbols getSymbol(int row, int col) {
        return board.get(row).get(col);
    }

    public boolean isFull() {
        return filledCells == size * size;
    }
    public void showBoard() {

        int size = board.size();

        // Column indexes
        System.out.print("    ");
        for (int col = 0; col < size; col++) {
            System.out.print(col + "   ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {

            // Row index
            System.out.print(i + " | ");

            for (int j = 0; j < size; j++) {
                Symbols symbol = board.get(i).get(j);

                if (symbol == Symbols.EMPTY)
                    System.out.print("  ");
                else
                    System.out.print(symbol + " ");

                if (j < size - 1)
                    System.out.print("| ");
            }

            System.out.println();

            // Separator line
            if (i < size - 1) {
                System.out.print("  |");
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1)
                        System.out.print("+");
                }
                System.out.println("|");
            }
        }
    }


}
