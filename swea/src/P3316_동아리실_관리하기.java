import java.util.Scanner;

class P3316_동아리실_관리하기 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        int[][] dp;
        T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
            String keys = sc.nextLine();
            dp = new int[keys.length()][16];
            first_day(keys, dp);
            for (int i = 1; i < keys.length(); i++) {
                other_day(keys, dp, i);
            }
            int ans = sol(dp);
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }

    public static void first_day(String keys, int[][] dp) {
        int key = 1 << (keys.charAt(0) - 'A');
        for (int i = 1; i < 16; i++) {
            if ((i & key) != 0 && (i & 1) != 0) dp[0][i] = 1;
        }
    }
    public static void other_day(String keys, int[][] dp, int day) {
        int key = 1 << (keys.charAt(day) - 'A');
        for (int i = 1; i < 16; i++) {
            if (dp[day - 1][i] != 0) {
                for (int j = 1; j < 16; j++) {
                    if ((j & i) != 0 && (j & key) != 0){
                        dp[day][j] += dp[day - 1][i];
                        dp[day][j] %= 1000000007;
                    }
                }
            }
        }
    }
    public static int sol(int[][] dp){
        int sum = 0;
        for (int i = 1; i < 16; i++){
            sum += dp[dp.length-1][i];
            sum %= 1000000007;
        }
        return sum;
    }
}