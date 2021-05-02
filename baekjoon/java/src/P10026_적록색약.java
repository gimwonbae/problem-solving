import java.util.Scanner;

public class P10026_적록색약 {
    static char[][] map;
    static boolean visited[][];
    static boolean visited_2[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        map = new char[n][n];
        visited = new boolean[n][n];
        visited_2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!visited_2[i][j]){
                    dfs_2(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if (0 <= newR && newR < n && 0 <= newC && newC < n && !visited[newR][newC] && map[row][col] == map[newR][newC]){
                dfs(newR, newC);
            }
        }
    }

    private static void dfs_2(int row, int col) {
        visited_2[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newR = row + dr[i];
            int newC = col + dc[i];
            if (0 <= newR && newR < n && 0 <= newC && newC < n && !visited_2[newR][newC]) {
                if (map[row][col] == 'B' && map[newR][newC] == 'B'){
                    dfs_2(newR, newC);
                }
                else if (map[row][col] != 'B' && map[newR][newC] != 'B'){
                    dfs_2(newR, newC);
                }
            }
        }
    }
}
