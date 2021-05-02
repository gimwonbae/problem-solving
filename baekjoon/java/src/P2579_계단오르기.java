import java.util.Scanner;

public class P2579_계단오르기 {
    static int n;
    static int[] arr;
    static int[] cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        cnt = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        cnt[0] = arr[0];
        if (n >= 2) cnt[1] = arr[0] + arr[1];
        if (n >= 3) cnt[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        if (n > 3) {
            for (int k = 3; k < n; k++){
                cnt[k] = Math.max(cnt[k-3] + arr[k-1] + arr[k], cnt[k-2] + arr[k]);
            }
        }
        System.out.println(cnt[n-1]);
    }
}
