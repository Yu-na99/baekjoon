import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] friend;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N=input[0]; int M=input[1]; // N: 사람의 수, M: 친구 관계의 수

            friend = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                friend[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a=data[0], b=data[1];
                friend[a].add(b);
                friend[b].add(a);
            }

            int result = 0;
            visited = new boolean[N];
            for(int i=0; i<N; i++){
                visited[i]=true;
                if(dfs(i, 1)){
                   result=1; break;
                }
                visited[i]=false;
            }

            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    static boolean dfs(int start, int depth){
        if(depth == 5) return true;

        for(int s: friend[start]){
            if(visited[s]) continue;

            visited[s]=true;
            if(dfs(s, depth+1)) return true;
            visited[s]=false;
        }

        return false;
    }
}