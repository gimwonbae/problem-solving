import java.util.*;
import java.io.*;

public class P20058_마법사_상어와_파이어스톰 {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sum;
    static int max;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sum = 0;
        max = 0;
        visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++){
            int L = Integer.parseInt(st.nextToken());
            rotate(L);
//            printMap();
            melt();
        }

        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                if (!visited[r][c] && map[r][c] != 0) sol(r, c);
            }
        }

//        printMap();

        System.out.println(sum);
        System.out.print(max);
    }
    public static void printMap(){
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void rotate(int L){
        int level = (int) Math.pow(2, L);

        int[][] newMap = new int[N][N];

        for (int r = 0; r < N; r += level){
            for (int i = 0; i < level; i++){
                for (int c = 0; c < N; c += level){
                    for (int j = 0; j < level; j++){
//                        newMap[r + i][c + j] = map[c - 1 - j][r + i];
                        newMap[r+j][c-i+level-1] = map[r+i][c+j];
                    }
                }
            }
        }
        map = newMap;
    }
    public static void sol(int R, int C){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(R, C));
        visited[R][C] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            sum += map[node.r][node.c];
            cnt++;

            for (int i = 0; i < 4; i++){
                int newR = node.r + dr[i];
                int newC = node.c + dc[i];
                if (0 <= newR && newR < N && 0 <= newC && newC < N && map[newR][newC] != 0 && !visited[newR][newC]){
                    queue.add(new Node(newR, newC));
                    visited[newR][newC] = true;
                }
            }
        }
        max = Math.max(cnt, max);
    }

    public static void melt(){
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                if (map[r][c] == 0) continue;
                int cnt = 0;
                for (int i = 0; i < 4; i++){
                    int newR = r + dr[i];
                    int newC = c + dc[i];
                    if (0 <= newR && newR < N && 0 <= newC && newC < N && map[newR][newC] != 0){
                        cnt++;
                    }
                }
                if (cnt < 3) map[r][c]--;
            }
        }
    }

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
