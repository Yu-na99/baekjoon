import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N=input[0], V=input[2]; // N: 정점 개수, M: 간선 개수, V: 탐색 시작할 정점의 번호

            list = new ArrayList[N+1];
            for(int i=0; i<input[1]; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a=data[0], b=data[1];

                if(list[a] == null) list[a] = new ArrayList<>();
                if(list[b] == null) list[b] = new ArrayList<>();

                list[a].add(b);
                list[b].add(a);
            }
            if(list[V] == null){
                System.out.println(V);
                System.out.println(V);
            }else{
                System.out.print(V+" ");
                dfs(V, new boolean[N+1]);
                System.out.print("\n"+V+" ");
                bfs(V, new boolean[N+1]);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void dfs(int node, boolean[] visited){
        visited[node]=true;
        Collections.sort(list[node]);
        for(int n: list[node]){
            if(visited[n]) continue;
            visited[n]=true;

            System.out.print(n+" ");
            dfs(n, visited);
        }
    }

    static void bfs(int node, boolean[] visited){
        visited[node]=true;

        Queue<Integer> queue = new LinkedList<>();
        for(int n: list[node]){
            queue.add(n);
        }

        while(!queue.isEmpty()){
            int pop = queue.poll();
            if(visited[pop]) continue;

            visited[pop] = true;
            System.out.print(pop+" ");
            for(int p: list[pop]){
                if(visited[p]) continue;

                queue.add(p);
            }
        }
    }
}