import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            long MOD = 1000000000;
            long[] dp = new long[1000001];
            dp[1] = 0; dp[2] = 1;
            for(int i=3; i<=N; i++) dp[i] = (i-1) * (dp[i-1] + dp[i-2]) % MOD;

            System.out.println(dp[N]);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}