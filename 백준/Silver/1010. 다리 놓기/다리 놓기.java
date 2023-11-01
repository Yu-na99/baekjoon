import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static long[][] C;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());   // 테스트 케이스 수
            C = new long[31][31];

            StringTokenizer st;
            for(int t=0; t<T; t++){
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                // N <= M
                System.out.println(combination(M, N));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static long combination(int n, int k){
        if(k == 0 || n == k) return 1;
        if(C[n][k] == 0) C[n][k] = combination(n-1, k-1) + combination(n-1, k);
        return C[n][k];
    }
}