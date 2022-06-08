package org.vashonsd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testMakeSquare() {
        Board board = new Board(SavedPuzzles.getPuzzle());

        Cell[] answer = new Cell[]{board.getCells()[0][0],board.getCells()[0][1],board.getCells()[0][2],board.getCells()[1][0],board.getCells()[1][1],board.getCells()[1][2],board.getCells()[2][0],board.getCells()[2][1],board.getCells()[2][2]};
        assertArrayEquals(answer, board.getSquare(0));

        answer = new Cell[]{board.getCells()[3][6],board.getCells()[3][7],board.getCells()[3][8],board.getCells()[4][6],board.getCells()[4][7],board.getCells()[4][8],board.getCells()[5][6],board.getCells()[5][7],board.getCells()[5][8]};
        assertArrayEquals(answer, board.getSquare(5));
    }

    @Test
    public void testFindSquareNum() {
        assertEquals(3, Board.findSquareNum(9,9));
        assertEquals(3, Board.findSquareNum(7,7));
        assertEquals(5, Board.findSquareNum(5,5));
        assertEquals(6, Board.findSquareNum(7,6));
        assertEquals(7, Board.findSquareNum(1,1));
        assertEquals(1, Board.findSquareNum(3,7));
    }

    @Test
    public void testGetCell() {
        Board board = new Board(SavedPuzzles.getPuzzle());

        assertEquals(board.getCells()[0][0], board.getCell(1,9));
        assertEquals(board.getCells()[4][4], board.getCell(5,5));
        assertEquals(board.getCells()[7][3], board.getCell(4,2));
    }

    @Test
    public void testGetCoordinatesFromSquare() {
        assertArrayEquals(new int[]{1,9}, Board.getCellCoordinatesFromSquare(1,1));
        assertArrayEquals(new int[]{9,1}, Board.getCellCoordinatesFromSquare(9,9));
        assertArrayEquals(new int[]{5,5}, Board.getCellCoordinatesFromSquare(5,5));
        assertArrayEquals(new int[]{4,2}, Board.getCellCoordinatesFromSquare(8,4));
        assertArrayEquals(new int[]{7,6}, Board.getCellCoordinatesFromSquare(6,1));
    }
}