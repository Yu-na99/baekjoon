import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            ArrayList<Work> work = new ArrayList<>();
            for(int i=0; i<N; i++){
                int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                work.add(new Work(info[0], info[1]));
            }

            int result = Integer.MIN_VALUE;
            int[] dp = new int[N+1];
            for(int i=N-1; i>=0; i--){
                Work w = work.get(i);
                int nextPeriod = i + w.period;
                if(nextPeriod <= N) {
                    dp[i] = Math.max(w.price + dp[nextPeriod], dp[i+1]);
                } else {
                    dp[i] = dp[i+1];
                }

                result = Math.max(dp[i], result);
            }

            System.out.println(result);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

class Work {
    int period;
    int price;

    Work(int period, int price){
        this.period = period;
        this.price = price;
    }
}