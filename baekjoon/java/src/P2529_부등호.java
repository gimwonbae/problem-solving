import java.io.*;

public class P2529_부등호 {
    static int N;
    static String condition;
    static int[] ans;
    static boolean[] number;
    static boolean complete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = new int[N+1];
        number = new boolean[10];

        condition = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--){
            if (complete) break;
            ans[0] = i;
            number[i] = true;
            dfs_max(1);
            number[i] = false;
        }
        for (int i = 0; i < N+1; i++){
            sb.append(ans[i]);
        }
        sb.append("\n");
        complete = false;
        for (int i = 0; i <= 9; i++){
            if (complete) break;
            ans[0] = i;
            number[i] = true;
            dfs_min(1);
            number[i] = false;
        }
        for (int i = 0; i < N+1; i++){
            sb.append(ans[i]);
        }
        System.out.println(sb.toString());
    }
    public static void dfs_max(int depth){
        if (depth == N+1){
            complete = true;
            return;
        }
        char flag = condition.charAt((depth-1)*2);
        for (int i = 9; i >= 0; i--){
            if (complete) return;
            if (!number[i] && checker(flag, depth, i)){
                ans[depth] = i;
                number[i] = true;
                dfs_max(depth + 1);
                number[i] = false;
            }
        }
    }
    public static void dfs_min(int depth){
        if (depth == N+1){
            complete = true;
            return;
        }
        char flag = condition.charAt((depth-1)*2);
        for (int i = 0; i <= 9; i++){
            if (complete) return;
            if (!number[i] && checker(flag, depth, i)){
                ans[depth] = i;
                number[i] = true;
                dfs_min(depth + 1);
                number[i] = false;
            }
        }
    }
    public static boolean checker(char flag, int depth, int i){
        return (flag == '<' && ans[depth - 1] < i) || (flag == '>' && ans[depth - 1] > i);
    }
}
