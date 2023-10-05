import java.io.*;

public class Main
{
    static long[] memo;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            if(N == 0L) { System.out.println(0); return; }

            memo = new long[N+1];
            memo[0]=0; memo[1]=1;
            System.out.println(fibo(N));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    static long fibo(int n) {
        if(n < 2) return n;
        if(memo[n] != 0) return memo[n];
        else return memo[n] = fibo(n-1) + fibo(n-2);
    }
}