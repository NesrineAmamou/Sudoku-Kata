package Utils;

public class SudokuTools {

    public void writeValue(int value) {
        System.out.print(value == 0 ? " " : Integer.toString(value));
    }

    public boolean isMultipleOfThree(int i) {
        return i % 3 == 0;
    }

    public int getColumnIndex(int n) {
        return n % 3 * 3;
    }

    public int getRowIndex(int n) {
        return n / 3;
    }

    public int getCell(String s, int i) {
        return Integer.parseInt(s.substring(i, i + 1));
    }

    public int resetColumnIndex(int col) {
        if (col == 9)
            col = 0;
        return col;
    }

    public int initializeBox(int row) {
        return (row / 3) * 3;
    }

    public void verticalSplit(String characters) {
        System.out.print(characters);
    }

    public void horizontalSplit() {
        System.out.print(" -----------------------\n");
    }

}
