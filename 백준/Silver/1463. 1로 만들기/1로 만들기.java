import java.io.*;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+3];

            dp[1]=0; dp[2]=1; dp[3]=1;
            for(int i=4; i<=N; i++){
                if(i % 6 == 0) dp[i] = Math.min(dp[i/3], dp[i/2])+1;
                else if(i % 3 == 0) dp[i] = Math.min(dp[i-1], dp[i/3])+1;
                else if(i % 2 == 0) dp[i] = Math.min(dp[i-1], dp[i/2])+1;
                else dp[i] = dp[i-1]+1;
            }
            System.out.println(dp[N]);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}