import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int[][] C;
    static final int MOD = 10007;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            C = new int[N+1][K+1];
            System.out.println(combination(N, K));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int combination(int n, int k){
        if(k == 0 || n == k) return 1;
        if(C[n][k] == 0) C[n][k] = ((combination(n-1, k-1) % MOD) + (combination(n-1, k) % MOD)) % MOD;
        return C[n][k];
    }
}