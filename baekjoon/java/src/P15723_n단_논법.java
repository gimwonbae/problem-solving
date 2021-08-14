import java.io.*;

public class P15723_n단_논법 {
    static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[26][26];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            String S = br.readLine();
            graph[S.charAt(0) - 'a'][S.charAt(5) - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++){
            fw(i);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            String S = br.readLine();
            int start = S.charAt(0) - 'a';
            int end = S.charAt(5) - 'a';
            if (graph[start][end] == 0) sb.append("F").append("\n");
            else sb.append("T").append("\n");
        }
        System.out.print(sb);
    }
    public static void fw(int i){
        for (int s = 0; s < 26; s++){
            if (s != i){
                for (int e = 0; e < 26; e++){
                    if (e != i){
                        if (graph[s][e] == 1) continue;
                        else graph[s][e] = Math.min(graph[s][i], graph[i][e]);
                    }
                }
            }
        }
    }
}
