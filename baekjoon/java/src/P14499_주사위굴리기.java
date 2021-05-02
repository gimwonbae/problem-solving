import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14499_주사위굴리기 {
    static int N, M;
    static int[][] map;
    static Dice dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dice = new Dice(x, y);
        map = new int[N][M];

        for (int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++){
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd){
                case 1:
                    east();
                    break;
                case 2:
                    west();
                    break;
                case 3:
                    north();
                    break;
                case 4:
                    south();
                    break;
            }
        }
    }
    public static class Dice{
        int r, c, front, back, top, bottom, left, right;
        public Dice(int r, int c){
            this.r = r;
            this.c = c;
            this.front = 0;
            this.back = 0;
            this.top = 0;
            this.bottom = 0;
            this.left = 0;
            this.right = 0;
        }
    }
    public static void east(){
        int newC = dice.c + 1;
        if (newC < M){
            dice.c = newC;
            int tmp = dice.bottom;
            dice.bottom = dice.right;
            dice.right = dice.top;
            dice.top = dice.left;
            dice.left = tmp;
            if (map[dice.r][dice.c] == 0) dice_to_map();
            else map_to_dice();
        }
    }
    public static void west(){
        int newC = dice.c - 1;
        if (0 <= newC){
            dice.c = newC;
            int tmp = dice.bottom;
            dice.bottom = dice.left;
            dice.left = dice.top;
            dice.top = dice.right;
            dice.right = tmp;
            if (map[dice.r][dice.c] == 0) dice_to_map();
            else map_to_dice();
        }
    }
    public static void north(){
        int newR = dice.r - 1;
        if (0 <= newR){
            dice.r = newR;
            int tmp = dice.bottom;
            dice.bottom = dice.back;
            dice.back = dice.top;
            dice.top = dice.front;
            dice.front = tmp;
            if (map[dice.r][dice.c] == 0) dice_to_map();
            else map_to_dice();
        }
    }
    public static void south(){
        int newR = dice.r + 1;
        if (newR < N){
            dice.r = newR;
            int tmp = dice.bottom;
            dice.bottom = dice.front;
            dice.front = dice.top;
            dice.top = dice.back;
            dice.back = tmp;
            if (map[dice.r][dice.c] == 0) dice_to_map();
            else map_to_dice();
        }
    }
    public static void map_to_dice(){
        dice.bottom = map[dice.r][dice.c];
        map[dice.r][dice.c] = 0;
        System.out.println(dice.top);
    }
    public static void dice_to_map(){
        map[dice.r][dice.c] = dice.bottom;
        System.out.println(dice.top);
    }
}
