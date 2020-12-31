import java.util.Scanner;

public class p14889 {
    static int n;
    static int[][] s;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                s[i][j] = sc.nextInt();
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min);
    }
    public static void dfs(int index, int cnt){
        if (cnt == n/2){
            int team1 = 0;
            int team2 = 0;
            for (int j = 0; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if (visited[j] && visited[k]){
                        team1 = team1 + s[j][k] + s[k][j];
                    }
                    else if (!visited[j] && !visited[k]){
                        team2 = team2 + s[j][k] + s[k][j];
                    }
                }
            }
            if (min > Math.abs(team1 - team2)){
                min = Math.abs(team1 - team2);
            }
//            for (int i = 0; i < n; i++){
//                System.out.printf("visited[%d] = %b \n", i, visited[i]);
//            }
//            System.out.printf("team1 = %d, team2 = %d \n", team1, team2);
//            System.out.printf("min = %d \n", min);
            return;
        }
        for (int i = index; i < n; i++){
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
