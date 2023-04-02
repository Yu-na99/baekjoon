import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[][] D = new long[N+1][2];
            D[1][1]=1;
            D[1][0]=0;

            for(int i=2; i<=N; i++){
                D[i][0] = D[i-1][0] + D[i-1][1];
                D[i][1] = D[i-1][0];
            }

            System.out.println(D[N][0]+D[N][1]);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}