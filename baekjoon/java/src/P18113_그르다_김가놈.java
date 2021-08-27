import java.util.*;
import java.io.*;

public class P18113_그르다_김가놈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if (x <= K) continue;
            if (x < 2*K) x -= K;
            else x -=  2*K;
            if (x == 0) continue;
            else {
                max = Math.max(x, max);
                arr.add(x);
            }
        }
        if (arr.isEmpty()){
            System.out.print(-1);
            System.exit(0);
        }
        int ans = upperBound(arr, 1, max, M);
        if (ans == max + 1) System.out.print(-1);
        else System.out.print(ans);

    }
    public static int upperBound(List<Integer> arr, int left, int right, int M){
        int ans = right + 1;
        while (left <= right){
            int mid = (left + right) / 2;

            int piece = 0;
            for (int x : arr){
                piece += (x / mid);
            }

            if (piece < M){
                right = mid - 1;
            }
            else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}