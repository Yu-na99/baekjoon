import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            ArrayList<ArrayList<Integer>> A = new ArrayList<>();
            for(int i=0; i<=N; i++){
                A.add(new ArrayList<>());
            }

            int[] indegree = new int[N+1];  // 진입차수 배열
            int[] selfBuild = new int[N+1]; // 자기자신을 짓는데 걸리는 시간
            for(int i=1; i<=N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                selfBuild[i] = Integer.parseInt(st.nextToken());
                while(true){
                    int preTemp = Integer.parseInt(st.nextToken());
                    if(preTemp == -1) break;

                    A.get(preTemp).add(i);
                    indegree[i]++;
                }
            }

            // 위상 정렬
            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=N; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }

            int[] result = new int[N+1];
            while(!q.isEmpty()){
                int now = q.poll();
                for(int next : A.get(now)){
                    indegree[next]--;
                    result[next] = Math.max(result[next], result[now] + selfBuild[now]);

                    if(indegree[next] == 0){
                        q.offer(next);
                    }
                }
            }

            for(int i=1; i<=N; i++){
                System.out.println(result[i] + selfBuild[i]);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}