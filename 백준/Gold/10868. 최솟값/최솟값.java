import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static long[] tree;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);   // 수의 개수
            int M = Integer.parseInt(input[1]);   // 쌍의 개수

            // 트리 생성
            int treeHeight = 0; int temp=N;
            while(temp != 0) {
                temp /= 2;
                treeHeight++;
            }
            int treeSize = (int)Math.pow(2, treeHeight+1);
            int leftNodeIndex = treeSize / 2 - 1;
            tree = new long[treeSize+1];
            for(int i=0; i<=treeSize; i++) tree[i] = Long.MAX_VALUE;
            for(int i=leftNodeIndex+1; i<=leftNodeIndex+N; i++) tree[i] = Long.parseLong(br.readLine());
            init(treeSize);

            StringTokenizer st;
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                s += leftNodeIndex;
                e += leftNodeIndex;
                System.out.println(getMin(s, e));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static void init(int index){
        while(index != 1){
            tree[index/2] = Math.min(tree[index/2], tree[index]);
            index--;
        }
    }

    static long getMin(int s, int e){
        long Min = Long.MAX_VALUE;
        while(s <= e){
            if(s % 2 == 1) {
                Min = Math.min(Min, tree[s]);
                s++;
            }
            if(e % 2 == 0) {
                Min = Math.min(Min, tree[e]);
                e--;
            }

            s /= 2;
            e/=2;
        }
        return Min;
    }
}