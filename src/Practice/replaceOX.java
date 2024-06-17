package Practice;

public class replaceOX {


    static char[][] fill(int n, int m, char a[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O')
                    a[i][j] = '-';
            }
        }

        System.out.println("------Check-------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(a[i][j] + " ");

            System.out.println("");
        }
        System.out.println("------Check-------------");
        for (int i = 0; i < n; i++) {
            if (a[i][0] == '-')
                replaceOX.corners(a, i, 0, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (a[0][j] == '-')
                replaceOX.corners(a, 0, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            if (a[i][m - 1] == '-')
                replaceOX.corners(a, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (a[n - 1][j] == '-')
                replaceOX.corners(a, n - 1, j, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '-') a[i][j] = 'X';
            }
        }
        return a;

    }

    public static void corners(char a[][], int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] != '-') return;

        a[i][j] = 'O';
        corners(a, i + 1, j, n, m);
        corners(a, i, j + 1, n, m);
        corners(a, i - 1, j, n, m);
        corners(a, i, j - 1, n, m);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[][] mat = {{'O', 'X', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O'}};

        replaceOX.fill(4, 5, mat);

        System.out.println("------Check-------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println("");
        }
        System.out.println("------Check-------------");
    }

}
