package dailyChalanges;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 0, 0}, {1, 1, 0}};
        shortestPathBinaryMatrix sp = new shortestPathBinaryMatrix();
        int path = sp.shortestPath(grid);
        System.out.println(path);
    }

    public int shortestPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;


        //check if initial values are 1. if so return -1.
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;

        //possible directions search can be done
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;


        while (!queue.isEmpty()) {

            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPosition = queue.poll();

                if (curPosition[0] == row - 1 && curPosition[1] == col - 1) return ans;

                for (int[] dir : directions) {
                    int nextX = curPosition[0] + dir[0];
                    int nexty = curPosition[1] + dir[1];

                    if (nextX < 0 || nexty < 0 || nextX >= row || nexty >= col || visited[nextX][nexty] == true || grid[nextX][nexty] == 1)
                        continue;

                    visited[nextX][nexty] = true;
                    queue.offer(new int[]{nextX, nexty});
                }
            }
        }
        return -1;
    }

}
