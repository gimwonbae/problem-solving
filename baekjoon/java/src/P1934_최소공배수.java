import java.util.*;
import java.io.*;

public class P1934_최소공배수 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = a;
            int y = b;
            int r = x % y;
            while (true){
                r = x % y;
                if (r == 0) break;
                x = y;
                y = r;
            }
            sb.append(a*b/y).append("\n");
        }
        System.out.print(sb);
    }
}