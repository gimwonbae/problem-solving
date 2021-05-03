import java.util.*;

public class P3055_탈출 {
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int r, c;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Queue<Dot> ratQue = new LinkedList<>();
        Queue<Dot> waterQue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        visited = new boolean[r][c];

        sc.nextLine();
        for (int i = 0; i < r; i++){
            String str = sc.nextLine();
            for (int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S'){
                    ratQue.add(new Dot(i, j));
                    visited[i][j] = true;
                }
                else if (map[i][j] == '*'){
                    waterQue.add(new Dot(i, j));
                }
            }
        }
        while(!ratQue.isEmpty()){
            int len = waterQue.size();
            for (int i = 0; i < len; i++){
                Dot newWater = waterQue.poll();
                //System.out.printf("water index = %d %d, cnt = %d\n", newWater.row, newWater.col, newWater.cnt);
                for (int j = 0; j < 4; j++){
                    int newR = newWater.row + dr[j];
                    int newC = newWater.col + dc[j];
                    if (-1 < newR && newR < r && -1 < newC && newC < c && map[newR][newC] == '.'){
                        waterQue.add(new Dot(newR, newC));
                        map[newR][newC] = '*';
                    }
                }
            }
            len = ratQue.size();
            for (int i = 0; i < len; i++){
                Dot newDot = ratQue.poll();
                //System.out.printf("rat index = %d %d, cnt = %d\n", newDot.row, newDot.col, newDot.cnt);
                if (map[newDot.row][newDot.col] == 'D'){
                    System.out.println(cnt);
                    System.exit(0);
                }
                for (int j = 0; j < 4; j++){
                    int newR = newDot.row + dr[j];
                    int newC = newDot.col + dc[j];
                    if (-1 < newR && newR < r && -1 < newC && newC < c && map[newR][newC] != '*' && map[newR][newC] != 'X' && !visited[newR][newC]){
                        ratQue.add(new Dot(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
            cnt++;
        }
        System.out.println("KAKTUS");
    }
}

class Dot{
    int row, col, cnt;

    public Dot(int row, int col) {
        this.row = row;
        this.col = col;
    }
}