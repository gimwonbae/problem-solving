import java.util.*;
import java.io.*;

public class P4963_섬의개수 {
    static int w;
    static int h;
    static int[][] map;
    static int[] dw = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dh = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0){
                break;
            }
            map = new int[w][h];

            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (map[j][i] == 1){
                        dfs(j, i);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static void dfs(int col, int row){
        map[col][row] = 0;
        for (int i = 0; i < 8; i++){
            int newW = col + dw[i];
            int newH = row + dh[i];
            if (0 <= newW && newW < w && 0 <= newH && newH < h && map[newW][newH] == 1){
                dfs(newW, newH);
            }
        }
    }
}
