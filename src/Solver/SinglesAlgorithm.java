package Solver;

import Puzzle.Puzzle;

/**
 * Created by Ty on 11/16/2016.
 * 1) Traverse all rows/columns looking for cells with a single possible value
 *    a) If found, set the cell's value
 * 2) Remove that value from the other cells' possible values
 */
public class SinglesAlgorithm extends SudokuAlgorithm {

    @Override
    public void applyMethod(Puzzle puzzle) {
        int blockSize = ((Double) Math.sqrt(puzzle.gridSize)).intValue();

        for(int rowIndex = 0; rowIndex < puzzle.gridSize; rowIndex++){
            for(int colIndex = 0; colIndex < puzzle.gridSize; colIndex++){
                if(puzzle.cells[rowIndex][colIndex].possibleValues.size() == 1){
                    char value = puzzle.cells[rowIndex][colIndex].possibleValues.get(0);
                    puzzle.cells[rowIndex][colIndex].setValue(value);
                    updateNotes(rowIndex, colIndex, puzzle, blockSize);
                }
            }
        }
    }

    private void updateNotes(int rowIndex, int colIndex, Puzzle puzzle, int blockSize){
        updatePossibleValuesInRow(rowIndex, puzzle);
        updatePossibleValuesInColumn(colIndex, puzzle);
        //TODO: Only pass the indices to the top-left cell in the affected block
        for(int i = 0; i < puzzle.gridSize; i += blockSize){
            for(int j = 0; j < puzzle.gridSize; j += blockSize){

            }
        }
        updatePossibleValuesInBlock(rowIndex, colIndex, puzzle, blockSize);
    }
}
