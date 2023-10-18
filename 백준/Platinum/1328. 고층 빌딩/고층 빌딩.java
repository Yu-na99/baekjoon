import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int L = sc.nextInt();
            int R = sc.nextInt();

            long[][][] dp = new long[N+1][N+1][N+1];    // dp[N][L][R]
            dp[1][1][1] = 1; // 빌딩이 1개이면 좋을 수 있는 경우의 수 1

            for(int i=2; i<=N; i++)
                for(int j=1; j<=L; j++)
                    for(int k=1; k<=R; k++)
                        dp[i][j][k] = (dp[i-1][j][k] * (i-2) + dp[i-1][j][k-1] + dp[i-1][j-1][k]) % 1000000007;


            System.out.println(dp[N][L][R]);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}