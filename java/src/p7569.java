import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7569 {
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static class Tomato{
        int row, col, depth, height;

        public Tomato(int row, int col, int height, int depth) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.depth = depth;
        }
    }
    static int[][][] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int height = sc.nextInt();
        box = new int[row][col][height];

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    box[i][j][k] = sc.nextInt();
                }
            }
        }
        int ans = bfs(row, col, height);
        for (int k = 0; k < height; k++){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int row, int col, int height) {
        Queue<Tomato> queue = new LinkedList<>();
        for(int k = 0; k < height; k++){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (box[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k, 0));
                    }
                }
            }
        }

        Tomato t = new Tomato(-1, -1, -1, 0);
        while(!queue.isEmpty()){
            t = queue.poll();
            //System.out.printf("row = %d, col = %d, depth = %d\n", t.row, t.col, t.depth);
            for (int i = 0; i < 6; i++){
                int newR = t.row + dr[i];
                int newC = t.col + dc[i];
                int newH = t.height + dh[i];
                if (0<= newR && newR < row && 0 <= newC && newC < col &&
                        0 <= newH && newH < height && box[newR][newC][newH] == 0){
                    box[newR][newC][newH] = 1;
                    queue.add(new Tomato(newR, newC, newH,t.depth + 1));
                }
            }
        }
        return t.depth;
    }
}
