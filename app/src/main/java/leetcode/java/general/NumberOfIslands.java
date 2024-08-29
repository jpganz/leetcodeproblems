package leetcode.java.general;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int islands = 0;
        int newRow = 0;
        int newColumn = 0;
        int[] last = new int[2];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (visited[row][column] != true && grid[row][column] != '0') {
                    visited[row][column] = true;
                    islands++;
                    queue.offer(new int[]{row, column});
                    while (!queue.isEmpty()) {
                        last = queue.poll();
                        for (int[] neighbor : neighbors) {
                            newRow = last[0] + neighbor[0];
                            newColumn = last[1] + neighbor[1];
                            if (newRow >= 0 && newColumn >= 0
                                    && newRow < rows && newColumn < columns
                                    && grid[newRow][newColumn] != '0' && visited[newRow][newColumn] != true) {
                                visited[newRow][newColumn] = true;
                                queue.offer(new int[]{newRow, newColumn});
                            }
                        }
                    }

                }

            }
        }

        return islands;

    }

    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };

        char[][] input2 = {
                {'1', '2', '3' },
                {'4', '5', '0' },
                {'6', '0', '0' },
                {'0', '0', '0' },
                {'0', '0', '1' }
        };

        int output = numIslands(input);
        System.out.println("the number of islands are : " + output);
    }
}
