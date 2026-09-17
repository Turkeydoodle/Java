package Java;

import java.util.*;

public class TicTacToe {

    public static int[] addValue(int[] arr, int value) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = value;
        return newArr;
    }

    public static void printintgrid(int[][] grid) {
        System.out.println(grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2]);
        System.out.println("----------");
        System.out.println(grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2]);
        System.out.println("----------");
        System.out.println(grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
    }

    public static void printstringgrid(String[][] grid) {
        System.out.println(grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2]);
        System.out.println("----------");
        System.out.println(grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2]);
        System.out.println("----------");
        System.out.println(grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);
    }

    public static Boolean checkWin(int[][] winConditions, int[] playerpieces) {
        for (int[] condition : winConditions) {
            boolean hasAllThree = true;
            for (int square : condition) {
                if (!isused(playerpieces, square)) {
                    hasAllThree = false;
                    break;
                }
            }
            if (hasAllThree) {
                System.out.println("Win detected!");
                return true;
            }
        }
        return false;
    }

    public static Boolean isused(int[] arr, int input) {
        for (int element : arr) {
            if (element == input) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arg) {
        int[][] grid = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        String[][] stringgrid = { { " ", " ", "" }, { " ", " ", "" }, { " ", " ", "" } };
        int[][] winConditions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 6, 4, 2 } };
        int[] playerpieces = {};
        int[] player2pieces = {};
        int turnnumber = 1;
        System.out.println("Tic Tac Toe");
        Scanner input = new Scanner(System.in);
        Boolean winDetected = false;
        while (!winDetected) {
            System.out.println("Your board:");
            printstringgrid(stringgrid);
            System.out.println("Coordinate Board:");
            printintgrid(grid);
            if (turnnumber % 2 != 0) {
                System.out.println("What square do you want to place your piece in, player 1?");
            } else {
                System.out.println("What square do you want to place your piece in, player 2?");
            }
            int userSquare = input.nextInt();
            if (userSquare > -1) {
                if (userSquare < 9) {

                    System.out.println("Your input is valid!");
                    if (turnnumber % 2 != 0) {
                        if (!isused(playerpieces, userSquare) && !isused(player2pieces, userSquare)) {
                            playerpieces = addValue(playerpieces, userSquare);
                            stringgrid[userSquare / 3][userSquare % 3] = "X";
                            if (checkWin(winConditions, playerpieces)) {
                                System.out.println("Player 1 wins!");
                                winDetected = true;
                                break;
                            }
                        } else {
                            System.out.println("Space occupied! You gave up your turn!");
                        }
                    } else {
                        if (!isused(playerpieces, userSquare) && !isused(player2pieces, userSquare)) {
                            player2pieces = addValue(player2pieces, userSquare);
                            stringgrid[userSquare / 3][userSquare % 3] = "O";
                            if (checkWin(winConditions, player2pieces)) {
                                System.out.println("Player 2 wins!");
                                winDetected = true;
                                break;
                            }
                        } else {
                            System.out.println("Space occupied! You gave up your turn!");
                        }
                    }
                    turnnumber += 1;
                }
                input.close();
            }
        }
    }
}
