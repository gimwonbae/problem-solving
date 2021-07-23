import java.util.*;
import java.io.*;

public class P1970_쉬운_거스름돈 {
    public static int[] coins = {50000,10000,5000,1000,500,100,50,10};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            System.out.printf("#%d\n", t + 1);
            int[] answer = new int[8];
            greedy(answer, Integer.parseInt(br.readLine()));
            for(int i = 0; i < 8; i++){
                System.out.printf("%d ", answer[i]);
            }
            System.out.println();
        }
    }
    public static void greedy(int[]answer,int price){
        for(int i = 0; i < 8; i++){
            answer[i] = price / coins[i];
            price %= coins[i];
        }
    }
}
