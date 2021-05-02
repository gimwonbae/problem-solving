import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로탐색 {
    static int[][] visited;
    static int n, m;
    static int[][] arr;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][m+1];
        sc.nextLine();
        for (int i = 1; i <= n; i++){
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++){
                arr[i][j] = line.charAt(j - 1) - '0';
            }
        }

        visited = arr.clone();
        bfs(1,1);
    }

    public static void bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = 1;
        while (!queue.isEmpty()){
            int[] x = queue.poll();
            row = x[0];
            col = x[1];

            //System.out.printf("row: %d, col: %d, visited=%d \n", row, col, visited[row][col]);
            if (row == n && col == m){
                System.out.println(visited[row][col]);
                break;
            }
            for (int i = 0; i < 4; i++){
                int newR = row + dr[i];
                int newC = col + dc[i];

                if(1<= newR && newR <= n && 1<= newC && newC <=m && arr[newR][newC] == 1){
                    queue.add(new int[]{newR, newC});
                    visited[newR][newC] = visited[row][col] + 1;
                }
            }
        }
    }
}
