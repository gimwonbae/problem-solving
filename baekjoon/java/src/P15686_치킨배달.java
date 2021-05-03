import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15686_치킨배달 {
    static int m;
    static List<Point> chicken = new ArrayList<>();
    static List<Point> house = new ArrayList<>();
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int x = sc.nextInt();
                if (x == 1){
                    house.add(new Point(i, j));
                }
                else if (x == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int index, int depth){
        if (depth == m){
            cal();
            return;
        }
        for (int i = index; i < chicken.size(); i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
    static void cal(){
        int sum = 0;
        for (int i = 0; i < house.size(); i++){
            int house_min = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++){
                if (visited[j]){
                    int tmp = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                    if (tmp < house_min) house_min = tmp;
                }
            }
            sum += house_min;
        }
        if (sum < min) min = sum;
    }
}

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}