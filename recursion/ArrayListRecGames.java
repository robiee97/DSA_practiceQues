import java.util.*;

public class ArrayListRecGames {
    public static void main(String args[]) {
        // ludoGame();
        // boardPath(0, 10, "");
        int[][] maze = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        floodfilled(0, 0, maze, isVisited, "");
    }

    public static int boardPath(int sr, int desti, String ans) {
        if (sr == desti) {
            System.out.println(ans);
            return 1;
        }
        if (sr > desti) {
            return -1;
        }
        int count = 0;

        for (int i = 1; i <= 6; i++) {
            int inter = sr + i;
            count += boardPath(inter, desti, ans + i);
        }
        return count;
    }

    public static void ludoGame() {

    }

    public static int floodfilled(int sr, int sc, int[][] maze, boolean[][] isVisited, String asf) {

        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return 1;
        }
        int counter = 0;
        if (isvalid(sr, sc, maze, isVisited) == true) {
            // dltr
            isVisited[sr][sc] = true;
            counter += floodfilled(sr + 1, sc, maze, isVisited, asf + "D" + " ");
            counter += floodfilled(sr, sc - 1, maze, isVisited, asf + "L" + " ");
            counter += floodfilled(sr - 1, sc, maze, isVisited, asf + "U" + " ");
            counter += floodfilled(sr, sc + 1, maze, isVisited, asf + "R" + " ");
            isVisited[sr][sc] = false;
        }
        return counter;
    }

    public static boolean isvalid(int sr, int sc, int[][] maze, boolean[][] isVisited) {
        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1
                || isVisited[sr][sc] == true) {
            return false;
        }
        return true;
    }
}
