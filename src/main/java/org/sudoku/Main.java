package org.sudoku;

public class Main {
    public static void main(String[] args) {
        Sudoku playInstance=new Sudoku();
        String[] tab={"006", "200", "340", "000", "086" ,"092", "000", "070",
                "001", "100", "008", "070", "008", "020", "100", "090", "100", "008",
                "700", "030", "000", "510", "840", "000", "069","000","000"};
        playInstance.sudokuResolve(tab);
    }
}
