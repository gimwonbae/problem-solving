import java.util.Scanner;

public class p14503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        while(true){
            cnt++;
            map[r][c] = 2;
//            System.out.println("r = " + r + " c = " + c + " cnt = " + cnt);
//            for (int i = 0; i < n; i++){
//                for (int j = 0; j < m; j++) {
//                    System.out.printf("%d ", map[i][j]);
//                }
//                System.out.println();
//            }
            int dCnt = 0;
            while(true){
                if (dCnt == 4){
                    int newR = r + dr[(d+2)%4];
                    int newC = c + dc[(d+2)%4];
                    if (0 <= newR && newR < n && 0 <= newC && newC < m && map[newR][newC] != 1){
                        r = newR;
                        c = newC;
                        dCnt = 0;
                        continue;
                    }
                    System.out.println(cnt);
                    System.exit(0);
                }
                if (d == 0) d = 3;
                else d--;

                int newR = r + dr[d];
                int newC = c + dc[d];
                if (0 <= newR && newR < n && 0 <= newC && newC < m && map[newR][newC] == 0){
                    r = newR;
                    c = newC;
                    break;
                }
                dCnt++;
            }
        }

    }
}
