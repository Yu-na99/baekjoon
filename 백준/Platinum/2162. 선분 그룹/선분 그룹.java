import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
    static int[] parent;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            parent = new int[N];
            for(int n=0; n<N; n++){
                parent[n] = -1;
            }

            long[][] line = new long[N][4];
            for(int i=0; i<N; i++){
                line[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
                for(int j=0; j<i; j++){
                    if(isCross(line[i][0], line[i][1], line[i][2], line[i][3], line[j][0], line[j][1], line[j][2], line[j][3])){
                        union(i, j);
                    }
                }
            }

            int ans=0, res=0;
            for(int i=0; i<N; i++){
                if(parent[i] < 0) {
                    ans++;
                    res = Math.min(res, parent[i]);
                }
            }

            System.out.println(ans);
            System.out.println(-res);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int find(int i){
        if(parent[i] < 0) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int i, int j){
        int p = find(i);
        int q = find(j);
        if(p == q) return;

        parent[p] += parent[q];
        parent[q] = p;
    }

    static int CCW(long x1, long y1, long x2, long y2, long x3, long y3){
        long dir = (x1 - x2) * (y2 - y3) - (x2 - x3) * (y1 - y2);
        return dir == 0 ? 0 : ( dir > 0 ? 1 : -1 );
    }

    static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        return (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
                Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2));
    }

    static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        // a=(x1, y1), b=(x2, y2), c=(x3, y3), d=(x4, y4)
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);

        if(abc * abd == 0 && cda * cdb == 0) {
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        } else if(abc * abd <= 0 && cda * cdb <= 0) {
            return true;
        }
        return false;
    }
}