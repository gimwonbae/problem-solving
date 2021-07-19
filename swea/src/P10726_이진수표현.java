import java.util.Scanner;

class P10726_이진수표현
{
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = (1 << N) - 1;
            if ((M & X) == X) System.out.printf("#%d ON\n", test_case);
            else System.out.printf("#%d OFF\n", test_case);
        }
    }
}