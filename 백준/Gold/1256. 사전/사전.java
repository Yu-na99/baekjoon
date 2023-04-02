import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N=input[0], M=input[1], K=input[2];
            int NM = N + M;

            // 조합 테이블 생성
            int[][] D = new int[NM+1][NM+1];
            for(int i=0; i<=NM; i++){
                for(int j=0; j<=i; j++){
                    if(j == 0 || j == i) D[i][j]=1;
                    else {
                        D[i][j] = D[i-1][j] + D[i-1][j-1];
                        if(D[i][j] > 1000000000) D[i][j] = 1000000001;
                    }
                }
            }

            if(D[NM][M] < K) System.out.println(-1);
            else {
                while(!(N==0 && M==0)){
                    if(D[N-1+M][M] >= K){
                        System.out.print("a");
                        N--;
                    } else {
                        System.out.print("z");
                        K=K-D[N-1+M][M];    // K값 업데이트
                        M--;
                    }
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}