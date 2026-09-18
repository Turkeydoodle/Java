package Java;

import java.lang.Thread;
import java.util.Scanner;

public class ConwaysModified {
    private int rows = 20;
    private int cols = 20;
    private boolean[][] grid;

    public ConwaysModified() {
        grid = new boolean[rows][cols];
    }

    public void printgrid(Boolean[][] array) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (grid[i][j] == true) {
                    System.out.println("X");
                } else {
                    System.out.println("-");
                }
            }
        }
    }

    public int checkneighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((i == 0) && (j == 0)) {
                    continue;
                }
                int dr = row + i;
                int dc = col + j;
                if ((dr >= this.grid.length) && (dr < 0) && (dc >= this.grid[0].length) && (dc < 0)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] arg) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 200; i++) {
            int row = (int) (Math.random() * 19);
            int column = (int) (Math.random() * 19);
            this.grid[row][column] = true;
        }
        while (true) {
            printgrid(grid);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (checkneighbors(i, j)) {
                        this.grid[i][j] = true;
                    } else {
                        this.grid[i][j] = false;
                    }
                }
            }
            System.out.println("Press Enter");
            input.nextLine();

        }
    }
}