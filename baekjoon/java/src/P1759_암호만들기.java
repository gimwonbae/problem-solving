import java.util.Arrays;
import java.util.Scanner;

public class P1759_암호만들기 {
    static int n, m;
    static StringBuilder sb;
    static boolean[] visited;
    static String[] arr;
    static int cons = 0, vow = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[m];

        sc.nextLine();
        String tmp = sc.nextLine();
        arr = tmp.split(" ");

        Arrays.sort(arr);
        dfs(0, 0);
    }
    static void dfs(int index, int depth){
        if (depth == n){
            if (vow >=1 && cons >= 2){
                System.out.println(sb.toString());
                return;
            }
            return;
        }
        for (int i = index; i < m; i++){
            if (!visited[i]){
                add(i);
                visited[i] = true;
                sb.append(arr[i]);
                dfs(i, depth + 1);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
                delete(i);
            }
        }
    }
    static void add(int i){
        if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
            vow++;
            return;
        }
        cons++;
    }
    static void delete(int i){
        if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
            vow--;
            return;
        }
        cons--;
    }
}
