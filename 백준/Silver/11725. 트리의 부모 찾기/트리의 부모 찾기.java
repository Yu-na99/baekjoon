import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] result;
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            tree = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                tree[i] = new ArrayList<>();
            }

            // 링크 걸기
            for(int i=0; i<N-1; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                tree[a].add(b);
                tree[b].add(a);
            }

            visited = new boolean[N+1];
            result = new int[N+1];
            visited[1] = true;
            DFS(1);

            for(int i=2; i<=N; i++){
                System.out.println(result[i]);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static void DFS(int node){
        for(Integer data : tree[node]){
            if(visited[data]) continue;
            visited[data] = true;
            result[data] = node;
            DFS(data);
        }
    }

}