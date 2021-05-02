import java.util.Scanner;

public class P1717_집합의표현 {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        p = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (cmd == 0) union(a, b);
            else {
                a = find(a);
                b = find(b);
                if (a == b) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    static int find(int x){
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) p[y] = x;
    }
}
