import java.util.Scanner;

public class p2003 {
    public static void main(String[] args) {
        int n, m, sum;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int cnt = 0;

        for (int i = 0; i < n; i++){
            sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum == m){
                    cnt++;
                    break;
                }
                else if (sum > m){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
