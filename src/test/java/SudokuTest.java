import org.sudoku.Sudoku;
import org.junit.Assert;
import org.junit.Test;


public class SudokuTest {

    private Sudoku playInstance=new Sudoku();

    @Test
    public void should_fill_the_grid_with_input_data(){
        String[] tab={"006", "290", "340", "000", "086" ,"092", "000", "070",
                "001", "100", "008", "070", "008", "020", "100", "090", "100", "008",
                "700", "030", "000", "510", "840", "000", "064","000","000"};

        int[][] result={{0, 0, 6, 2, 9, 0, 3, 4, 0},{0, 0, 0, 0, 8, 6 ,0, 9, 2},
            {0,0,0,0,7,0,0,0,1},{1,0,0, 0,0,8, 0,7,0},{0,0,8, 0,2,0, 1,0,0},
            {0,9,0, 1,0,0, 0,0,8},{7,0,0, 0,3,0, 0,0,0},{5,1,0, 8,4,0, 0,0,0},
            {0,6,4,0,0,0,0,0,0}};

        Assert.assertEquals(result,playInstance.fillTheGrid(tab));
    }

    @Test
    public void should_return_a_correct_Sudoku_Solution(){
        String[] tab={"123", "000", "000", "000", "789" ,"123", "789" ,
            "000", "456" ,"912", "345" ,"000", "000" ,"912", "000" ,"000", "000" ,
            "000", "000" ,"000", "000" ,"567", "891" ,"234", "234" ,"567", "891" };

        int[][] result={{1, 2, 3, 4, 5, 6, 7, 8, 9},{4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},{9, 1, 2, 3, 4, 5, 6, 7, 8},{6, 7, 8, 9, 1, 2, 3, 4, 5},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},{8, 9, 1, 2, 3, 4, 5, 6, 7},{5, 6, 7, 8, 9, 1, 2, 3, 4},
            {2, 3, 4, 5, 6, 7, 8, 9, 1}};

        Assert.assertEquals(result,playInstance.sudokuResolve(tab));
    }


    @Test
    public void should_return_null_when_no_solution_found(){
        String[] tab={"123", "589", "423", "103", "789" ,"123", "789" ,
                "000", "456" ,"912", "345" ,"453", "147" ,"912", "421" ,"178", "324" ,
                "000", "000" ,"000", "000" ,"567", "891" ,"234", "234" ,"567", "891" };

        Assert.assertEquals(null,playInstance.sudokuResolve(tab));
    }


    @Test
    public void should_return_false_when_value_exist_in_square(){
        int[][] cells={{0, 2, 3, 4, 5, 6, 7, 8, 9},{1, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},{9, 1, 2, 3, 4, 5, 6, 7, 8},{6, 7, 8, 9, 1, 2, 3, 4, 5},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},{8, 9, 1, 2, 3, 4, 5, 6, 7},{5, 6, 7, 8, 9, 1, 2, 3, 4},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}};
        Assert.assertEquals(false,playInstance.checkValueInSquare(0,0,cells,1, true));
    }

    @Test
    public void should_return_true_when_value_does_not_exist_in_square(){
        int[][] cells={{0, 2, 3, 4, 5, 6, 7, 8, 9},{4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},{9, 1, 2, 3, 4, 5, 6, 7, 8},{6, 7, 8, 9, 1, 2, 3, 4, 5},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},{8, 9, 1, 2, 3, 4, 5, 6, 7},{5, 6, 7, 8, 9, 1, 2, 3, 4},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}};
        Assert.assertEquals(true,playInstance.checkValueInSquare(0,0,cells,1, true));
    }

    @Test
    public void should_return_false_when_value_exist_in_row_or_column(){
        int[][] cells={{0, 2, 3, 4, 5, 6, 7, 8, 9},{1, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},{9, 1, 2, 3, 4, 5, 6, 7, 8},{6, 7, 8, 9, 1, 2, 3, 4, 5},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},{8, 9, 1, 2, 3, 4, 5, 6, 7},{5, 6, 7, 8, 9, 1, 2, 3, 4},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}};
        Assert.assertEquals(false,playInstance.checkValueInRowAndColumn(0,0,cells,1, true));
    }

    @Test
    public void should_return_true_when_value_does_not_exist_in_row_or_column(){
        int[][] cells={{0, 2, 3, 4, 5, 6, 7, 8, 9},{4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},{9, 1, 2, 3, 4, 5, 6, 7, 8},{6, 7, 8, 9, 1, 2, 3, 4, 5},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},{8, 9, 1, 2, 3, 4, 5, 6, 7},{5, 6, 7, 8, 9, 1, 2, 3, 4},
                {2, 3, 4, 5, 6, 7, 8, 9, 1}};
        Assert.assertEquals(true,playInstance.checkValueInRowAndColumn(0,0,cells,1, true));
    }
}
