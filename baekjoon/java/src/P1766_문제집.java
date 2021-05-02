import java.util.*;
import java.io.*;

public class P1766_문제집 {
    static int[] indegree;
    static List<Integer>[] arr;
    static int n;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        indegree = new int[n+1];
        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indegree[b]++;
            arr[a].add(b);
        }
        tsort();
    }
    static void tsort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            System.out.print(x + " ");
            for (int item : arr[x]){
                indegree[item]--;
                if (indegree[item] == 0){
                    pq.add(item);
                }
            }
        }
    }
}
