import java.util.*;
import java.io.*;

public class P3998_Inversion_Counting {
    static long ans;
    static long[] arr = new long[100001];
    static long[] sortedArr = new long[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            ans = 0L;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            mergesort(0, N-1);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void mergesort(int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            mergesort(start ,mid);
            mergesort(mid + 1, end);
            merge(start, mid ,end);
        }
    }
    public static void merge(int start, int mid, int end){
        int k = start;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end){
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            }
            else {
                sortedArr[k++] = arr[j++];
                ans += (mid - i + 1);
            }
        }
        if (i > mid){
            while (j <= end){
                sortedArr[k++] = arr[j++];
            }
        }
        else {
            while (i <= mid){
                sortedArr[k++] = arr[i++];
            }
        }
        for (i = start; i <= end; i++){
            arr[i] = sortedArr[i];
        }
    }
}
