import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 도시의 수
            long[][][] dp = new long[N+1][10][1<<10];
            for(int i=1; i<10; i++) dp[0][i][1<<i] = 1;

            // 이해 못하는 코드..
            for(int i=1; i<N; i++){
                for(int j=0; j<10; j++){
                    for(int bit=0; bit<1024; bit++){
                        if(j-1 >= 0) dp[i][j][bit | (1<<j)] += dp[i-1][j-1][bit];
                        if(j+1 <= 9) dp[i][j][bit | (1<<j)] += dp[i-1][j+1][bit];
                        dp[i][j][bit|(1<<j)] %= 1000000000;
                    }
                }
            }

            long result = 0l;
            for(int i=0; i<10; i++){
                result += dp[N-1][i][1023];
                result %= 1000000000;
            }
            System.out.println(result);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}