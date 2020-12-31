import java.util.Collection;
import java.util.Scanner;

public class p1182 {
    static int n;
    static int s;
    static int[] arr;
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            max += arr[i];
        }
        dfs(0, 0);
        if (s == 0){
            cnt--;
        }
        System.out.println(cnt);
    }

    public static void dfs(int depth, int num){
        if (depth == n){
            if (num == s) {
                cnt++;
            }
            return;
        }
        dfs(depth + 1, num);
        dfs(depth + 1, num + arr[depth]);
    }
}
