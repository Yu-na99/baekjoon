import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);

            int[][] m = new int[][] {{0, 2, 2, 2, 2},
                                     {2, 1, 3, 4, 3},
                                     {2, 3, 1, 3, 4},
                                     {2, 4, 3, 1, 3},
                                     {2, 3, 4, 3, 1}};

            int[][][] dp = new int[100001][5][5]; // dp[N][left][right]
            for(int i=0; i<5; i++)
                for(int j=0; j<5; j++)
                    for(int k=0; k<100001; k++)
                        dp[k][i][j] = 100001 * 4;
            dp[0][0][0] = 0;

            int n=0, s=1;
            while(true){
                n = sc.nextInt();
                if(n == 0) break;

                for(int i=0; i<5; i++){
                    if(n == i) continue; // 두 발이 같은 곳에 있을 수 없데
                    for(int j=0; j<5; j++){
                        dp[s][i][n] = Math.min(dp[s-1][i][j] + m[j][n], dp[s][i][n]); // 오른발
                        dp[s][n][i] = Math.min(dp[s-1][j][i] + m[j][n], dp[s][n][i]); // 왼발
                    }
                }

                s++;
            }

            int min = Integer.MAX_VALUE;
            for(int i=0; i<5; i++)
                for(int j=0; j<5; j++)
                    min = Math.min(min, dp[s-1][i][j]);

            System.out.println(min);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // 같은 지점 : 1
    // 중앙에서 : 2
    // 인접한 지점에서 : 3
    // 반대편으로 : 4
}