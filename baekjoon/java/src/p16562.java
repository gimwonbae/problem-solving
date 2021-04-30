import java.util.*;
import java.io.*;

public class p16562 {
    static int N, M;
    static int[] parent;
    static int[] min;
    static int[] cost;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N];
        parent = new int[N];
        min = new int[N];
        init();
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            if (v1 > v2) union(v1, v2);
            else union(v2, v1);
        }
        for (int i = 0; i < N; i++){
            int root = find(i);
            min[root] = Math.min(min[root], cost[i]);
        }
        sol();
        if (ans > K) System.out.println("Oh no");
        else System.out.println(ans);
    }
    public static int find(int x){
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
    public static void init(){
        for (int i = 0; i < N; i++){
            parent[i] = i;
        }
    }
    public static void sol(){
        for (int i = 0; i < N; i++){
            if (min[i] != Integer.MAX_VALUE) ans += min[i];
        }
    }
}
