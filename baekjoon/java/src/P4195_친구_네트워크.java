import java.util.*;
import java.io.*;

public class P4195_친구_네트워크 {
    static Map<String, Node> map;
    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                map.putIfAbsent(s1, new Node(1, s1));
                map.putIfAbsent(s2, new Node(1, s2));
                union(s1, s2);
                System.out.println(map.get(find(s1)).rank);
            }
            map.clear();
        }

    }
    public static class Node {
        int rank;
        String parent;

        public Node(int rank, String parent){
            this.rank = rank;
            this.parent = parent;
        }
    }
    public static String find(String s){
        if (s.equals(map.get(s).parent)) return s;
        return map.get(s).parent = find(map.get(s).parent);
    }
    public static void union(String s1, String s2){
        s1 = find(s1);
        s2 = find(s2);
        if (s1.equals(s2)) return;
        if (map.get(s1).rank >= map.get(s2).rank){
            map.get(s2).parent = s1;
            map.get(s1).rank += map.get(s2).rank;
        }
        else {
            map.get(s1).parent = s2;
            map.get(s2).rank += map.get(s1).rank;
        }
    }
}
