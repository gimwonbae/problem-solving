import java.util.*;
import java.io.*;

public class p1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            if (calc(k)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    static boolean calc(int n){
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
