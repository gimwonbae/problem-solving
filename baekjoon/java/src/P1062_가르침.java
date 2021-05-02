import java.util.Scanner;

public class P1062_가르침 {
    static int n, k;
    static boolean[][] words;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        words = new boolean[n][26];
        for (int i = 0; i < n; i++){
            String tmp = sc.next();
            for (int j = 0; j < tmp.length(); j++){
                words[i][tmp.charAt(j) - 'a'] = true;
            }
        }
        visited = new boolean[26];

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        if (k < 5){
            System.out.println(0);
            System.exit(0);
        }
        dfs(0, 5);
        System.out.println(max);
    }

    static void dfs(int index, int depth){
        if (depth == k){
            check();
            return;
        }
        for (int i = index; i < 26; i++){
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void check(){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < 26; j++){
                if (words[i][j] && !visited[j]){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                cnt++;
            }
        }
        if (cnt > max){
            max = cnt;
        }
    }
}
