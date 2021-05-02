import java.util.*;
import java.io.*;

public class P11279_최대힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else{
                pq.add(x);
            }
        }
    }
}
