import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static int end_node;

    static class Edge{
        int point;
        int weight;

        public Edge(int point, int weight){
            this.point = point;
            this.weight = weight;
        }
    }

    static class Node{
        int movePoint;
        int street;

        public Node(int movePoint, int street){
            this.movePoint = movePoint;
            this.street = street;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            list = new ArrayList[N+1]; // 정점에 연결된 인접리스트 생성

            for(int i=0; i<N; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list[input[0]] = new ArrayList<>();
                for(int j=1; j<input.length; j+=2){
                    if(input[j] == -1) break;
                    list[input[0]].add(new Edge(input[j], input[j+1]));
                }
            }

            visited = new boolean[N+1]; // 방문여부
            bfs(1);

            visited = new boolean[N+1]; // 방문여부
            System.out.println(bfs(end_node));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int bfs(int n){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        visited[n]=true;

        int maxStreet = -1;
        while(!q.isEmpty()){
            Node pop = q.poll();

            if(pop.street > maxStreet){
                maxStreet = pop.street;
                end_node = pop.movePoint;
            }

            for(Edge node: list[pop.movePoint]){
                if(visited[node.point]) continue;
                visited[node.point]=true;
                q.offer(new Node(node.point, pop.street+node.weight));
            }
        }

        return maxStreet;
    }
}