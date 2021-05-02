import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] aList = new int[n];
        int[] bList = new int[n];
        int[] cList = new int[n];
        int[] dList = new int[n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            aList[i] = Integer.parseInt(st.nextToken());
            bList[i] = Integer.parseInt(st.nextToken());
            cList[i] = Integer.parseInt(st.nextToken());
            dList[i] = Integer.parseInt(st.nextToken());
        }
        int[] abList = new int[n*n];
        int[] cdList = new int[n*n];

        int index = 0;
        for (int i = 0; i < n; i++){
            int aItem = aList[i];
            int cItem = cList[i];
            for (int j = 0; j < n; j++){
                abList[index] = aItem + bList[j];
                cdList[index] = cItem + dList[j];
                index++;
            }
        }
        Arrays.sort(abList);
        Arrays.sort(cdList);

        int abLen = n*n;
        int cdLen = n*n;
        int abp = 0;
        int cdp = cdLen - 1;

        long ans = 0;
        while (abp < abLen && cdp >= 0){
            long abItem = abList[abp];
            long cdItem = cdList[cdp];
            long sum = abItem + cdItem;
            if (sum > 0) cdp--;
            else if (sum < 0) abp++;
            else{
                long abCnt = 0;
                long cdCnt = 0;
                while (abp < abLen && abList[abp] == abItem){
                    abp++;
                    abCnt++;
                }
                while (cdp >= 0 && cdList[cdp] == cdItem){
                    cdp--;
                    cdCnt++;
                }
                ans += abCnt*cdCnt;
            }
        }
        System.out.println(ans);
    }
}
