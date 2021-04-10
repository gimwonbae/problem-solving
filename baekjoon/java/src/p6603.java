import java.util.Scanner;

public class p6603 {
    static int n;
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while((n = sc.nextInt()) != 0){
            s = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++){
                s[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }
    public static void dfs(int index, int cnt){
        if (cnt == 6){
            for (int j = 0; j < n; j++){
                if (visited[j]){
                    System.out.printf("%d ", s[j]);
                }
            }
            System.out.println();
        }
        for (int i = index; i < n; i++){
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
