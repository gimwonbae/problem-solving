import java.util.*;
import java.io.*;

public class P16206_롤케이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int remainOne = o1 % 10;
                int remainTwo = o2 % 10;
                if (remainOne == 0 && remainTwo != 0) return -1;
                else if (remainTwo == 0 && remainOne != 0 ) return 1;
                else return o1 - o2;
            }
        });
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while (M > 0 && !pq.isEmpty()){
            int x = pq.poll();
            if (x == 10) ans++;
            else if (x < 10) continue;
            else {
                pq.add(10);
                pq.add(x - 10);
                M--;
            }
        }
        while (!pq.isEmpty()){
            int x = pq.poll();
            if (x == 10) ans++;
            else if (x < 10) continue;
            else {
                break;
            }
        }
        System.out.print(ans);
    }
}
