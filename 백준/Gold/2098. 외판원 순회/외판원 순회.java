import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    private static int N;       // 도시의 수
    private static int[][] W;   // 비용
    private static int[][] dp;
    private static final int INF = 1000000*16+1;
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;
            N = Integer.parseInt(br.readLine());

            W = new int[16][16];
            dp = new int[16][1<<16];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<N; j++){
                    W[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(tsp(0, 1));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private static int tsp(int node, int visited) {
        // 모든 노드를 방문한 경우
        if(visited == (1<<N)-1) return W[node][0] == 0 ? INF : W[node][0];

        // 이미 방문한 노드의 경우
        if(dp[node][visited] != 0) return dp[node][visited];

        int min_val = INF;
        for(int i=0; i<N; i++){
            if((visited & (1 << i)) == 0 && W[node][i] != 0){ // 방문한 적이 없고 갈 수 있는 도시인 경우
                min_val = Math.min(min_val, tsp(i, (visited | (1 << i))) + W[node][i]);
            }
        }

        dp[node][visited] = min_val;
        return dp[node][visited];
    }
}