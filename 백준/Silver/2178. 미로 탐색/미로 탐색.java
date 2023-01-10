import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] list;
    static boolean[][] visited;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N=input[0]; M=input[1];

            list = new boolean[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                String[] b = br.readLine().split("");
                for(int j=0; j<M; j++){
                    if(!b[j].equals("1")) continue;
                    list[i][j]=true;
                }
            }

            Queue<String> queue = new LinkedList<>();
            queue.add("0,0");
            visited[0][0]=true;
            bfs(queue, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static String[] dir = {"1,0", "-1,0", "0,1", "0,-1"};
    static void bfs(Queue<String> pQueue, int depth){
        Queue<String> cQueue = new LinkedList<>();

        while(!pQueue.isEmpty()) {
            int[] xy = Arrays.stream(pQueue.poll().split(",")).mapToInt(Integer::parseInt).toArray();
            for (String d : dir) {
                int[] dxy = Arrays.stream(d.split(",")).mapToInt(Integer::parseInt).toArray();
                int newX = xy[0]+dxy[0], newY = xy[1]+dxy[1];

                if(newX == N-1 && newY == M-1){ // 정답
                    System.out.println(depth+1);
                    return;
                }

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if (visited[newX][newY]) continue;
                if (!list[newX][newY]) continue;

                visited[newX][newY] = true;
                cQueue.offer(newX + "," + newY);
            }
        }

        if(!cQueue.isEmpty()) bfs(cQueue, depth+1);

    }
}