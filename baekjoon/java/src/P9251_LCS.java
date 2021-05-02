import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();

        String st = br.readLine();
        for (int i = 0; i < st.length(); i++) {
            a.add(st.charAt(i));
        }
        st = br.readLine();
        for (int i = 0; i < st.length(); i++) {
            b.add(st.charAt(i));
        }
        int aLen = a.size();
        int bLen = b.size();
        int[][] map = new int[aLen+1][bLen+1];
        int max = 0;
        for (int i = 1; i <= aLen; i++){
            for (int j = 1; j <= bLen; j++){
                if (a.get(i-1) == b.get(j-1)){
                    map[i][j] = map[i-1][j-1] + 1;
                }
                else{
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
                if (map[i][j] > max) max = map[i][j];
            }
        }
        System.out.println(max);
    }
}
