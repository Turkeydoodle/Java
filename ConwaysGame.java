package Java;

import java.lang.Thread;

public class ConwaysGame {

    public static void printgrid(String[][] array) {
        for (int i = 0; i < 20; i++) {
            System.out.println(array[i][0] + "|" + array[i][1] + "|" + array[i][2] + "|" + array[i][3] + "|"
                    + array[i][4]
                    + "|" + array[i][5] + "|" + array[i][6] + "|" + array[i][7] + "|" + array[i][8] + "|" + array[i][9]
                    + "|" + array[i][10] + "|" + array[i][11] + "|" + array[i][12] + "|" + array[i][13] + "|"
                    + array[i][14]
                    + "|" + array[i][15] + "|" + array[i][16] + "|" + array[i][17] + "|" + array[i][18] + "|"
                    + array[i][19]);
            System.out.println("---------------------------------------");
        }
    }

    public static Boolean underOrOver(String[][] array, int row, int column) {
        int max = 19;
        int numberOfNeighbors = 0;
        if ((column - 1) >= 0 && array[row][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((column + 1) <= max && array[row][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && array[row - 1][column].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && array[row + 1][column].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && (column - 1) >= 0 && array[row + 1][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && (column + 1) <= max && array[row + 1][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && (column - 1) >= 0 && array[row - 1][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && (column + 1) <= max && array[row - 1][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if (numberOfNeighbors < 2 || numberOfNeighbors > 3) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean reproduce(String[][] array, int row, int column) {
        int max = 19;
        int numberOfNeighbors = 0;
        if ((column - 1) >= 0 && array[row][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((column + 1) <= max && array[row][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && array[row - 1][column].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && array[row + 1][column].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && (column - 1) >= 0 && array[row + 1][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row + 1) <= max && (column + 1) <= max && array[row + 1][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && (column - 1) >= 0 && array[row - 1][column - 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if ((row - 1) >= 0 && (column + 1) <= max && array[row - 1][column + 1].equals("X")) {
            numberOfNeighbors += 1;
        }
        if (numberOfNeighbors == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        String[][] grid = new String[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                grid[i][j] = " ";
            }
        }
        grid[10][10] = "X";
        grid[11][10] = "X";
        grid[11][11] = "X";
        grid[10][11] = "X";
        grid[11][9] = "X";
        while (true) {
            printgrid(grid);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (underOrOver(grid, i, j)) {
                        grid[i][j] = " ";
                    }
                    reproduce(grid, i, j);
                    grid[i][j] = "X";
                }
            }
            Thread.sleep(1000);

        }
    }
}