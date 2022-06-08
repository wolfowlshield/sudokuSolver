package org.vashonsd;

/*
 * [   |   |   ]
 * [   |   |   ]
 * [   |   |   ]
 */
public class Square { // This class is mostly organizational, it will come in helpful later when we get to solving sudoku puzzles

    Cell[] cells;

    public Square (Cell[] cellValues) {
        cells = cellValues;
    }

    public String getRow(int row) {
        String result = "[ ";
        for (int i = 0; i < 3; i++) { // I HAVE HARNESSED THE POWER OF FOUR FOR LOOPS, 3^4 = 81 Cells
            result = result.concat(cells[i + (3 * row)].toString());
            if (i != 2) {
                result = result.concat(" | ");
            } else {
                result = result.concat(" ] ");
            }
        }
        return result;
    }

    public Cell[] getCells() {
        return cells;
    }

}
