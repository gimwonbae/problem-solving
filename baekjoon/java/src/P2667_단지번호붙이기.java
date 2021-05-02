import java.util.*;

public class P2667_단지번호붙이기 {
    static int n;
    static int cnt = 0;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 1){
                    dfs(i, j);
                    arr.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i: arr) {
            System.out.println(i);
        }
    }
    static void dfs(int row, int col){
        cnt++;
        map[row][col] = 0;

        for (int i = 0; i < 4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if (0 <= newR && newR < n && 0 <= newC && newC < n && map[newR][newC] == 1){
                dfs(newR, newC);
            }
        }
    }
}
