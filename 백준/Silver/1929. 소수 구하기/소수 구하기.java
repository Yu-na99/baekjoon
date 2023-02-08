import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M=input[0], N=input[1];

            boolean[] arr = new boolean[N+1];
            arr[0]=true; arr[1]=true; // 소수가 아님
            for(int i=2; i<=Math.sqrt(N); i++){
                if(arr[i]) continue;

                for(int j=i+i; j<=N; j=j+i ){
                    arr[j]=true;
                }
            }

            for(int i=M; i<=N; i++){
                if(!arr[i]) System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}