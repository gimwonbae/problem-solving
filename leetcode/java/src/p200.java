import java.util.*;

class p200 {
    static int ans;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R;
    static int C;

    public int numIslands(char[][] grid) {
        map = grid;
        R = map.length;
        C = map[0].length;
        ans = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == '1'){
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int r, int c) {
        map[r][c] = '0';
        for (int i = 0; i < 4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (0 <= newR && newR < R && 0 <= newC && newC < C && map[newR][newC] == '1'){
                dfs(newR, newC);
            }
        }
    }
}