import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    static int[][] memo;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);   // 자연수
            int K = Integer.parseInt(input[1]);   // 정수
            memo = new int[N+1][K+1];

            System.out.println(binomial(N, K));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int binomial(int n, int k){
        if(k == 0 || n == k) return 1;
        if(memo[n][k] == 0) memo[n][k] = binomial(n-1, k) + binomial(n-1, k-1);
        return memo[n][k];
    }
}