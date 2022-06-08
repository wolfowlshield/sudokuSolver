package org.vashonsd;

public class Cell {
    int number;
    boolean isShown;

    public Cell(int num, boolean show) {
        number = num;
        isShown = show;
    }

    public boolean isCorrect(int guess) {
        if (number == guess && !isShown) {
            isShown = true;
            return true;
        }
        return false;
    }

    public int getValue() {
        return number;
    }

    public boolean isShown() {return isShown;}

    public String toString() {
        if (isShown) {
            return String.valueOf(number);
        }
        return " ";
    }
}
