import java.util.Scanner;

public class P11048_이동하기 {
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dp();
        System.out.println(map[n][m]);
    }
    static void dp(){
        for(int i = 2; i <= m ; i++){
            map[1][i] += map[1][i-1];
        }
        for (int i = 2; i <= n ; i++){
            map[i][1] += map[i-1][1];
            for (int j = 2; j <= m; j++){
                map[i][j] += Math.max(Math.max(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
            }
        }
    }
}
