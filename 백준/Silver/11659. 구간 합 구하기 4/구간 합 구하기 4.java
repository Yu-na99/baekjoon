import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int N=input[0], M=input[1];
            int[] acc = new int[N]; acc[0]=data[0];
            for(int i=1; i<N; i++){
                acc[i] += acc[i-1] + data[i]; // 누적 합
            }

            for(int j=0; j<M; j++){
                int[] index = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.out.println(acc[index[1]-1] - acc[index[0]-1] + data[index[0]-1]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}