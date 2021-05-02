import java.util.Arrays;
import java.util.Scanner;

public class P2805_나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long ans = 0;

        long trees[] = new long[n];
        for (int i = 0; i < n; i++){
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);
        long low = 0;
        long high = trees[n-1];

        while (low <= high){
            long mid = (low + high) / 2;
            long sum = 0;
            for (long tree : trees){
                if (tree > mid){
                    sum += tree - mid;
                }
            }
            if (sum >= m){
                ans = Math.max(mid , ans);
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
