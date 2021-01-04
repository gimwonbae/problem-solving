import java.util.Scanner;

public class p14888 {
    static int n;
    static int[] cnt;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt = new int[4];
        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++){
            cnt[i] = sc.nextInt();
        }
        dfs(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int depth, int num){
        if (depth == n-1){
            if (num < min) min = num;
            if (num > max) max = num;
            return;
        }
        if (cnt[0] != 0){
            cnt[0]--;
            dfs(depth + 1, num + arr[depth + 1]);
            cnt[0]++;
        }
        if (cnt[1] != 0){
            cnt[1]--;
            dfs(depth + 1, num - arr[depth + 1]);
            cnt[1]++;
        }
        if (cnt[2] != 0){
            cnt[2]--;
            dfs(depth + 1, num * arr[depth + 1]);
            cnt[2]++;
        }
        if (cnt[3] != 0){
            cnt[3]--;
            dfs(depth + 1, num / arr[depth + 1]);
            cnt[3]++;
        }
    }
}
