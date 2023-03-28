import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int maxValue = 10000000;

            // 정답 배열 생성
            int[][] result = new int[n+1][n+1];
            for(int s=0; s<=n; s++){
                for(int e=0; e<=n; e++){
                    result[s][e] = (s == e) ? 0 : maxValue;
                }
            }

            // 데이터 삽입
            for(int i=0; i<m; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int start=input[0], end=input[1], cost=input[2];
                if(result[start][end] > cost) result[start][end] = cost;
            }

            // 플로이드-워셜 알고리즘
            for(int k=1; k<=n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
                    }
                }
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    System.out.print((result[i][j] == maxValue) ? 0+" " : result[i][j]+" ");
                }
                System.out.println();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}