package org.vashonsd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void findNotes() {
        Board board = new Board(SavedPuzzles.getPuzzle());
        System.out.println(board);

        int[] notes = SudokuSolver.findNotes(board,1,1);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{4}, notes);

        notes = SudokuSolver.findNotes(board,1,2);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{8}, notes);

        notes = SudokuSolver.findNotes(board,1,3);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{6,9}, notes);

        notes = SudokuSolver.findNotes(board,3,2);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{1}, notes);

        notes = SudokuSolver.findNotes(board,9,4);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{3}, notes);

        notes = SudokuSolver.findNotes(board,8,5);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{1,2}, notes);

        notes = SudokuSolver.findNotes(board,9,5);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{1,2,4,6}, notes);

        notes = SudokuSolver.findNotes(board,5,8);
        System.out.println(Arrays.toString(notes));
        assertArrayEquals(new int[]{1,3,7}, notes);
    }
}