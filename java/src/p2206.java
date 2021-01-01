import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2206 {
    static class Dot {
        int row, col, num, token;

        public Dot(int row, int col, int num, int token) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.token = token;
        }
    }

    static int[][] map, visited;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static int n, m, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        ans = Integer.MAX_VALUE;

        map = new int[n+1][m+1];
        visited = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++){
                map[i][j] = line.charAt(j-1) - '0';
                visited[i][j] = 3;
            }
        }
        bfs(1, 1);
        if (ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }

    public static void bfs(int row, int col){
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(row, col, 1, 0));
        while(!queue.isEmpty()){
            Dot d = queue.poll();
            //System.out.printf("row = %d, col = %d, num = %d, token = %d\n", d.row, d.col, d.num, d.token);
            if (d.row == n && d.col == m){
                ans = d.num;
                //System.out.println(ans);
                return;
            }
            for (int i =0; i < 4; i++){
                int newR = d.row + dr[i];
                int newC = d.col + dc[i];
                //System.out.printf("newR = %d, newC = %d\n", newR, newC);
                if (1<=newR && newR<=n && 1<=newC && newC<=m && visited[newR][newC] > d.token){
                    if (map[newR][newC] == 1 && d.token == 0) {
                        queue.add(new Dot(newR, newC, d.num + 1, 1));
                        visited[newR][newC] = 1;
                    }
                    else if (map[newR][newC] == 0){
                        queue.add(new Dot(newR, newC, d.num + 1, d.token));
                        visited[newR][newC] = 1;
                    }
                }
            }
        }
    }
}
