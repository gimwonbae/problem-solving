import java.util.*;
import java.io.*;

public class P11724_연결_요소의_개수 {
    static int ans;
    static boolean[] visited;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ans = 0;
        arr = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 1; i < N+1; i++){
            if (!visited[i]) bfs(i);
        }
        System.out.println(ans);
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();
            List<Integer> tmp = arr[start];
            for (int i = 0; i < tmp.size(); i++){
                int end = tmp.get(i);
                if (!visited[end]) {
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        ans++;
    }
}
