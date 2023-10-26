import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main
{
    static LinkedList<Integer>[] list;
    static int[][] tree;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = getInt(st.nextToken());

            list = new LinkedList[N+1];
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int a = getInt(st.nextToken());
                int b = getInt(st.nextToken());

                if(list[a] == null) list[a] = new LinkedList<>();
                if(list[b] == null) list[b] = new LinkedList<>();
                list[a].add(b);
                list[b].add(a);
            }

            tree = new int[N+1][2]; // 0번째 부모, 1번째 깊이
            tree[1][0] = 1; tree[1][1] = 0;
            union(1, 1);

            st = new StringTokenizer(br.readLine());
            int M = getInt(st.nextToken());
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = getInt(st.nextToken());
                int b = getInt(st.nextToken());

                int result = find(a, b);
                System.out.println(result);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // String을 int형으로 반환
    static int getInt(String s){
        return Integer.parseInt(s);
    }

    // 최상위 부모를 넣어줌
    static void union(int now, int depth){
        for(int data : list[now]){
            if(tree[data][0] > 0) continue;
            tree[data][0] = now; tree[data][1] = depth;
            union(data, depth+1);
        }
    }

    static int find(int a, int b){
        if(tree[a][1] > tree[b][1]){ // 무조건 a가 높은 위치로
            int temp = a; a = b; b = temp;
        }

        // 두개의 노드 높이 맞추기
        while(tree[a][1] != tree[b][1]){
            b = tree[b][0];
        }

        // 부모가 같을떄까지
        while(a != b){
            a = tree[a][0];
            b = tree[b][0];
        }
        return a;
    }
}