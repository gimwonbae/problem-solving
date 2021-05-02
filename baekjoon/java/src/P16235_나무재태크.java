import java.util.*;
import java.io.*;

public class P16235_나무재태크 {
    static int N;
    static int M;
    static int[][] A;
    static List<Integer>[][] treeMap;
    static int[][] fuelMap;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        fuelMap = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                fuelMap[i][j] = 5;
            }
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        treeMap = new List[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                treeMap[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            treeMap[x-1][y-1].add(age);
        }
        for (int i = 0; i < k; i++){
            spring_summer();
            autumn();
            winter();
        }
        System.out.println(sol());
    }
    public static void spring_summer(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Collections.sort(treeMap[i][j]);
                List<Integer> tmpList = treeMap[i][j];

                boolean flag = false;
                int point = tmpList.size() + 1;

                for (int l = 0; l < tmpList.size(); l++){
                    int treeAge = tmpList.get(l);
                    if (fuelMap[i][j] >= treeAge){
                        fuelMap[i][j] -= treeAge;
                        tmpList.set(l, treeAge + 1);
                    }
                    else {
                        point = l;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    int len = tmpList.size();
                    for (int l = 0; l < len - point; l++){
                        fuelMap[i][j] += tmpList.get(point) / 2;
                        tmpList.remove(point);
                    }
                }
            }
        }
    }
    public static void autumn(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                List<Integer> tmpList = treeMap[i][j];
                for (Integer age : tmpList) {
                    if (age % 5 == 0) {
                        for (int m = 0; m < 8; m++) {
                            int newR = i + dr[m];
                            int newC = j + dc[m];
                            if (0 <= newR && newR < N && 0 <= newC && newC < N) {
                                treeMap[newR][newC].add(1);
                            }
                        }
                    }
                }
            }
        }
    }
    public static void winter(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                fuelMap[i][j] += A[i][j];
            }
        }
    }
    public static int sol(){
        int ans = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                ans += treeMap[i][j].size();
            }
        }
        return ans;
    }
}
