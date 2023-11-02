import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(b > a) {
                long temp = a;
                a = b;
                b = temp;
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            long len = getLCM(a, b);
            for(int i=0; i<len; i++) bw.write("1");
            bw.flush();
            bw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static long getLCM(long a, long b){
        long result = a % b;

        while(result != 0){
            a = b;
            b = result;
            result = a % b;
        }
        return b;
    }
}