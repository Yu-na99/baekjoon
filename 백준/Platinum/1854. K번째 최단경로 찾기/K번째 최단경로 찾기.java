import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n=input[0], m=input[1], k=input[2];

            // 우선순위큐를 k의 크기만큼 n개 생성
            PriorityQueue<Integer>[] resultQ = new PriorityQueue[n+1];
            for(int i=0; i<=n; i++){
                resultQ[i] = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
            }

            // 인접 행렬에 데이터 저장
            ArrayList<Node>[] list = new ArrayList[n+1];
            for(int i=0; i<m; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a=data[0], b=data[1], c=data[2];
                if(list[a] == null) list[a] = new ArrayList<>();
                list[a].add(new Node(b, c));
            }

            // 최단거리 계산
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(1, 0));
            resultQ[1].add(0);

            while(!q.isEmpty()){
                Node now = q.poll();
                if(list[now.node] == null) continue;
                for(Node no : list[now.node]){
                    if(resultQ[no.node].size() < k) {
                        resultQ[no.node].add(now.cost + no.cost);
                        q.add(new Node(no.node, now.cost + no.cost));
                    } else {
                        if(resultQ[no.node].peek() > now.cost + no.cost){
                            resultQ[no.node].poll();
                            resultQ[no.node].add(now.cost + no.cost);
                            q.add(new Node(no.node, now.cost + no.cost));
                        }
                    }
                }
            }

            for(int i=1; i<=n; i++){
                if(resultQ[i].size() == k){
                    bw.write(resultQ[i].peek()+"\n");
                } else {
                    bw.write("-1\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;

    Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}