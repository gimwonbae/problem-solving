import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576_토마토 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static class Tomato{
        int row, col, depth;

        public Tomato(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    static int[][] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        box = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        int ans = bfs(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int row, int col){
        Queue<Tomato> queue = new LinkedList<>();
        for (int i =0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (box[i][j] == 1){
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }
        Tomato t = new Tomato(-1, -1, 0);
        while(!queue.isEmpty()){
            t = queue.poll();
            //System.out.printf("row = %d, col = %d, depth = %d\n", t.row, t.col, t.depth);
            for (int i = 0; i < 4; i++){
                int newR = t.row + dr[i];
                int newC = t.col + dc[i];
                if (0<= newR && newR < row && 0 <= newC && newC < col && box[newR][newC] == 0){
                    box[newR][newC] = 1;
                    queue.add(new Tomato(newR, newC, t.depth + 1));
                }
            }
        }
        return t.depth;
    }
}
