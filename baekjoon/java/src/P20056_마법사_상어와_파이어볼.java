import java.util.*;
import java.io.*;

public class P20056_마법사_상어와_파이어볼 {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Fireball>[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new ArrayDeque[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r-1][c-1].add(new Fireball(m, s, d));
        }
        for (int i = 0; i < K; i++){
            move();
            separate();
        }
        sol();
    }
    public static void move(){
        Queue<Fireball>[][] newMap = new ArrayDeque[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                newMap[i][j] = new ArrayDeque<>();
            }
        }

        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                while (!map[r][c].isEmpty()){
                    Fireball fireball = map[r][c].poll();
                    int newR = Math.floorMod(r + dr[fireball.d] * fireball.s, N);
                    int newC = Math.floorMod(c + dc[fireball.d] * fireball.s, N);

                    newMap[newR][newC].add(fireball);
                }
            }
        }
        map = newMap;
    }
    public static void separate(){
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                int odd = 0;
                int even = 0;
                int size = map[r][c].size();
                if (size <= 1) continue;

                Fireball allFireball = new Fireball(0, 0, 0);
                while (!map[r][c].isEmpty()){
                    Fireball fireball = map[r][c].poll();
                    if ((fireball.d & 1) == 0) even++;
                    else odd++;

                    allFireball.m += fireball.m;
                    allFireball.s += fireball.s;
                }
                if (allFireball.m < 5) continue;
                int newM = allFireball.m / 5;
                int newS = allFireball.s / size;

                if (odd == size || even == size) {
                    map[r][c].add(new Fireball(newM, newS, 0));
                    map[r][c].add(new Fireball(newM, newS, 2));
                    map[r][c].add(new Fireball(newM, newS, 4));
                    map[r][c].add(new Fireball(newM, newS, 6));
                }
                else {
                    map[r][c].add(new Fireball(newM, newS, 1));
                    map[r][c].add(new Fireball(newM, newS, 3));
                    map[r][c].add(new Fireball(newM, newS, 5));
                    map[r][c].add(new Fireball(newM, newS, 7));
                }
            }
        }
    }
    public static void sol(){
        int ans = 0;
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                for (Fireball fireball : map[r][c]){
                    ans += fireball.m;
                }
            }
        }
        System.out.print(ans);
    }
    public static class Fireball {
        int m;
        int s;
        int d;

        public Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
