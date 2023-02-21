import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int V=input[0], E=input[1]; // V: 정점 개수, E: 간선 개수
            int K = Integer.parseInt(br.readLine()); // K: 시작 정점의 번호

            ArrayList<Node>[] list = new ArrayList[V+1];
            int[] result = new int[V+1];
            for(int i=0; i<=V; i++){
                list[i] = new ArrayList<>();
                result[i] = Integer.MAX_VALUE;
            }

            for(int i=0; i<E; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int u=data[0], v=data[1], w=data[2];
                list[u].add(new Node(v, w));
            }

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(K, 0));
            result[K]=0;

            boolean[] visited = new boolean[V+1];
            while(!q.isEmpty()){
                Node now = q.poll();
                if(visited[now.v]) continue;
                visited[now.v] = true;

                for(Node node : list[now.v]){
                    if(result[node.v] > result[now.v] + node.weight){
                        result[node.v] = result[now.v] + node.weight;
                        q.add(new Node(node.v, result[node.v]));
                    }
                }
            }

            for(int j=1; j<=V; j++){
                System.out.println((result[j] == Integer.MAX_VALUE) ? "INF" : result[j]);
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class Node implements Comparable<Node> {
    int v;
    int weight;

    Node(int v, int weight){
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}