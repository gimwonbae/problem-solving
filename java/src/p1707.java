import java.util.*;
import java.io.*;

public class p1707 {
    static int v;
    static int e;
    static List<Integer>[] graph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            for (int j = 0; j <= v; j++){
                graph[j] = new ArrayList<>();
            }
            colors = new int[v+1];

            for (int j = 0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph[first].add(second);
                graph[second].add(first);
            }

            boolean flag = true;
            Queue<Integer> q = new LinkedList<Integer>();
            for (int j = 1; j <= v; j++){
                if (colors[j] == 0){
                    q.add(j);
                    colors[j] = 1;
                }
                while (flag && !q.isEmpty()){
                    int x = q.poll();
                    int color = colors[x];
                    for (int item : graph[x]){
//                        System.out.println("x = " + x + " color = " + color + " item = " + item + " colors[item] = " + colors[item]);
                        if (colors[item] == 0){
                            colors[item] = color * -1;
                            q.add(item);
                        } else if (colors[item] == color){
                            System.out.println("NO");
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) break;
            }
            if (flag) System.out.println("YES");
        }
    }
}
