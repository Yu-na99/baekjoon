import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int N=input[0], M=input[1];
            long result=0L;
            long[] acc = new long[N];
            long[] count = new long[M];

            acc[0] = A[0] % M;
            if(acc[0] == 0) result++;
            count[(int)acc[0]]++;

            for(int i=1; i<N; i++){
                acc[i] = (acc[i-1] + A[i]) % M;
                if(acc[i] == 0) result++;
                count[(int)acc[i]]++;
            }

            for(int i=0; i<M; i++){
                if(count[i] <= 1) continue;
                result += (count[i]*(count[i]-1))/2;
            }

            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}