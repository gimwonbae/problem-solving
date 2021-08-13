import java.util.*;
import java.io.*;

public class P16139_인간_컴퓨터_상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[][] arr = new int[26][S.length()];
        arr[S.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < S.length(); i++){
            for (int j = 0; j < 26; j++){
                arr[j][i] = arr[j][i-1];
            }
            int alphabet = S.charAt(i) - 'a';
            arr[alphabet][i]++;
        }

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphabet = st.nextToken().charAt(0) - 'a';
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (left == 0) sb.append(arr[alphabet][right]).append("\n");
            else sb.append(arr[alphabet][right] - arr[alphabet][left-1]).append("\n");
        }
        System.out.print(sb);
    }
}
