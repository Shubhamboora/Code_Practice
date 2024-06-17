package Practice;

public class wordSearch {

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                boolean[][] visited = new boolean[row][column];
                boolean find = wordSearch.find(visited, board, word, row, column, i, j, 0);
                if (find)
                    return true;
            }
        }

        return false;
    }

    public static boolean find(boolean[][] visited, char[][] board, String word, int row, int column, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= row || j >= column || board[i][j] != word.charAt(k) || visited[i][j]) return false;

        boolean result = false;
        visited[i][j] = true;
        result = result || wordSearch.find(visited, board, word, row, column, i + 1, j, k + 1);
        result = result || wordSearch.find(visited, board, word, row, column, i - 1, j, k + 1);
        result = result || wordSearch.find(visited, board, word, row, column, i, j + 1, k + 1);
        result = result || wordSearch.find(visited, board, word, row, column, i, j - 1, k + 1);
        visited[i][j] = false;

        return result;

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(wordSearch.exist(board, word));
    }

}
