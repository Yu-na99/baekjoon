import java.io.*;
import java.util.Arrays;

public class Main
{
    static int[] parent;
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            long[][] xy = new long[N+1][2];
            for(int i=0; i<N; i++){
                xy[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            }
            xy[N][0] = xy[0][0];
            xy[N][1] = xy[0][1];

            double result = 0;
            for(int i=0; i<N; i++){
                result += (xy[i][0] * xy[i+1][1]) - (xy[i+1][0] * xy[i][1]);
            }

            System.out.println(String.format("%.1f", Math.abs(result) / 2.0));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}