import java.util.Scanner;

public class P2156_포도주시식 {
    static int[] arr;
    static int[] ans;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        ans = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        dp(n);
        System.out.println(ans[n-1]);
    }

    static void dp(int n){
        ans[0] = arr[0];
        if (n == 1){
            return;
        }
        ans[1] = arr[0] + arr[1];
        if (n == 2){
            return;
        }
        ans[2] = Math.max(arr[1] + arr[2], Math.max(arr[0] + arr[2], arr[0] + arr[1]));
        if (n == 3){
            return;
        }
        for (int i = 3; i < n; i++){
            ans[i] = Math.max(ans[i-1], Math.max(arr[i] + ans[i-2], arr[i] + arr[i-1] + ans[i-3]));
        }
    }
}
