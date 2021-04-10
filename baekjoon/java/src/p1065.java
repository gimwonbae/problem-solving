import java.util.*;
import java.io.*;

public class p1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n < 100) {
            System.out.println(n);
            System.exit(0);
        }
        int cnt = 99;
        for (int i = 101; i <= n; i++){
            String line = Integer.toString(i);
            int a = line.charAt(0) - line.charAt(1);
            int b = line.charAt(1) - line.charAt(2);
            if (a == b) cnt++;
        }
        System.out.println(cnt);
    }
}
