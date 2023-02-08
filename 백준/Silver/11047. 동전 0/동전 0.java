import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N=input[0], K=input[1];
            int[] A = new int[N];

            for(int i=0; i<N; i++){
                A[i]=Integer.parseInt(br.readLine());
            }

            int totalCoin = 0;
            for(int j=N-1; j>=0; j--){
                int price = A[j];
                if(price <= K){
                    totalCoin += K / price;
                    K = K % price;
                }
                if(K == 0) break;
            }
            System.out.println(totalCoin);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}