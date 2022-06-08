package org.vashonsd;

import java.util.Scanner;

public class SudokuGame {

    Board board;

    public SudokuGame(Board board) {
        this.board = board;
    }

    public void playSudoku() {
        System.out.println(board);

        String guess;
        int x;
        int y;
        int num;

        boolean stillRunning = true;

        while (stillRunning) {
            Scanner input = new Scanner(System.in);

            System.out.println("Insert the following: x-coordinate, y-coordinate, and number");
            guess = input.nextLine();
            if (guess.equals("exit")) {
                stillRunning = false;
            } else {
                String numbers = guess.replaceAll("[^1-9]", ""); // Thank you stackOverflow
                if (numbers.length() < 3) {
                    System.out.println("You didn't use enough numbers");
                } else {
                    x = Integer.parseInt(numbers.substring(0, 1));
                    y = Integer.parseInt(numbers.substring(1, 2));
                    num = Integer.parseInt(numbers.substring(2));

                    if (!board.makeGuess(x, y, num)) {
                        System.out.println(board);
                        System.out.println("That's the wrong number");
                    } else {
                        System.out.println(board);
                        if (board.isFinished()) {
                            System.out.println("Congrats! You is Win! A Winner is You!");
                            stillRunning = false;
                        }
                    }
                }
            }
        }
    }
}
