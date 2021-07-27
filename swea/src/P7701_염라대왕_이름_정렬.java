import java.util.*;
import java.io.*;

public class P7701_염라대왕_이름_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            SortedSet<String> set = new TreeSet<>();
            for (int i = 0; i < N; i++){
                set.add(br.readLine());
            }

            List<String> dict = new ArrayList<>(set);
            Collections.sort(dict, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int len1 = o1.length();
                    int len2 = o2.length();
                    if (len1 < len2) return -1;
                    else if (len1 > len2) return 1;
                    else {
                        for (int i = 0; i < len1; i++){
                            if (o1.charAt(i) < o2.charAt(i)) return -1;
                            else if (o1.charAt(i) > o2.charAt(i)) return 1;
                        }
                        return 0;
                    }
                }
            });


            sb.append("#").append(t).append("\n");
            for (String s : dict){
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }
}
