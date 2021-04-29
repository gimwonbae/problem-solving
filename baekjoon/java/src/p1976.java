import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976 {
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        init();

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                int item = Integer.parseInt(st.nextToken());
                if (item == 1)
                    if (i < j) union(i, j);
                    else union(j, i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++){
            int y = Integer.parseInt(st.nextToken());
            if (find(x) != find(y)) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    public static void init(){
        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }
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
}
