import java.util.*;
import java.io.*;

public class P1516_게임개발 {
    static int n;
    static List<Integer>[] arr;
    static int[] indegree;
    static int[] weight;
    static int[] ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        indegree = new int[n+1];
        weight = new int[n+1];
        ans = new int[n+1];
        arr = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            ans[i] = weight[i];
            int tmp = Integer.parseInt(st.nextToken());
            while(tmp != -1){
                arr[tmp].add(i);
                indegree[i]++;
                tmp = Integer.parseInt(st.nextToken());
            }
        }
        tsort();
    }
    static void tsort(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int item : arr[x]){
                indegree[item]--;
                if (indegree[item] == 0){
                    queue.add(item);
                }
                ans[item] = Math.max(ans[item], ans[x] + weight[item]);
            }
        }
        for (int i = 1; i <= n; i++){
            System.out.println(ans[i]);
        }
    }
}
