import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n=input[0], m=input[1];

            num = new int[n+1];
            for(int i=0; i<=n; i++){
                num[i]=i;
            }

            for(int i=0; i<m; i++){
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if(data[0]==0) union(data[1], data[2]);
                else System.out.println(find(data[1]) == find(data[2]) ? "YES" : "NO");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa != bb) num[bb]=aa;
    }

    static int find(int n){
        if(num[n] == n){
            return n;
        } else {
            return num[n] = find(num[n]);
        }
    }
}