import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    static double[][] C;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int M = Integer.parseInt(br.readLine());   // 조약돌 색상 수
            int[] Ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 각 색상 수
            int K = Integer.parseInt(br.readLine());   // 선택한 조약돌

            int size = 0;
            for(int i=0; i<Ns.length; i++) size += Ns[i];

            C = new double[size+1][K+1];
            double result = 0.0;
            for(int j=0; j<M; j++){
                if(Ns[j] < K) continue;
                result += combination(Ns[j], K);
            }

            System.out.println(result / combination(size, K));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static double combination(int n, int k){
        if(k == 0 || n == k) return 1;
        if(C[n][k] == 0) C[n][k] = combination(n-1, k-1) + combination(n-1, k);
        return C[n][k];
    }
}