import java.util.Scanner;

public class P2096_내려가기 {
    static int n;
    static int[][] maxMap;
    static int[][] minMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maxMap = new int[n+1][3];
        minMap = new int[n+1][3];

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < 3; j++){
                int item = sc.nextInt();
                maxMap[i][j] = item;
                minMap[i][j] = item;
            }
        }
        System.out.print(max(n)+" ");
        System.out.println(min(n));
    }
    static int max(int n){
        for (int i = 1; i <= n; i++){
            int left = Math.max(maxMap[i-1][0], maxMap[i-1][1]);
            int right = Math.max(maxMap[i-1][1], maxMap[i-1][2]);
            maxMap[i][0] += left;
            maxMap[i][1] += Math.max(left, right);
            maxMap[i][2] += right;
        }
        return Math.max(maxMap[n][2], Math.max(maxMap[n][0], maxMap[n][1]));
    }
    static int min(int n){
        for (int i = 1; i <= n; i++){
            int left = Math.min(minMap[i-1][0], minMap[i-1][1]);
            int right = Math.min(minMap[i-1][1], minMap[i-1][2]);
            minMap[i][0] += left;
            minMap[i][1] += Math.min(left, right);
            minMap[i][2] += right;
        }
        return Math.min(minMap[n][2], Math.min(minMap[n][0], minMap[n][1]));
    }
}
