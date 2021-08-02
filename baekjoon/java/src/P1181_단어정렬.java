import java.util.*;
import java.io.*;

public class P1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SortedSet<String> set = new TreeSet<>();

        for (int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        List<String> dict = new ArrayList<>(set);
        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                else {
                    for (int i = 0; i < o1.length(); i++){
                        if (o1.charAt(i) != o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : dict){
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }
}
