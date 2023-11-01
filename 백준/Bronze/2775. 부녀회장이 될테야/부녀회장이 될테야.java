import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    static int[][] memo;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());   // 테스트 케이스 수

            memo = new int[15][15];
            for(int i=1; i<15; i++) memo[0][i] = i;
            for(int t=0; t<T; t++){
                int k = Integer.parseInt(br.readLine());   // 층
                int n = Integer.parseInt(br.readLine());   // 호

                System.out.println(getPeople(k, n));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int getPeople(int k, int n){
        if(n == 1) return 1;
        if(memo[k][n] > 0) return memo[k][n];

        int result = 0;
        for(int i=1; i<=n; i++){
            result += getPeople(k-1, i);
        }
        return memo[k][n] = result;
    }
}