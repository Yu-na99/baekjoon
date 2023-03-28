import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = input[0], e = input[1];

            // 유니온 파인드
            parent = new int[n+1];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }

            // 정렬 큐에 넣음
            PriorityQueue<pEdge> queue = new PriorityQueue<>();
            for(int i=0; i<e; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                queue.add(new pEdge(data[0], data[1], data[2]));
            }

            // 최소 신장 트리
            int useEdge = 0;
            int result = 0;
            while(useEdge < n - 1) {
                pEdge now = queue.poll();
                if(find(now.s) != find(now.e)){
                    union(now.s, now.e);
                    result += now.v;
                    useEdge++;
                }

            }

            System.out.println(result);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    static int find(int num){
        if(num == parent[num])
            return num;
        else
            return parent[num] = find(parent[num]);
    }

    static class pEdge implements Comparable<pEdge> {
        int s;
        int e;
        int v;

        pEdge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(pEdge o){
            return this.v - o.v;
        }
    }
}