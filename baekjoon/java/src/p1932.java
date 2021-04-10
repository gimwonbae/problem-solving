import java.util.ArrayList;
import java.util.Scanner;

public class p1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++){
            tree[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++){
            tree[i].add(sc.nextInt());
            for (int j = 0; j < i; j++){
                tree[i].add(sc.nextInt());
            }
        }
        if (n == 1){
            System.out.println(tree[0].get(0));
            System.exit(0);
        }
        for (int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                tree[i].set(j, Math.max(tree[i].get(j) + tree[i+1].get(j), tree[i].get(j) + tree[i+1].get(j+1)));
            }
        }
        System.out.println(tree[0].get(0));
    }
}
