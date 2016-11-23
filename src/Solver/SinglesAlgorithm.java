package Solver;

import Puzzle.Puzzle;
import Puzzle.Cell;

/**
 * Created by Ty on 11/16/2016.
 * 1) If current cell has a single possible value, set it as the value
 * 2) Remove that value from the other cells' possible values
 */
public class SinglesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle, int currRow, int currCol) {

        Cell currCell = puzzle.cells[currRow][currCol];
        if (currCell.hasValue()) {
            return;
        }
        if (currCell.possibleValues.size() == 1) {
            currCell.setValue(currCell.possibleValues.get(0));
            updateNotes(puzzle, currRow, currCol);
        }
    }
}
