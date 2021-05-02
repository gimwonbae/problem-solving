import java.util.*;

public class P2143_두배열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n = sc.nextInt();
        int[] n_arr = new int[n];
        for (int i = 0; i < n; i++){
            n_arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] m_arr = new int[m];
        for (int i = 0; i < m; i++){
            m_arr[i] = sc.nextInt();
        }

        List<Integer> nList = new ArrayList<>();
        List<Integer> mList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int item = n_arr[i];
            nList.add(item);
            for (int j = i + 1; j < n; j++){
                item += n_arr[j];
                nList.add(item);
            }
        }
        for (int i = 0; i < m; i++){
            int item = m_arr[i];
            mList.add(item);
            for (int j = i + 1; j < m; j++){
                item += m_arr[j];
                mList.add(item);
            }
        }
        Collections.sort(nList);
        Collections.sort(mList);

        int nLen = nList.size();
        int mLen = mList.size();
        int np = 0;
        int mp = mLen - 1;
        long ans = 0;

        while(np < nLen && mp >= 0){
            int nItem = nList.get(np);
            int mItem = mList.get(mp);

            int sum = nItem + mItem;
            if (sum > t) mp--;
            else if (sum < t) np++;
            else{
                long nCnt = 0;
                long mCnt = 0;
                while(np < nLen && nList.get(np) == nItem){
                    np++;
                    nCnt++;
                }
                while(mp >= 0 && mList.get(mp) == mItem){
                    mp--;
                    mCnt++;
                }
                ans += nCnt * mCnt;
            }
        }
        System.out.println(ans);
    }
}
