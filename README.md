# CS5700_HW4 / CS5700_HW5



Justification of Design Decisions:

- I found that every single algorithm was iterating over the entire puzzle (among more complex/specific iterating), so
I decided to use the template pattern to let a template method iterate over each cell in the puzzle.  This meant writing
each algorithm so that it was only concerned with one cell at a time, allowing the template method to make sure each
algorithm was applied across the board (rather than each algorithm having to do it on its own).

- It was difficult to decide where to put the puzzle validation logic.  I put it in the solver because that's where it's used, and a solver should know its
criteria for being able to solve a puzzle.  But one could argue that a puzzle should be the one to know how to tell its own validity, and that the solver
shouldn't need to understand how to look through and interpret the puzzle.  It could also be argued that there should be an algorithm/set of algorithms to
deal with this, but they would serve such a different purpose from the other SudokuAlgorithms that it would feel awkward for them all to extend the same
superclass.  In the end, I decided to let the Solver contain this logic, because perhaps in the future the Solver's abilities could be changed/improved, and
it can adjust its own criteria for valid puzzles rather than making the puzzles change.

- I had a similar difficulty with deciding where the logic for updating the puzzle should be.  It could be argued that the puzzle should know how to update
itself, but I decided to let the SudokuAlgorithm know this.  In my mind, it makes sense for the Puzzle to be able to inspect and report on its state, but the
 SudokuAlgorithms are the ones that know how to manipulate and change the data in the Puzzle in meaningful ways.


If you run the program such that it solves all 30 of the test puzzles, it will save them to src/Output/[puzzlename].txt



Things learned in my revision:
- Using and traversing Strings instead of Lists for the 'possibleValues' property of each cell actually MORE THAN DOUBLED the time required to solve all 30
puzzles.  Unfortunately it took a few hours of refactoring to realize that.  Fortunately though, IntelliJ quickly reverted these uncommitted changes for me
(yay version control).
- Writing test cases actually helped me identify a few methods that weren't properly named, ie. the 'getBlockIndex' method implies that it is a simple
getter to a property, however the method actually contains logic that figures out the top-left index of that block containing the given cell.  It is much
more appropriate to call it 'puzzle.calculateBlockIndex'