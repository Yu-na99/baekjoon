import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] parent;    // 부모 노드
    static int[] depth;     // 깊이
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine()); // 노드의 개수

            // 인접 리스트로 선언
            tree = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                tree[i] = new ArrayList<>();
            }
            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                tree[s].add(e);
                tree[e].add(s);
            }

            // 최대 가능 depth 구하기
            int temp = 1;
            int kmax = 0;
            while(temp <= N){
                temp <<= 1;
                kmax++;
            }

            // 부모노드와 깊이 구성하기
            parent = new int[kmax+1][N+1];
            depth = new int[N+1];
            BFS(N, 1);
            for(int k=1; k<=kmax; k++){
                for(int n=1; n<=N; n++){
                    parent[k][n] = parent[k-1][parent[k-1][n]];
                }
            }

            // 최소 공통 조상 알아내기
            int M = Integer.parseInt(br.readLine()); // 조상을 알고싶은 쌍의 개수
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bw.write(LCA(a, b, kmax)+"\n");
            }

            bw.flush();
            bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    // 부모노드와 깊이 구하기
    static void BFS(int num, int node){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[num+1];

        int level = 1;
        int nowSize = 1;
        int count = 0;

        q.add(node);
        visited[node]=true;
        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : tree[now]){
                if(visited[next]) continue;

                visited[next]=true;
                parent[0][next] = now;
                depth[next] = level;
                q.add(next);
            }

            count++;
            if(count == nowSize){
                count = 0;
                nowSize = q.size();
                level++;
            }
        }
    }

    // 최송공통조상
    static int LCA(int a, int b, int kmax){
        if(depth[a] > depth[b]){ // 더 깊은 depth가 b가 되도록 변경
            int temp = a;
            a = b;
            b = temp;
        }

        for(int k=kmax; k>=0; k--){
            if(Math.pow(2, k) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }

        for(int k=kmax; k>=0; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int result = a;
        if(a != b){
            result = parent[0][result];
        }

        return result;
    }
}