package org.vashonsd;

/*
 * System.out.println("9 [   | 2 |   ] [   | 5 |   ] [   |   |   ]");
 * System.out.println("8 [ 1 |   |   ] [   |   |   ] [   |   |   ]");
 * System.out.println("7 [   |   |   ] [   |   |   ] [   | 9 |   ]");
 * System.out.println("  [ - + - + - ] [ - + - + - ] [ - + - + - ]");
 * System.out.println("6 [ 3 |   |   ] [   |   |   ] [   |   |   ]");
 * System.out.println("5 [   |   |   ] [ 7 |   |   ] [   |   |   ]");
 * System.out.println("4 [   |   |   ] [   |   |   ] [   |   |   ]");
 * System.out.println("  [ - + - + - ] [ - + - + - ] [ - + - + - ]"); Example Board
 * System.out.println("3 [   |   |   ] [   |   |   ] [   |   |   ]");
 * System.out.println("2 [   |   |   ] [   |   |   ] [   |   |   ]");
 * System.out.println("1 [   |   |   ] [   |   | 8 ] [   |   |   ]");
 * System.out.println("    1   2   3     4   5   6     7   8   9");
 */

public class Board {

    Cell[][] board = new Cell[9][9];
    Square[] squares = new Square[9];

    public Board(Cell[][] board) {

        System.arraycopy(board, 0, this.board, 0, 9);

        for (int i = 0; i < 9; i++) {
            squares[i] = makeSquare(i);
        }

    }

    public Cell[][] getCells() {
        return board;
    }
    public Cell getCell(int x, int y) {
        return board[9-y][x-1];
    }

    public Square makeSquare(int squareNum) { // This is zero Indexed
        int squareX = squareNum % 3; // 0 - 2
        int squareY = squareNum / 3; // 0 - 2

        Cell[] values = new Cell[9];
        int count = 0;

        for (int i = 0; i < 3; i++) { // get the Cell[] we need
            for (int j = 0; j < 3; j++) { // get the Cell we need
                values[count] = board[i + squareY * 3][j + squareX * 3];
                count++;
            }
        }

        return new Square(values);
    }

    public Cell[] getRow(int rowNum) {
        return board[rowNum];
    }
    public Cell[] getColumn(int columnNum) {
        Cell[] column = new Cell[9];

        for (int i = 0; i < 9; i++) {
            column[i] = board[i][columnNum];
        }

        return column;
    }

    public Cell[] getSquare(int squareNum) {
        return squares[squareNum].getCells();
    }

    public static int findSquareNum(int x, int y) { // x and y should each be between 1-9
        return ((x-1)/3)+1 + (6 - ((y-1)/3)*3);
    } // Square numbers are in order from 1-9 left to right, top to bottom

    public static int[] getCellCoordinatesFromSquare(int squareNum, int cellNum) {
        int[] coordinates = new int[2]; // x, y

        int x = (((squareNum-1) % 3) * 3) + ((cellNum-1) % 3) + 1;
        int y = 9 - ((((squareNum-1) / 3) * 3) + ((cellNum-1) / 3)); // Forgive the parenthesis

        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    } // Given a squareNum and a Cell Num, return a length 2 int Array of the coordinates of the cell

    public boolean makeGuess(int x, int y, int guess) {

        return board[9-y][x-1].isCorrect(guess);
    }

    public boolean isFinished() {
        for (Cell[] c: board) {
            for (Cell i: c) {
                if (!i.isShown()) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() { // I need to rewrite this, this is outdated from before the entire board was saved in a Cell[][]
        String result = "";

        for (int squareRow = 0; squareRow < 3; squareRow++) { // makes the entire board outta the rows of squares
            for (int row = 0; row < 3; row++) { // makes squares outta rows
                result = result.concat((9 - row - (squareRow * 3)) + " "); // adds the row num in front
                for (int i = 0; i < 3; i++) { // [ 1 | 2 | 3 ][ 4 | 5 | 6 ][ 7 | 8 | 9 ]
                    result = result.concat(squares[(i + (3 * squareRow))].getRow(row)); // [ 1 | 2 | 3 ]
                }
                result = result.concat("\n");
            }
            if (squareRow!= 2) {
                result = result.concat("  [ - + - + - ] [ - + - + - ] [ - + - + - ]\n"); // Append this after every three rows except the last
            }
        }
        result = result.concat("    1   2   3     4   5   6     7   8   9");
        return result;
    }
}
