import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class p2644 {
    static ArrayList<Integer>[] tree;
    static int x;
    static int y;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int m = sc.nextInt();

        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++){
            tree[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            tree[parent].add(child);
            tree[child].add(parent);
        }
        System.out.println(bfs(x, 0));
    }
    static int bfs(int index, int depth){
        Stack<Integer[]> st = new Stack<>();
        st.add(new Integer[] {index, depth});
        visited[index] = true;

        while (!st.isEmpty()){
            Integer[] item = st.pop();
            visited[item[0]] = true;
            //System.out.printf("index = %d, depth = %d \n", item[0], item[1]);
            if (item[0] == y){
                return item[1];
            }
            for (int newIndex : tree[item[0]]){
                if (!visited[newIndex]){
                    st.add(new Integer[] {newIndex, item[1] + 1});
                }
            }
        }
        return -1;
    }
}
