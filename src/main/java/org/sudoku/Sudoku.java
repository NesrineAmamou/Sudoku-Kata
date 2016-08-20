package org.sudoku;

import Utils.SudokuTools;

public class Sudoku {
    private int[][] board;
    private SudokuTools tools;

    public Sudoku() {
        board = new int[9][9];
        tools = new SudokuTools();
    }

    public int[][] sudokuResolve(String[] inputData) {
        board = fillTheGrid(inputData);
        showGrid(board);

        tools.horizontalSplit();
        if (getSolution(0, 0, board)) {
            showGrid(board);
            tools.horizontalSplit();
            return board;
        } else
            System.out.println(" ----- NO SOLUTION -----");
        return null;
    }


    public void showGrid(int[][] myGrid) {
        for (int row = 0; row < 9; row++) {
            if (tools.isMultipleOfThree(row))
                tools.horizontalSplit();
            for (int column = 0; column < 9; column++) {
                if (tools.isMultipleOfThree(column)) tools.verticalSplit("| ");
                tools.writeValue(myGrid[row][column]);
                tools.verticalSplit(" ");
            }
            tools.verticalSplit("|\n");
        }
    }

    public int[][] fillTheGrid(String[] inputData) {
        int[][] board = new int[9][9];
        int len = inputData.length;

        for (int n = 0; n < len; n++) {
            int row = tools.getRowIndex(n);
            int col = tools.getColumnIndex(n);

            board[row][col] = tools.getCell(inputData[n], 0);
            board[row][col + 1] = tools.getCell(inputData[n], 1);
            board[row][col + 2] = tools.getCell(inputData[n], 2);
        }
        return board;
    }

    public boolean getSolution(int row, int col, int[][] cells) {
        if (col == 9 && ++row == 9)
            return true;

        col = tools.resetColumnIndex(col);

        if (cells[row][col] != 0)
            return getSolution(row, col + 1, cells);

        for (int val = 1; val <= 9; val++) {
            if (checkValueInRowAndColumn(row, col, cells, val, true)
                    && checkValueInSquare(row, col, cells, val, true)) {
                cells[row][col] = val;
                if (getSolution(row, col + 1, cells))
                    return true;
            }
        }
        cells[row][col] = 0;
        return false;
    }

    public boolean checkValueInSquare(int row, int col, int[][] cells, int val, boolean valNotExist) {
        int k = 0;
        int m;
        int boxRowOffset = tools.initializeBox(row);
        int boxColOffset = tools.initializeBox(col);

        while (k < 3 && valNotExist) {
            m = 0;
            while (m < 3 && valNotExist) {
                if (val == cells[boxRowOffset + k][boxColOffset + m])
                    valNotExist = false;
                m++;
            }
            k++;
        }
        return valNotExist;
    }

    public boolean checkValueInRowAndColumn(int row, int col, int[][] cells, int val, boolean valNotExist) {
        int k = 0;
        while (k < 9 && valNotExist) {
            if (val == cells[k][col] || val == cells[row][k])
                valNotExist = false;
            k++;
        }
        return valNotExist;
    }
}