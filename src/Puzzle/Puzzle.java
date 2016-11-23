package Puzzle;

import java.util.List;

/**
 * Created by Ty on 11/15/2016 at 4:39 PM.
 * A Puzzle.Puzzle is composed of Cells. It only knows how many cells exist and constrains what symbols may be used.
 * The 2D cell array contains the table as follows: Cell[which_row][which_column]
 */
public class Puzzle {

    public static final int UNTESTED = 0;
    public static final int SOLVED = 1;
    public static final int UNSOLVABLE = 2;
    public static final int BAD_PUZZLE = 3;
    public static final int MULTIPLE_SOLUTIONS = 4;

    public int gridSize;
    public int blockSize;
    public List<Character> symbols;
    public Cell cells[][];
    public int result;

    public Puzzle(int size, List<Character> symbols){
        gridSize = size;
        blockSize = ((Double) Math.sqrt(gridSize)).intValue();
        this.symbols = symbols;
        initializeCells(size);
    }

    private void initializeCells(int size){
        cells = new Cell[size][];
        for(int i = 0; i < size; i++){
            cells[i] = new Cell[size];
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(symbols);
            }
        }
    }

    public void printToConsole(){
        System.out.println(gridSize);
        for (Character c : symbols) {
            System.out.print(c + " ");
        }
        for (int i = 0; i < gridSize; i++) {
            System.out.println();
            for (int j = 0; j < gridSize; j++) {
                System.out.print(cells[i][j].getValue() + " ");
            }
        }
        System.out.print("\n\n");
    }

    /**
     * Compares components of a Puzzle, mainly needed for testing purposes
     * @param puzzle Puzzle to be compared to this Puzzle
     */
    public boolean equals(Puzzle puzzle){
        if(gridSize != puzzle.gridSize || !symbols.equals(puzzle.symbols)){
            return false;
        }
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                if(cells[i][j].getValue() != puzzle.cells[i][j].getValue()){
                    return false;
                }
            }
        }
        return true;
    }
}
