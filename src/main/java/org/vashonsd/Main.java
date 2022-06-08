package org.vashonsd;

public class Main {


    public static void main(String[] args) {

        Cell[][] currentPuzzle = SavedPuzzles.getPuzzle();

        //SudokuGame game = new SudokuGame(new Board(currentPuzzle));
        //game.playSudoku();

        SudokuSolver.solvePuzzle(new Board(currentPuzzle));

    }
}
