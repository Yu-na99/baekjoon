import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            long allS = Long.parseLong("111111111111111111111", 2);
            long S = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                long num = st.hasMoreTokens()? Long.parseLong(st.nextToken()) : 0;
                switch (command) {
                    case "add": S |= (1<<num); break;     // 0110 | 1000 = 1110
                    case "remove": S &= ~(1<<num); break; // 0110 & (~0100 => 1011) = 0010
                    case "check": bw.write(((S & (1<<num)) >> num)+"\n"); break;     // 0110 & 0100 = 0100 >> 2 = 1
                    case "toggle": S ^= (1<<num); break;
                    case "all": S = allS; break;
                    case "empty": S = 0; break;
                    default: break;
                }
            }

            bw.flush();
            bw.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}