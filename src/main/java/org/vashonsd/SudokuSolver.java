package org.vashonsd;

public class SudokuSolver {

    public static void solvePuzzle(Board board) { // and so begins the not fun times...
        boolean isStillSolvable;
        System.out.println(board);
        while (!board.isFinished()) {
            isStillSolvable = false; // if it fails to make any changes after a full screen of the board, the puzzle cannot be solved (Or it failed)
            for (int x = 1; x <= 9; x++) {
                for (int y = 1; y<= 9; y++) {
                    if (!board.getCell(x,y).isShown()) {
                        int[] notes = findNotes(board, x, y);
                        if (notes.length == 1) { // Is there only one possible answer?
                            if (board.makeGuess(x,y,notes[0])) {
                                isStillSolvable = true;
                            } else {
                                System.out.println("Made an incorrect guess " + x + " " + y + " " + notes[0] + ". Only note in cell"); // This should never appear, and is only used for debugging
                            }
                        } else { // Check if it contains the only appearance of a note in the square/row/column
                            for (int i : notes) {
                                int[] otherNotes;

                                boolean isOnlyNote = true;
                                for (int k = 1; k <= 9; k++) { // Get all the notes in the square

                                    int[] coordinates = Board.getCellCoordinatesFromSquare(Board.findSquareNum(x, y), k); // I'm so sorry

                                    if (!board.getCell(coordinates[0], coordinates[1]).isShown()) { // Make sure that the cell we're looking at isnt already revealed, Unnecessary but probably fine
                                        if (x != coordinates[0] && y != coordinates[1]) {
                                            otherNotes = findNotes(board, coordinates[0], coordinates[1]);
                                            for (int j : otherNotes) { // extract this as a function
                                                if (i == j) {
                                                    isOnlyNote = false;
                                                    break;
                                                }
                                            }
                                            if (!isOnlyNote) { // If we're still going

                                                /*
                                                for () { // all notes in the Column

                                                }

                                                for () { // all notes in the row

                                                }
                                                 */
                                            }
                                        }
                                    }
                                }
                                if (isOnlyNote) {
                                    if (board.makeGuess(x, y, i)) {
                                        isStillSolvable = true;
                                    } else {
                                        System.out.println(board);
                                        System.out.println("Made an incorrect guess " + x + " " + y + " " + i + ". Only Note in square"); // In theory, this should never appear... In practice though...
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!isStillSolvable) {
                System.out.println("I cannot solve");
                break;
            }
        }
        System.out.println(board);
        System.out.println("Finished");
    }

    public static int[] findNotes(Board board, int x, int y) {
        int[] numbersFound = new int[9];

        if (board.getCells()[9-y][x-1].isShown()) { // If the Cell is already revealed, return its value
            return new int[]{board.getCells()[9-y][x-1].getValue()};
        }
        for(Cell c:board.getSquare(Board.findSquareNum(x,y)-1)) {
            if (c.isShown()) {
                numbersFound[c.getValue()-1] = c.getValue();
            }
        }
        for (Cell c: board.getColumn(x-1)) {
            if (c.isShown()) {
                numbersFound[c.getValue()-1] = c.getValue();
            }
        }
        for (Cell c:board.getRow(9-y)) {
            if (c.isShown()) {
                numbersFound[c.getValue()-1] = c.getValue();
            }
        }
        int count = 0;
        for (int i: numbersFound) {
            if (i == 0) {
                count++;
            }
        }
        int[] result = new int[count];

        count = 0;
        for (int i = 1; i <= 9; i++) {
            if (numbersFound[i-1] == 0) {
                result[count] = i;
                count++;
            }
        }

        return result;
    }
}
