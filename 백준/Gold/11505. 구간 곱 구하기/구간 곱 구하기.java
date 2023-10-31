import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static long[] tree;
    static final long MOD = 1000000007;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);   // 수의 개수
            int M = Integer.parseInt(input[1]);   // 변경이 일어나는 횟수
            int K = Integer.parseInt(input[2]);   // 구간의 곱을 구하는 횟수

            // 트리 높이 구하기
            int treeHeight = 0; int length = N;
            while(length != 0){
                length /= 2;
                treeHeight++;
            }

            // 트리 초기화
            int treeSize = (int)Math.pow(2, treeHeight+1);
            int leftNodeStartIndex = treeSize / 2 - 1;
            tree = new long[treeSize + 1];
            for(int i=0; i<tree.length; i++) tree[i] = 1;
            for(int j=leftNodeStartIndex+1; j<=leftNodeStartIndex+N; j++) tree[j] = Long.parseLong(br.readLine());

            setTree(treeSize - 1);

            StringTokenizer st;
            for(int z=0; z<M+K; z++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());

                if(a == 1) changeVal(leftNodeStartIndex+b, c);
                else {
                    b += leftNodeStartIndex;
                    c += leftNodeStartIndex;
                    System.out.println(getMul(b, (int)c));
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void setTree(int i){
        while(i != 1){
            tree[i/2] = tree[i/2] * tree[i] % MOD;
            i--;
        }
    }

    private static void changeVal(int index, long val){
        tree[index] = val;
        while(index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    private static long getMul(int b, int c){
        long partMul = 1;
        while (b <= c) {
            if (b % 2 == 1) {
                partMul = partMul * tree[b] % MOD;
                b++;
            }
            if (c % 2 == 0) {
                partMul = partMul * tree[c] % MOD;
                c--;
            }
            b /= 2;
            c /= 2;
        }
        return partMul;
    }
}