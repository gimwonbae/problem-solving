import java.util.*;
import java.io.*;

public class P2204_도비의_난독증_테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            o1 = o1.toLowerCase();
            o2 = o2.toLowerCase();
            return o1.compareTo(o2);
        });

        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            for (int i = 0; i < N; i++){
                pq.add(br.readLine());
            }
            System.out.println(pq.poll());
            pq.clear();
        }
    }
}