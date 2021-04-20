import java.util.*;
import java.io.*;

public class p20055 {
    static int N;
    static int K;
    static int size;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        size = 2*N;
        belt = new int[size];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;
        while (K > 0){
            rotate();
            robotRotate();
            level++;
        }
        System.out.println(level);
    }
    public static void rotate(){
        int tmp = belt[size - 1];
        for (int i = size - 1; i >= N; i--){
            belt[i] = belt[i-1];
        }
        for (int i = N - 1; i >= 1; i --){
            belt[i] = belt[i-1];
            robot[i] = robot[i-1];
        }
        belt[0] = tmp;
        robot[0] = false;
    }
    public static void robotRotate(){
        robot[N-1] = false;
        for (int i = N - 2; i >= 0; i--){
            if (robot[i] && !robot[i+1] && belt[i+1] > 0) {
                robot[i+1] = true;
                belt[i+1]--;
                if (belt[i+1] == 0) K--;
                robot[i] = false;
            }
        }
        if (!robot[0] && belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
            if (belt[0] == 0) K--;
        }
    }
}
