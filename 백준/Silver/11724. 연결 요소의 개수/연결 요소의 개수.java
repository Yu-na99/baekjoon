import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N=num[0], M=num[1]; // N: 정점개수, M: 간선개수

            // 연결 리스트 생성
            ArrayList<Integer>[] list = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<Integer>();
            }

            // 인접 리스트 데이터 추가
            for(int i=0; i<M; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int v1=data[0], v2=data[1];
                list[v1].add(v2);
                list[v2].add(v1);
            }

            int count=0;
            visited = new boolean[N+1];
            for(int i=1; i<=N; i++){
                if(visited[i]) continue;
                dfs(i, list);
                count++;
            }

            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void dfs(int num, ArrayList<Integer>[] arr){
        if(visited[num]) return;
        visited[num]=true;

        for(Integer data:  arr[num]){
            if(visited[data]) continue;
            dfs(data, arr);
        }
    }
}