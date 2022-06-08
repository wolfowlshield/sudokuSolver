package org.vashonsd;

public class SavedPuzzles {

    public static final Cell[][] testPuzzle2 = new Cell[][] {
            new Cell[]{new Cell(1,true),new Cell(2,false),new Cell(3,true),new Cell(4,false),new Cell(5,false),new Cell(6,false),new Cell(7,true),new Cell(8,false),new Cell(9,false)},
            new Cell[]{new Cell(4,false),new Cell(5,true),new Cell(6,false),new Cell(7,false),new Cell(8,true),new Cell(9,false),new Cell(1,false),new Cell(2,false),new Cell(3,false)},
            new Cell[]{new Cell(7,false),new Cell(8,false),new Cell(9,true),new Cell(1,false),new Cell(2,false),new Cell(3,false),new Cell(4,false),new Cell(5,false), new Cell(6,false)},
            new Cell[]{new Cell(1,true),new Cell(2,false),new Cell(3,true),new Cell(4,false),new Cell(5,false),new Cell(6,false),new Cell(7,true),new Cell(8,false),new Cell(9,false)},
            new Cell[]{new Cell(4,false),new Cell(5,true),new Cell(6,false),new Cell(7,false),new Cell(8,true),new Cell(9,false),new Cell(1,false),new Cell(2,false),new Cell(3,false)},
            new Cell[]{new Cell(7,false),new Cell(8,false),new Cell(9,true),new Cell(1,false),new Cell(2,false),new Cell(3,false),new Cell(4,false),new Cell(5,false), new Cell(6,false)},
            new Cell[]{new Cell(1,true),new Cell(2,false),new Cell(3,true),new Cell(4,false),new Cell(5,false),new Cell(6,false),new Cell(7,true),new Cell(8,false),new Cell(9,false)},
            new Cell[]{new Cell(4,false),new Cell(5,true),new Cell(6,false),new Cell(7,false),new Cell(8,true),new Cell(9,false),new Cell(1,false),new Cell(2,false),new Cell(3,false)},
            new Cell[]{new Cell(7,false),new Cell(8,false),new Cell(9,true),new Cell(1,false),new Cell(2,false),new Cell(3,false),new Cell(4,false),new Cell(5,false), new Cell(6,false)}
    };

    public static final Cell[][] puzzle1 = new Cell[][] { // PLEASE DEAR GOD MAKE A GENERATOR SO YOU DONT HAVE TO TYPE THESE OUT BY HAND
            new Cell[]{new Cell(5,false),new Cell(6,true), new Cell(8,true), new Cell(7,false),new Cell(2,false),new Cell(4,false),new Cell(9,true), new Cell(3,true), new Cell(1,false)},
            new Cell[]{new Cell(3,false),new Cell(4,true), new Cell(2,true), new Cell(5,false),new Cell(1,false),new Cell(9,false),new Cell(6,true), new Cell(7,false),new Cell(8,false)},
            new Cell[]{new Cell(1,true), new Cell(9,true), new Cell(7,false),new Cell(3,false),new Cell(8,true), new Cell(6,false),new Cell(2,false),new Cell(4,true), new Cell(5,false)},
            new Cell[]{new Cell(6,false),new Cell(8,true), new Cell(5,true), new Cell(2,true), new Cell(3,false),new Cell(1,true), new Cell(4,false),new Cell(9,false),new Cell(7,true)},
            new Cell[]{new Cell(7,true), new Cell(3,false),new Cell(4,false),new Cell(8,true), new Cell(9,true), new Cell(5,false),new Cell(1,false),new Cell(2,false),new Cell(6,false)},
            new Cell[]{new Cell(2,true), new Cell(1,false),new Cell(9,true), new Cell(4,false),new Cell(6,false),new Cell(7,true), new Cell(5,true), new Cell(8,false),new Cell(3,true)},
            new Cell[]{new Cell(9,false),new Cell(2,true), new Cell(6,false),new Cell(1,true), new Cell(7,false),new Cell(8,false),new Cell(3,false),new Cell(5,true), new Cell(4,false)},
            new Cell[]{new Cell(8,true), new Cell(5,true), new Cell(1,false),new Cell(9,false),new Cell(4,true), new Cell(3,false),new Cell(7,true), new Cell(6,true), new Cell(2,false)},
            new Cell[]{new Cell(4,true), new Cell(7,true), new Cell(3,true), new Cell(6,false),new Cell(5,true), new Cell(2,true), new Cell(8,false),new Cell(1,false),new Cell(9,true)}
    };

    // alternatively we could've had a Cell[3][3][3][3], but a Cell[9][9] will be nicer to get rows and columns for solving and generating.

    public static Cell[][] getTestPuzzle() {return testPuzzle2;}

    public static Cell[][] getPuzzle() {
        return puzzle1;
    }


}