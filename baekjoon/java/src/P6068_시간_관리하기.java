import java.io.*;
import java.util.*;

public class P6068_시간_관리하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.end - o1.end);
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int time = 1000000;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (time < node.end){
                time -= node.need;
            }
            else {
                time = node.end - node.need;
            }
        }
        if (time <= 0) System.out.print(-1);
        else System.out.print(time);
    }
    public static class Node {
        int need;
        int end;

        public Node(int need, int end){
            this.need = need;
            this.end = end;
        }
    }
}
