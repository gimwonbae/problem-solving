import java.util.Scanner;

public class P1012_유기농배추 {
    static int[][] map;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            map = new int[n][m];
            for (int j = 0; j < k; j++){
                int col = sc.nextInt();
                int row = sc.nextInt();
                map[row][col] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1){
                        dfs(j, l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int row, int col){
        map[row][col] = 0;
        for (int i = 0; i < 4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if (0 <= newR && newR < n && 0 <= newC && newC < m && map[newR][newC] == 1){
                dfs(newR, newC);
            }
        }
    }
}
