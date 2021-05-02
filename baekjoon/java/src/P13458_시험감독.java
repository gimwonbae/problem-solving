import java.util.Scanner;

public class P13458_시험감독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();

        long cnt = 0;
        for (int i = 0; i < n; i++){
            arr[i] -= b;
            cnt++;
            if (arr[i] > 0){
                int q = arr[i]/c;
                int r = arr[i]%c;
                cnt += q;
                if (r > 0) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
