import java.util.*;
import java.io.*;

public class P3920_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++){
            sb.append("#").append(t);

            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 1){
                    int x = Integer.parseInt(st.nextToken());
                    pq.add(x);
                }
                else if (cmd == 2 && !pq.isEmpty()){
                    sb.append(" ").append(pq.poll());
                }
                else{
                    sb.append(" ").append("-1");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
