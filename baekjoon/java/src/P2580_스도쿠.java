import java.util.Scanner;

public class P2580_스도쿠 {
    static int[][] map = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
    }
    static void dfs(int row, int col){
        if (col == 9){
            dfs(row + 1, 0);
            return;
        }
        if (row == 9){
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    System.out.print(map[i][j]);
                    System.out.print(' ');
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (map[row][col] == 0){
            for (int i = 1; i <= 9; i++){
                if (check(row, col, i)){
                    map[row][col] = i;
                    dfs(row, col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }
    static boolean check(int row, int col, int num){
        for (int i = 0; i < 9; i++){
            if (map[row][i] == num){
                return false;
            }
        }
        for (int i = 0; i < 9; i++){
            if (map[i][col] == num){
                return false;
            }
        }
        int n_row = (row / 3) * 3;
        int n_col = (col / 3) * 3;
        for (int i = n_row; i < n_row + 3; i++){
            for (int j = n_col; j < n_col + 3; j++){
                if (map[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
