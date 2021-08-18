import java.util.*;
import java.io.*;

public class P1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                if (o1.cnt != o2.cnt) return o2.cnt - o1.cnt;
                else return o1.ch - o2.ch;
            }
        });
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('T', 0);
        map.put('G', 0);
        map.put('C', 0);

        String[] arr = new String[N];
        for (int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        int ans = 0;
        for (int i = 0; i < M; i++){
            map.replace('A', 0);
            map.replace('T', 0);
            map.replace('G', 0);
            map.replace('C', 0);

            for (int j = 0; j < N; j++){
                char ch = arr[j].charAt(i);
                map.replace(ch, map.get(ch) + 1);
            }
            pq.add(new Node('A', map.get('A')));
            pq.add(new Node('T', map.get('T')));
            pq.add(new Node('G', map.get('G')));
            pq.add(new Node('C', map.get('C')));

            Node node = pq.poll();
            sb.append(node.ch);
            ans += (N - node.cnt);
            pq.clear();
        }
        sb.append("\n").append(ans);
        System.out.print(sb);
    }
    static class Node {
        char ch;
        int cnt;
        public Node(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
