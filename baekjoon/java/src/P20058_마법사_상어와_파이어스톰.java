import java.util.*;
import java.io.*:

public class P20058_마법사_상어와_파이어스톰 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++){
            int L = Integer.parseInt(st.nextToken());
        }

    }
    public static void rotate(int L){
        int level = (int) Math.pow(2, L);

        int[][] newMap = new int[N][N];

        for (int r = 0; r < N; r += level){
            for (int i = 0; i < level; i++){
                for (int c = 0; c < N; c += level){
                    for (int j = 0; j < level; j++){
                        newMap[i][j] = map[c + level - 1 - j][r + i];
                    }
                }
            }
        }
        map = newMap;
    }
    public static void
}
