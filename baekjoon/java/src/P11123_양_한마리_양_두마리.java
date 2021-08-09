import java.util.*;
import java.io.*;

public class P11123_양_한마리_양_두마리 {
    static char[][] map;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            for (int i = 0; i < R; i++){
                String line = br.readLine();
                for (int j = 0; j < C; j++){
                    map[i][j] = line.charAt(j);
                }
            }
            int ans = 0;
            for (int i = 0; i < R; i++){
                for (int j = 0; j < C; j++){
                    if (map[i][j] == '#'){
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    public static void bfs(int r, int c){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c));
        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0; i < 4; i++){
                int newR = cur.r + dr[i];
                int newC = cur.c + dc[i];

                if (0 <= newR && newR < R && 0 <= newC && newC < C && map[newR][newC] == '#'){
                    map[newR][newC] = '.';
                    q.add(new Node(newR, newC));
                }
            }
        }
    }
    public static class Node {
        int r;
        int c;

        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
