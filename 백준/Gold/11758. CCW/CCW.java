import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long[] P1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] P2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] P3 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            System.out.println(CCW(P1[0], P1[1], P2[0], P2[1], P3[0], P3[1]));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static int CCW(long x1, long y1, long x2, long y2, long x3, long y3){
        long dir = (x1 - x2) * (y2 - y3) - (x2 - x3) * (y1 - y2);
        return dir == 0 ? 0 : ( dir > 0 ? 1 : -1 );
    }
}