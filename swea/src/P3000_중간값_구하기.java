import java.util.*;
import java.io.*;

public class P3000_중간값_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            maxHeap.add(x);
            minHeap = new PriorityQueue<>();
            int ans = 0;
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                minHeap.add(Integer.parseInt(st.nextToken()));
                maxHeap.add(Integer.parseInt(st.nextToken()));
                if (maxHeap.peek() > minHeap.peek()){
                    int min = minHeap.poll();
                    int max = maxHeap.poll();
                    maxHeap.add(min);
                    minHeap.add(max);
                }
                ans += maxHeap.peek();
                ans %= 20171109;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
