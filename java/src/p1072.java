import java.util.Scanner;

public class p1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x, y, z;
        x = sc.nextLong();
        y = sc.nextLong();
        z = y * 100 / x;

        long ans = Long.MAX_VALUE;
        long low = 1;
        long high = x;
        while (low <= high){
            long mid = (low + high)/2;
            if (((mid + y) * 100 / (x + mid)) > z){
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if (ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
