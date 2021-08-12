import java.util.*;
import java.io.*;

public class P20364_부동산_다툼 {
    static int N;
    static int[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N+1];
        for (int i = 0; i < M; i++){
            int index = Integer.parseInt(br.readLine());
            sb.append(graph[index]).append("\n");
            if (graph[index] == 0) {
                graph[index] = index;
                update(index, index);
            }
        }
        System.out.print(sb);
    }
    public static void update(int index, int block){
        if (index*2 <= N){
            graph[index*2] = block;
            update(index*2, block);
        }
        if (index*2 + 1 <= N){
            graph[index*2 + 1] = block;
            update(index*2 + 1, block);
        }
    }
}
