import java.util.Scanner;

public class P1987_알파벳 {
    static int r, c;
    static int[][] map;
    static boolean[][] map_v;
    static boolean[] visited = new boolean[26];
    static int max = 1;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        map = new int[r][c];

        for (int i = 0; i < r; i++){
            String line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int row, int col, int depth) {
        visited[map[row][col]] = true;
        for (int i = 0; i < 4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if (0 <= newR && newR < r && 0 <= newC && newC < c && !visited[map[newR][newC]]){
                dfs(newR, newC, depth + 1);
            }
        }
        visited[map[row][col]] = false;
        if (depth > max) max = depth;
    }
}
